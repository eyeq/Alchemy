package eyeq.alchemy

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.tabs.TabLayout
import eyeq.alchemy.game.*
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private var mGestureDetector: GestureDetector? = null

    private val game = Game()
    private var selectedTab = Group.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userSettings: SharedPreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE)
        val selected = Group.values().filter { it.name == userSettings.getString("selectedTab", "") }
        if (selected.any()) {
            selectedTab = selected.first()
        }

        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        game.load(dataStore)

        val countTextView = findViewById<TextView>(R.id.count)
        countTextView.textSize = 14f

        val menu = findViewById<ImageView>(R.id.menu)
        menu.setImageResource(R.drawable.symbol_menu)
        menu.setColorFilter(getColor(R.color.white))

        val menuShadow = findViewById<ImageView>(R.id.menu_shadow)
        menuShadow.setImageResource(R.drawable.symbol_menu)
        menuShadow.setColorFilter(getColor(R.color.white))
        menuShadow.alpha = 0.5f

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setBackgroundColor(getColor(R.color.sumi))
        tabLayout.setTabTextColors(getColor(R.color.silver), getColor(R.color.white))

        val flexboxLayout = findViewById<FlexboxLayout>(R.id.flex)
        flexboxLayout.setBackgroundColor(getColor(R.color.black))

        val balloonLayout = findViewById<LinearLayout>(R.id.balloon)

        val image1 = findViewById<ImageView>(R.id.image1)
        val image1Shadow = findViewById<ImageView>(R.id.image1_shadow)

        val image2 = findViewById<ImageView>(R.id.image2)
        val image2Shadow = findViewById<ImageView>(R.id.image2_shadow)

        val clean = findViewById<ImageView>(R.id.clean)
        val cleanShadow = findViewById<ImageView>(R.id.clean_shadow)

        val convert = findViewById<ImageView>(R.id.convert)
        val convertShadow = findViewById<ImageView>(R.id.convert_shadow)

        val left = findViewById<LinearLayout>(R.id.left)
        left.setBackgroundColor(getColor(R.color.black))

        val right = findViewById<LinearLayout>(R.id.right)
        right.setBackgroundColor(getColor(R.color.black))

        mGestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            private val SWIPE_VELOCITY_THRESHOLD = 100
            private val SWIPE_THRESHOLD = 100

            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (abs(diffX) > abs(diffY)) {
                    if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            if(right.visibility == View.VISIBLE) {
                                right.visibility = View.GONE
                            } else {
                                left.visibility = View.VISIBLE
                            }
                        } else {
                            if(left.visibility == View.VISIBLE) {
                                left.visibility = View.GONE
                            } else {
                                right.visibility = View.VISIBLE
                            }
                        }
                    }
                }

                return true
            }
        })

        val popup = PopupMenu(this@MainActivity, menu)
        popup.menu.setGroupDividerEnabled(true)
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
                        .setPositiveButton("restart", { dialog, id ->
                            game.clear()

                            updateTabs(tabLayout)
                            updateFlex(countTextView, flexboxLayout,
                                image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
                            updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
                            updateHistory(right)
                        })
                        .setNegativeButton("cancel", { dialog, id -> })

                    builder.show()
                }
                2 -> {
                    CreditDialogFragment().show(supportFragmentManager, "simple")
                }
                3 -> {
                    VersionDialogFragment().show(supportFragmentManager, "simple")
                }
            }

            true
        }

        menu.isClickable = true
        menu.setOnClickListener {
            popup.show()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        selectedTab = group

                        userSettings.edit().putString("selectedTab", selectedTab.name).apply()
                    }
                }
                updateFlex(countTextView, flexboxLayout,
                    image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        image1.isClickable = true
        image1.setOnClickListener {
            game.item1 = Item.EMPTY
            updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
        }

        image2.isClickable = true
        image2.setOnClickListener {
            game.item2 = Item.EMPTY
            updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
        }

        clean.isClickable = true
        clean.setOnClickListener {
            game.item1 = Item.EMPTY
            game.item2 = Item.EMPTY
            updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
        }

        convert.isClickable = true
        convert.setOnClickListener {
            val results = game.unlock(History(game.item1, game.item2, game.item3))
            if (results.isEmpty()) {
                vibrate(convert, 20f, 10)
                vibrate(convertShadow, 20f, 10)
            } else {
                for (recipe in results) {
                    val subLayoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    subLayoutParams.setMargins(2.dpToPx(), 2.dpToPx(), 2.dpToPx(), 2.dpToPx())

                    val imageLayoutParams = ViewGroup.MarginLayoutParams(32.dpToPx(), 32.dpToPx())
                    imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

                    val  textLayoutParams = ViewGroup.MarginLayoutParams(80.dpToPx(), 32.dpToPx())
                    textLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

                    val image = ImageView(this@MainActivity)
                    image.setImageResource(recipe.result.resId)
                    image.setColorFilter(getColor(recipe.result.colorId))

                    val text = TextView(this)
                    text.setText(recipe.result.textId)
                    text.setTextColor(getColor(R.color.white))
                    text.textSize = 12f
                    text.gravity = Gravity.CENTER_VERTICAL

                    val sub = LinearLayout(this@MainActivity)
                    sub.orientation = LinearLayout.HORIZONTAL
                    sub.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.balloon)
                    sub.addView(image, imageLayoutParams)
                    sub.addView(text, textLayoutParams)

                    balloonLayout.addView(sub, subLayoutParams)

                    Handler(Looper.getMainLooper()).postDelayed({
                        balloonLayout.removeView(sub)
                    }, 4000)
                }
                updateTabs(tabLayout)
                updateFlex(countTextView, flexboxLayout,
                    image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)

                game.item1 = Item.EMPTY
                game.item2 = Item.EMPTY
                updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
            }
            updateHistory(right)

            game.save(dataStore)
        }

        updateTabs(tabLayout)
        updateFlex(countTextView, flexboxLayout,
            image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
        updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
        updateHistory(right)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        mGestureDetector!!.onTouchEvent(ev)
        return super.dispatchTouchEvent(ev)
    }

    private fun updateTabs(tabLayout: TabLayout) {
        val temp = selectedTab
        tabLayout.removeAllTabs()

        val tabAll = tabLayout.newTab()
        tabAll.setText(R.string.group_all)
        tabLayout.addTab(tabAll)

        for (group in Group.values().filter { game.isUnlocked(it) }) {
            val tab = tabLayout.newTab()
            tab.setText(group.textId)
            tabLayout.addTab(tab)

            if (group == temp) {
                tab.select()
            }
        }

        for (tab in (tabLayout.getChildAt(0) as LinearLayout).children) {
            val res = StateListDrawable()
            res.addState(intArrayOf(android.R.attr.state_selected), ContextCompat.getDrawable(this, R.color.kuro))
            res.addState(intArrayOf(), ContextCompat.getDrawable(this, R.color.sumi))
            tab.background = res
        }
    }

    private fun updateFlex(
        countTextView: TextView,
        flexboxLayout: FlexboxLayout,
        image1: ImageView, image1Shadow: ImageView,
        image2: ImageView, image2Shadow: ImageView,
        clean: ImageView, cleanShadow: ImageView,
        convert: ImageView, convertShadow: ImageView
    ) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 64.dpToPx())
        imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val shadowLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 64.dpToPx())
        shadowLayoutParams.setMargins(12.dpToPx(), 12.dpToPx(), 0.dpToPx(), 0.dpToPx())

        val textLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 28.dpToPx())
        textLayoutParams.setMargins(8.dpToPx(), 0.dpToPx(), 8.dpToPx(), 8.dpToPx())

        flexboxLayout.removeAllViews()

        val filteredItem = Item.values()
            .filter { it != Item.EMPTY }
            .filter { selectedTab == Group.ALL || selectedTab == it.group }
        val unlockedItem = filteredItem
            .filter { item -> game.isUnlocked(item) }

        countTextView.text = "${unlockedItem.count()}/${filteredItem.count()}"

        for (item in unlockedItem) {
            val image = ImageView(this)
            image.setImageResource(item.resId)
            image.setColorFilter(getColor(item.colorId))

            val shadow = ImageView(this)
            shadow.setImageResource(item.resId)
            shadow.setColorFilter(getColor(item.colorId))
            shadow.alpha = 0.5f

            image.isClickable = true
            image.setOnClickListener {
                if (game.item1 == Item.EMPTY) {
                    game.item1 = item
                } else if (game.item2 == Item.EMPTY) {
                    game.item2 = item
                }
                updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
            }

            val frame = FrameLayout(this)
            frame.addView(image, imageLayoutParams)
            frame.addView(shadow, shadowLayoutParams)

            val text = TextView(this)
            text.setText(item.textId)
            text.setTextColor(getColor(R.color.white))
            text.textSize = 12f
            text.gravity = Gravity.CENTER_HORIZONTAL

            val sub = LinearLayout(this)
            sub.orientation = LinearLayout.VERTICAL
            sub.addView(frame)
            sub.addView(text, textLayoutParams)
            flexboxLayout.addView(sub)
        }
    }

    private fun updatePot(
        image1: ImageView, image1Shadow: ImageView,
        image2: ImageView, image2Shadow: ImageView,
        clean: ImageView, cleanShadow: ImageView,
        convert: ImageView, convertShadow: ImageView
    ) {
        image1.setImageResource(game.item1.resId)
        image1.setColorFilter(getColor(game.item1.colorId))

        image1Shadow.setImageResource(game.item1.resId)
        image1Shadow.setColorFilter(getColor(game.item1.colorId))
        image1Shadow.alpha = 0.5f

        image2.setImageResource(game.item2.resId)
        image2.setColorFilter(getColor(game.item2.colorId))

        image2Shadow.setImageResource(game.item2.resId)
        image2Shadow.setColorFilter(getColor(game.item2.colorId))
        image2Shadow.alpha = 0.5f

        clean.setImageResource(R.drawable.symbol_clean)
        clean.setColorFilter(getColor(R.color.silver))

        cleanShadow.setImageResource(R.drawable.symbol_clean)
        cleanShadow.setColorFilter(getColor(R.color.silver))
        cleanShadow.alpha = 0.5f

        convert.setImageResource(R.drawable.symbol_reload)
        convert.setColorFilter(getColor(R.color.white))

        convertShadow.setImageResource(R.drawable.symbol_reload)
        convertShadow.setColorFilter(getColor(R.color.white))
        convertShadow.alpha = 0.5f
    }

    private fun updateHistory(right: LinearLayout) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(32.dpToPx(), 32.dpToPx())
        imageLayoutParams.setMargins(2.dpToPx(), 8.dpToPx(), 2.dpToPx(), 8.dpToPx())

        val symbolLayoutParams = ViewGroup.MarginLayoutParams(16.dpToPx(), 32.dpToPx())
        symbolLayoutParams.setMargins(0.dpToPx(), 8.dpToPx(), 0.dpToPx(), 8.dpToPx())

        right.removeAllViews()

        var count = 0
        val historyList = game.getHistoryList().reversed()
        for (history in historyList) {
            val inputs = listOf<Item>(history.item1, history.item2, history.item3).sortedBy { it != Item.EMPTY } // 右詰め
            val result = Recipe.alchemise(history.item1, history.item2, history.item3)

            val view = LinearLayout(this)

            var i = 0
            for (item in inputs) {
                val image = ImageView(this)
                image.setImageResource(item.resId)
                image.setColorFilter(getColor(item.colorId))

                val symbol = ImageView(this)
                if (i == 2) {
                    symbol.setImageResource(R.drawable.symbol_arrow)
                    symbol.setColorFilter(getColor(R.color.white))
                } else if (item != Item.EMPTY) {
                    symbol.setImageResource(R.drawable.symbol_plus)
                    symbol.setColorFilter(getColor(R.color.white))
                }

                view.addView(image, imageLayoutParams)
                view.addView(symbol, symbolLayoutParams)
                i += 1
            }
            for (recipe in result) {
                val image = ImageView(this)
                image.setImageResource(recipe.result.resId)
                image.setColorFilter(getColor(recipe.result.colorId))
                view.addView(image, imageLayoutParams)
            }
            right.addView(view)

            count++
            if(count >= 20) {
                break
            }
        }
    }

    private fun vibrate(target: View, translate: Float, duration: Long) {
        val animatorList: MutableList<Animator> = ArrayList()

        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * 0.0f, translate * -1.0f).setDuration(duration * 1))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * -1.0f, translate * 0.7f).setDuration(duration * 3))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * 0.7f, translate * -0.5f).setDuration(duration * 6))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * -0.5f, translate * 0.4f).setDuration(duration * 10))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * 0.4f, translate * -0.3f).setDuration(duration * 15))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * -0.3f, translate * 0.0f).setDuration(duration * 21))

        val set = AnimatorSet()
        set.playSequentially(animatorList)
        set.start()
    }

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}