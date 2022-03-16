package eyeq.alchemy.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.text.Html.ImageGetter
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import eyeq.alchemy.BuildConfig
import eyeq.alchemy.R
import eyeq.alchemy.game.*
import eyeq.util.trimTrailingWhitespace
import kotlin.math.abs

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private enum class SortOrder(val textId: Int) {
        DEFAULT(R.string.sort_default),
        ORDINAL(R.string.sort_ordinal),
        ALPHABET(R.string.sort_alphabet),
        EMOJI_CODE(R.string.sort_emoji_code),
        UNLOCKED_RECIPES(R.string.sort_unlocked_recipes),
        DISCOVERED(R.string.sort_discovered),
        LAST_USED(R.string.sort_last_used),
        ;
    }

    private var mGestureDetector: GestureDetector? = null

    private var mRewardedAd: RewardedAd? = null

    private val game = Game()

    override fun onStart() {
        super.onStart()

        val context: Context = this
        val userSettings: SharedPreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE)
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        fun isFilter(): Boolean {
            return try {
                userSettings.getBoolean("isFilter", false)
            } catch (e: Throwable) {
                false
            }
        }
        fun setIsFilter(value: Boolean) {
            userSettings.edit().putBoolean("isFilter", value).apply()
        }

        fun getSelectedSort(): SortOrder {
            return try {
                SortOrder.values().first { it.name == userSettings.getString("selectedSort", SortOrder.DEFAULT.name) }
            } catch (e:Throwable) {
                SortOrder.DEFAULT
            }
        }
        fun setSelectedSort(value: SortOrder) {
            userSettings.edit().putString("selectedSort", value.name).apply()
        }

        fun getSelectedTab(): Group {
            return try {
                Group.values().first { it.name == userSettings.getString("selectedTab", Group.ALL.name) }
            } catch (e:Throwable) {
                Group.ALL
            }
        }
        fun setSelectedTab(value: Group) {
            userSettings.edit().putString("selectedTab", value.name).apply()
        }

        val hintTextView = findViewById<TextView>(R.id.hint)
        val searchView = findViewById<SearchView>(R.id.search)
        val countTextView = findViewById<TextView>(R.id.count)
        val sort = findViewById<FrameLayout>(R.id.sort)
        val menu = findViewById<FrameLayout>(R.id.menu)

        val subHeader = findViewById<LinearLayout>(R.id.sub_header)
        subHeader.visibility = View.GONE

        val checkbox = findViewById<CheckBox>(R.id.filter_checkbox)
        checkbox.isChecked = isFilter()

        val spinner = findViewById<Spinner>(R.id.sort_spinner)
        val sortList = SortOrder.values().map { getText(it.textId).toString() }
        val spinnerAdapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, sortList.toTypedArray())
        spinner.adapter = spinnerAdapter
        spinner.setSelection(SortOrder.values().indexOf(getSelectedSort()))

        val main = supportFragmentManager.findFragmentById(R.id.main) as ItemFragment
        main.view?.setBackgroundColor(getColor(R.color.black))
        main.tabTextColorNormal = getColor(R.color.silver)
        main.tabTextColorSelected = getColor(R.color.white)
        main.tabBackgroundColor = getColor(R.color.sumi)
        main.tabBackgroundNormal = ContextCompat.getDrawable(context, R.color.kuro)
        main.tabBackgroundSelected = ContextCompat.getDrawable(context, R.color.sumi)

        val balloon = supportFragmentManager.findFragmentById(R.id.balloon) as BalloonFragment

        val fab = supportFragmentManager.findFragmentById(R.id.fab) as FabFragment

        val left = supportFragmentManager.findFragmentById(R.id.left) as HintFragment
        left.view?.setBackgroundColor(getColor(R.color.kuro))
        left.view?.visibility = View.GONE

        val right = supportFragmentManager.findFragmentById(R.id.right) as HistoryFragment
        right.view?.setBackgroundColor(getColor(R.color.kuro))
        right.view?.visibility = View.GONE

        mGestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            private val SWIPE_MIN_Y = 120f.dpToPx()
            private val SWIPE_VELOCITY_THRESHOLD = 100
            private val SWIPE_THRESHOLD = 100

            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                if (SWIPE_MIN_Y < e1.y && SWIPE_MIN_Y < e2.y) {
                    val diffY = e2.y - e1.y
                    val diffX = e2.x - e1.x
                    if (abs(diffX) > abs(diffY)) {
                        if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX > 0) {
                                if(right.view?.visibility == View.VISIBLE) {
                                    right.view?.visibility = View.GONE
                                } else {
                                    left.view?.visibility = View.VISIBLE
                                }
                            } else {
                                if( left.view?.visibility == View.VISIBLE) {
                                    left.view?.visibility = View.GONE
                                } else {
                                    right.view?.visibility = View.VISIBLE
                                }
                            }
                        }
                    }
                }

                return@onFling true
            }
        })

        val selectItem = fun(item: Item) {
            if (game.item1 == Item.EMPTY) {
                game.item1 = item
            } else if (game.item2 == Item.EMPTY) {
                game.item2 = item
            }
            updatePot(fab)
        }

        val unlock = fun(history: History) {
            val results = game.unlock(history)
            if (results.isEmpty()) {
                fab.vibrate()
            } else {
                for (recipe in results) {
                    balloon.addBalloon(recipe)
                }

                game.item1 = Item.EMPTY
                game.item2 = Item.EMPTY
            }
            updateCount(countTextView, getSelectedTab())
            updateFlex(main, searchView.query, isFilter(), getSelectedSort(), getSelectedTab())
            updatePot(fab)
            updateHint(hintTextView, left, game.getHints(dataStore))
            updateHistory(right)

            game.save(dataStore)
        }

        val popup = PopupMenu(context, menu)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            popup.menu.setGroupDividerEnabled(true)
        }
        popup.menu.add(1, 1, 1, R.string.menu_restart)
        popup.menu.add(2, 2, 2, R.string.menu_hint)
        popup.menu.add(2, 3, 3, R.string.menu_history)
        popup.menu.add(3, 4, 4, R.string.menu_credit)
        popup.menu.add(3, 5, 5, R.string.menu_version)
        popup.setOnMenuItemClickListener {
            when (it!!.itemId) {
                1 -> {
                    val builder = AlertDialog.Builder(context)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Confirm")
                        .setMessage("Are you sure you want to delete discovered items?")
                        .setPositiveButton("restart") { dialog, id ->
                            game.clear()

                            updateCount(countTextView, getSelectedTab())
                            updateFlex(main, searchView.query, isFilter(), getSelectedSort(), getSelectedTab())
                            updatePot(fab)
                            updateHint(hintTextView, left, game.getHints(dataStore))
                            updateHistory(right)
                        }
                        .setNegativeButton("cancel") { dialog, id -> }

                    builder.show()
                }
                2 -> {
                    left.view?.visibility = View.VISIBLE
                    right.view?.visibility = View.GONE
                }
                3 -> {
                    left.view?.visibility = View.GONE
                    right.view?.visibility = View.VISIBLE
                }
                4 -> {
                    CreditDialogFragment().show(supportFragmentManager, "simple")
                }
                5 -> {
                    val recipeCount = Recipe.getCount()
                    val itemCount = Item.values().filter { item -> Recipe.canMake(item) }.count()
                    VersionDialogFragment(recipeCount, itemCount).show(supportFragmentManager, "simple")
                }
            }

            true
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                updateFlex(main, searchView.query, isFilter(), getSelectedSort(), getSelectedTab())
                return false
            }
        })

        sort.isClickable = true
        sort.setOnClickListener {
            if (subHeader.visibility == View.GONE) {
                subHeader.visibility = View.VISIBLE
            } else {
                subHeader.visibility = View.GONE
            }
        }

        menu.isClickable = true
        menu.setOnClickListener {
            popup.show()
        }

        checkbox.setOnCheckedChangeListener { button, isChecked ->
            setIsFilter(isChecked)
            updateFlex(main, searchView.query, isFilter(), getSelectedSort(), getSelectedTab())
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                setSelectedSort(SortOrder.values()[position])
                updateFlex(main, searchView.query, isFilter(), getSelectedSort(), getSelectedTab())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        main.tabSelectedListener = object : ItemFragment.OnTabSelectedListener {
            override fun onTabSelected(group: Group) {
                setSelectedTab(group)
                updateCount(countTextView, getSelectedTab())
            }
        }
        main.itemClickListener = object : ItemFragment.OnItemClickListener {
            override fun onClick(item: Item) {
                selectItem(item)
            }
        }
        main.itemLongClickListener = object : ItemFragment.OnItemLongClickListener {
            override fun onLongClick(item: Item): Boolean {
                val recipeList = game.getUnlockedRecipeList()
                val itemStack = ArrayDeque<Item>()
                itemStack.add(item)

                RecipeDialogFragment(recipeList, itemStack, getColor(R.color.black)).show(supportFragmentManager, "simple")
                return true
            }
        }

        fab.setImage1OnClickListener {
            game.item1 = Item.EMPTY
            updatePot(fab)
        }
        fab.setImage2OnClickListener {
            game.item2 = Item.EMPTY
            updatePot(fab)
        }
        fab.setCleanOnClickListener {
            game.item1 = Item.EMPTY
            game.item2 = Item.EMPTY
            updatePot(fab)
        }
        fab.setConvertOnClickListener {
            unlock(History(game.item1, game.item2, game.item3))
        }

        left.setAdsOnClickListener {
            initAds(context, true)
            if (mRewardedAd != null) {
                mRewardedAd?.setFullScreenContentCallback(object : FullScreenContentCallback() {
                    override fun onAdShowedFullScreenContent() {
                    }

                    override fun onAdDismissedFullScreenContent() {
                        mRewardedAd = null
                        Toast.makeText(context, "Failed to watch ads.", Toast.LENGTH_LONG).show()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        mRewardedAd = null
                        Toast.makeText(context, "Failed to watch ads.", Toast.LENGTH_LONG).show()
                    }
                })

                mRewardedAd?.show(this) {
                    game.addHints(dataStore, it.amount)
                    updateHint(hintTextView, left, game.getHints(dataStore))
                }
            }
        }
        left.setHintOnClickListener {
            if (!game.isHintable()) {
                Toast.makeText(context, "You already have all hints.", Toast.LENGTH_LONG).show()
                return@setHintOnClickListener
            }

            if (!game.addHints(dataStore, -1)) {
                Toast.makeText(context, "You need to watch ads.", Toast.LENGTH_LONG).show()
                return@setHintOnClickListener
            }

            game.hint()
            updateHint(hintTextView, left, game.getHints(dataStore))

            game.save(dataStore)
        }
        left.itemClickListener = object : HintFragment.OnItemClickListener {
            override fun onClick(recipe: Recipe) {
                val enabled = recipe.inputs.all { item -> game.isUnlocked(item) }
                if (!enabled) {
                    return@onClick
                }

                val count = recipe.inputs.distinct().count()
                val cost = count * count

                val html = "<p>Are you sure you want to see the answer?</p>" +
                        "<img src='${R.drawable.symbol_hint}'>-${cost}"

                val imageGetter = ImageGetter {
                    val drawable = ResourcesCompat.getDrawable(resources, it.toInt(), null)
                    drawable?.setBounds(0, 0, 40, 40)
                    drawable
                }

                val builder = AlertDialog.Builder(context)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Confirm")
                    .setMessage(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT, imageGetter, null)
                        .trimTrailingWhitespace())
                    .setPositiveButton("unlock") { dialog, id ->
                        if (!game.addHints(dataStore, -cost)) {
                            Toast.makeText(context, "You need to watch ads.", Toast.LENGTH_LONG).show()
                            return@setPositiveButton
                        }

                        unlock(History(
                            recipe.inputs.getOrElse(0) { Item.EMPTY },
                            recipe.inputs.getOrElse(1) { Item.EMPTY },
                            recipe.inputs.getOrElse(2) { Item.EMPTY }))
                    }
                    .setNegativeButton("cancel") { dialog, id -> }

                builder.show()
            }
        }

        right.itemClickListener = object : HistoryFragment.OnItemClickListener {
            override fun onClick(item: Item) {
                selectItem(item)
            }
        }

        // init
        val newUnlocked = game.load(dataStore)
        if (newUnlocked.isNotEmpty()) {
            UnlockedDialogFragment(newUnlocked, getColor(R.color.black)).show(supportFragmentManager, "simple")
        }

        updateCount(countTextView, getSelectedTab())
        updateFlex(main, searchView.query, isFilter(), getSelectedSort(), getSelectedTab())
        updatePot(fab)
        updateHint(hintTextView, left, game.getHints(dataStore))
        updateHistory(right)

        Handler(Looper.getMainLooper()).postDelayed({ initAds(context, false) }, 1000)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        mGestureDetector?.onTouchEvent(ev)
        return super.dispatchTouchEvent(ev)
    }

    private fun initAds(context: Context, isMessage: Boolean) {
        if (mRewardedAd != null) {
            return
        }
        RewardedAd.load(context, BuildConfig.ADS_UNIT_ID, AdRequest.Builder().build(), object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                if(isMessage) {
                    Toast.makeText(context, adError.message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onAdLoaded(rewardedAd: RewardedAd) {
                mRewardedAd = rewardedAd
            }
        })
    }

    private fun updateHint(hintTextView: TextView, hintFragment: HintFragment, hints: Int) {
        hintTextView.text = hints.toString()

        val hintList = game.getHintList().map { Recipe.getRecipeListByResult(it).first() }
        val backgroundColorList = hintList.map { it.inputs.all { item -> game.isUnlocked(item) } }
            .map { if (it) getColor(R.color.sumi) else getColor(R.color.kuro) }
        hintFragment.update(hintList, backgroundColorList)
    }

    private fun updateCount(countTextView: TextView, selectedTab: Group) {
        val filteredItem = Item.values().filter { Recipe.canMake(it) }
            .filter { selectedTab == Group.ALL || selectedTab == it.group }
        val unlockedItem = game.getUnlockedItemList()
            .filter { selectedTab == Group.ALL || selectedTab == it.group }

        countTextView.text = "${unlockedItem.count()}/${filteredItem.count()}"
    }

    private fun updateFlex(main: ItemFragment, query: CharSequence, isFilter: Boolean, selectedSortOrder: SortOrder, selectedTab: Group) {
        var itemList = game.getUnlockedItemList()

        itemList = itemList.filter { getText(it.textId).contains(query, true) }

        if (isFilter) {
            itemList = itemList.filter { Recipe.recipes.any { recipe -> recipe.inputs.contains(it) } }
        }

        when (selectedSortOrder) {
            SortOrder.ORDINAL -> {
                itemList = itemList.sortedWith(compareBy<Item> {
                    val recipeList = game.getUnlockedRecipeList()

                    var i = 0
                    val inputs = mutableListOf(it)
                    while (!inputs.contains(Item.ELEMENTAL_VOID)) {
                        inputs.addAll(recipeList.filter { recipe -> inputs.contains(recipe.result) }
                            .flatMap { recipe -> recipe.inputs })
                        i += 1
                    }
                    i
                })
            }
            SortOrder.ALPHABET -> {
                itemList = itemList.sortedWith(compareBy { getText(it.textId).toString() })
            }
            SortOrder.EMOJI_CODE -> {
                itemList = itemList.sortedWith(compareBy {
                    val text = resources.getResourceEntryName(it.resId).toString()
                    if (text.startsWith("emoji")) text else "z"
                })
            }
            SortOrder.UNLOCKED_RECIPES -> {
                itemList = itemList.sortedWith(compareByDescending { game.getUnlockedRecipeList().count { recipe -> recipe.inputs.contains(it) } })
            }
            SortOrder.DISCOVERED -> {
                itemList = itemList.sortedWith(compareBy {  game.getHistoryRecipeList().indexOfFirst { recipe -> recipe.result == it } })
            }
            SortOrder.LAST_USED -> {
                itemList = itemList.sortedWith(compareByDescending { game.getHistoryList().indexOfLast { history -> history.item1 == it || history.item2 == it || history.item3 == it } })
            }
        }

        main.update(game.getUnlockedGroupList(), itemList, 168f.dpToPx().toInt(), selectedTab)
    }

    private fun updatePot(fabFragment: FabFragment) {
        val isDone = game.getHistoryList().contains(History(game.item1, game.item2, game.item3))
        val recipes = Recipe.getRecipeListByInputs(game.item1, game.item2, game.item3)
        fabFragment.update(isDone, recipes.map { it.result }, game.item1, game.item2)
    }

    private fun updateHistory(historyFragment: HistoryFragment) {
        val historyList = game.getHistoryList().reversed()
        historyFragment.update(historyList)
    }

    private fun Float.pxToDp(): Float = (this / resources.displayMetrics.density)
    private fun Float.dpToPx(): Float = (this * resources.displayMetrics.density)

    private fun Float.pxToSp(): Float = (this / resources.displayMetrics.scaledDensity)
    private fun Float.spToPx(): Float = (this * resources.displayMetrics.scaledDensity)
}