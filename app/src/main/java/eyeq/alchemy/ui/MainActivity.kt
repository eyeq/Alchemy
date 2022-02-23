package eyeq.alchemy.ui

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.text.Html.ImageGetter
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.material.tabs.TabLayout
import eyeq.alchemy.BuildConfig
import eyeq.alchemy.R
import eyeq.alchemy.game.*
import eyeq.util.CharSequenceExtensions
import kotlin.math.abs

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var mGestureDetector: GestureDetector? = null

    private var mRewardedAd: RewardedAd? = null

    private val game = Game()

    override fun onStart() {
        super.onStart()

        val userSettings: SharedPreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE)
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        val hintTextView = findViewById<TextView>(R.id.hint)
        hintTextView.textSize = 14f

        val countTextView = findViewById<TextView>(R.id.count)
        countTextView.textSize = 14f

        val menu = findViewById<ImageView>(R.id.menu)
        menu.setImageResource(R.drawable.symbol_menu)
        menu.setColorFilter(getColor(R.color.white))

        val menuShadow = findViewById<ImageView>(R.id.menu_shadow)
        menuShadow.setImageResource(R.drawable.symbol_menu)
        menuShadow.setColorFilter(getColor(R.color.white))
        menuShadow.alpha = 0.5f

        val main = supportFragmentManager.findFragmentById(R.id.main) as ItemFragment

        val balloon = supportFragmentManager.findFragmentById(R.id.balloon) as BalloonFragment

        val fab = supportFragmentManager.findFragmentById(R.id.fab) as FabFragment

        val left = supportFragmentManager.findFragmentById(R.id.left) as HintFragment
        left.view?.setBackgroundColor(getColor(R.color.black))
        left.view?.visibility = View.GONE

        val right = supportFragmentManager.findFragmentById(R.id.right) as HistoryFragment
        right.view?.setBackgroundColor(getColor(R.color.black))
        right.view?.visibility = View.GONE

        mGestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            private val SWIPE_VELOCITY_THRESHOLD = 100
            private val SWIPE_THRESHOLD = 100

            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
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

                return true
            }
        })

        val popup = PopupMenu(this@MainActivity, menu)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            popup.menu.setGroupDividerEnabled(true)
        }
        popup.menu.add(1, 1, 1, R.string.menu_restart)
        popup.menu.add(2, 2, 2, R.string.menu_credit)
        popup.menu.add(2, 3, 3, R.string.menu_version)
        popup.setOnMenuItemClickListener {
            when (it!!.itemId) {
                1 -> {
                    val builder = AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Confirm")
                        .setMessage("Are you sure you want to delete discovered items?")
                        .setPositiveButton("restart") { dialog, id ->
                            game.clear()

                            updateCount(countTextView, main.selectedTab)
                            updateFlex(main)
                            updatePot(fab)
                            updateHint(hintTextView, left, dataStore)
                            updateHistory(right)
                        }
                        .setNegativeButton("cancel") { dialog, id -> }

                    builder.show()
                }
                2 -> {
                    CreditDialogFragment().show(supportFragmentManager, "simple")
                }
                3 -> {
                    val recipeCount = Recipe.getCount()
                    val itemCount = Item.values().filter { item -> Recipe.canMake(item) }.count()
                    VersionDialogFragment(recipeCount, itemCount).show(supportFragmentManager, "simple")
                }
            }

            true
        }

        val unlock = fun(history: History) {
            val results = game.unlock(history)
            game.save(dataStore)

            if (results.isEmpty()) {
                fab.vibrate()
            } else {
                val subLayoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                subLayoutParams.setMargins(2f.dpToPx().toInt(), 2f.dpToPx().toInt(), 2f.dpToPx().toInt(), 2f.dpToPx().toInt())

                val imageLayoutParams = ViewGroup.MarginLayoutParams(32f.dpToPx().toInt(), 32f.dpToPx().toInt())
                imageLayoutParams.setMargins(8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt())

                val  textLayoutParams = ViewGroup.MarginLayoutParams(80f.dpToPx().toInt(), 32f.dpToPx().toInt())
                textLayoutParams.setMargins(8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt())

                for (recipe in results) {
                    balloon.addBalloon(this, subLayoutParams, imageLayoutParams, textLayoutParams, 12f, recipe)
                }

                game.item1 = Item.EMPTY
                game.item2 = Item.EMPTY

                updateCount(countTextView, main.selectedTab)
                updateFlex(main)
                updatePot(fab)
                updateHint(hintTextView, left, dataStore)
                updateHistory(right)
            }
            updateHistory(right)
        }

        menu.isClickable = true
        menu.setOnClickListener {
            popup.show()
        }

        main.tabSelectedListener = object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                updateCount(countTextView, main.selectedTab)

                userSettings.edit().putString("selectedTab", main.selectedTab.name).apply()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        }
        main.itemClickListener = object : ItemFragment.OnItemClickListener {
            override fun onClick(item: Item) {
                if (game.item1 == Item.EMPTY) {
                    game.item1 = item
                } else if (game.item2 == Item.EMPTY) {
                    game.item2 = item
                }
                updatePot(fab)
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

        val selected = Group.values().filter { it.name == userSettings.getString("selectedTab", "") }
        if (selected.any()) {
            main.selectedTab = selected.first()
        }

        game.load(dataStore)

        updateCount(countTextView, main.selectedTab)
        updateFlex(main)
        updatePot(fab)
        updateHint(hintTextView, left, dataStore)
        updateHistory(right)

        left.setAdsEnabled(false)
        left.setAdsOnClickListener {
            if (mRewardedAd != null) {
                mRewardedAd?.setFullScreenContentCallback(object : FullScreenContentCallback() {
                    override fun onAdShowedFullScreenContent() {
                    }

                    override fun onAdDismissedFullScreenContent() {
                        mRewardedAd = null
                        Toast.makeText(this@MainActivity, "Failed to watch ads.", Toast.LENGTH_LONG).show()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        mRewardedAd = null
                        Toast.makeText(this@MainActivity, "Failed to watch ads.", Toast.LENGTH_LONG).show()
                    }
                })

                mRewardedAd?.show(this@MainActivity) {
                    game.addHints(dataStore, it.amount)
                    updateHint(hintTextView, left, dataStore)
                }
            }
        }

        left.setHintOnClickListener {
            if (!game.isHintable()) {
                Toast.makeText(this@MainActivity, "You already have all hints.", Toast.LENGTH_LONG).show()
                return@setHintOnClickListener
            }

            if (!game.addHints(dataStore, -1)) {
                Toast.makeText(this@MainActivity, "You need to watch ads.", Toast.LENGTH_LONG).show()
                return@setHintOnClickListener
            }

            game.hint()
            game.save(dataStore)
            updateHint(hintTextView, left, dataStore)
        }
        left.itemClickListener = object : HintFragment.OnItemClickListener {
            override fun onClick(recipe: Recipe) {
                val count = recipe.inputs.distinct().count()
                val cost = count * count

                val html = "<p>Are you sure you want to see the answer?</p>" +
                        "<img src='${R.drawable.symbol_hint}'>-${cost}"

                val imageGetter = ImageGetter {
                    val drawable = ResourcesCompat.getDrawable(resources, it.toInt(), null)
                    drawable?.setBounds(0, 0, 40, 40)
                    drawable
                }

                val builder = AlertDialog.Builder(this@MainActivity)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Confirm")
                    .setMessage(CharSequenceExtensions.trimTrailingWhitespace(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT, imageGetter, null)))
                    .setPositiveButton("unlock") { dialog, id ->
                        if (!game.addHints(dataStore, -cost)) {
                            Toast.makeText(this@MainActivity, "You need to watch ads.", Toast.LENGTH_LONG).show()
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

        Handler(Looper.getMainLooper()).postDelayed({
            RewardedAd.load(this, BuildConfig.ADS_UNIT_ID, AdRequest.Builder().build(), object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mRewardedAd = null
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    mRewardedAd = rewardedAd
                    left.setAdsEnabled(true)
                }
            })
        }, 1000)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        mGestureDetector?.onTouchEvent(ev)
        return super.dispatchTouchEvent(ev)
    }

    private fun updateHint(hintTextView: TextView, hintFragment: HintFragment, preferences: SharedPreferences) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(32f.dpToPx().toInt(), 32f.dpToPx().toInt())
        imageLayoutParams.setMargins(2f.dpToPx().toInt(), 8f.dpToPx().toInt(), 2f.dpToPx().toInt(), 8f.dpToPx().toInt())

        val symbolLayoutParams = ViewGroup.MarginLayoutParams(16f.dpToPx().toInt(), 32f.dpToPx().toInt())
        symbolLayoutParams.setMargins(0f.dpToPx().toInt(), 8f.dpToPx().toInt(), 0f.dpToPx().toInt(), 8f.dpToPx().toInt())

        val  textLayoutParams = ViewGroup.MarginLayoutParams(80f.dpToPx().toInt(), 32f.dpToPx().toInt())
        textLayoutParams.setMargins(8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt())

        hintTextView.text = game.getHints(preferences).toString()

        val hintList = game.getHintList().map { Recipe.getRecipeListByResult(it).first() }
        val enabledList = hintList.map { it.inputs.all { item -> game.isUnlocked(item) } }
        hintFragment.update(this, hintList, enabledList, imageLayoutParams, symbolLayoutParams, textLayoutParams, 24f.dpToPx().pxToSp(), 12f)
    }

    private fun updateCount(countTextView: TextView, selectedTab: Group) {
        val filteredItem = Item.values().filter { Recipe.canMake(it) }
            .filter { selectedTab == Group.ALL || selectedTab == it.group }
        val unlockedItem = game.getUnlockedItemList()
            .filter { selectedTab == Group.ALL || selectedTab == it.group }

        countTextView.text = "${unlockedItem.count()}/${filteredItem.count()}"
    }

    private fun updateFlex(main: ItemFragment) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(64f.dpToPx().toInt(), 64f.dpToPx().toInt())
        imageLayoutParams.setMargins(8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt())

        val shadowLayoutParams = ViewGroup.MarginLayoutParams(64f.dpToPx().toInt(), 64f.dpToPx().toInt())
        shadowLayoutParams.setMargins(12f.dpToPx().toInt(), 12f.dpToPx().toInt(), 0f.dpToPx().toInt(), 0f.dpToPx().toInt())

        val textLayoutParams = ViewGroup.MarginLayoutParams(64f.dpToPx().toInt(), 28f.dpToPx().toInt())
        textLayoutParams.setMargins(8f.dpToPx().toInt(), 0f.dpToPx().toInt(), 8f.dpToPx().toInt(), 8f.dpToPx().toInt())

        main.update(this, imageLayoutParams, shadowLayoutParams, textLayoutParams, 12f, game.getUnlockedGroupList(), game.getUnlockedItemList())
    }

    private fun updatePot(fabFragment: FabFragment) {
        fabFragment.update(this, game.item1, game.item2)
    }

    private fun updateHistory(historyFragment: HistoryFragment) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(32f.dpToPx().toInt(), 32f.dpToPx().toInt())
        imageLayoutParams.setMargins(2f.dpToPx().toInt(), 8f.dpToPx().toInt(), 2f.dpToPx().toInt(), 8f.dpToPx().toInt())

        val symbolLayoutParams = ViewGroup.MarginLayoutParams(16f.dpToPx().toInt(), 32f.dpToPx().toInt())
        symbolLayoutParams.setMargins(0f.dpToPx().toInt(), 8f.dpToPx().toInt(), 0f.dpToPx().toInt(), 8f.dpToPx().toInt())

        val historyList = game.getHistoryList().reversed()
        historyFragment.update(this, historyList, imageLayoutParams, symbolLayoutParams)
    }

    private fun Float.pxToDp(): Float = (this / resources.displayMetrics.density)
    private fun Float.dpToPx(): Float = (this * resources.displayMetrics.density)

    private fun Float.pxToSp(): Float = (this / resources.displayMetrics.scaledDensity)
    private fun Float.spToPx(): Float = (this * resources.displayMetrics.scaledDensity)
}