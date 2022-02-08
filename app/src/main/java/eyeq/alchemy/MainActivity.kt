package eyeq.alchemy

import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.tabs.TabLayout
import eyeq.alchemy.game.Game
import eyeq.alchemy.game.Group
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class MainActivity : AppCompatActivity() {
    val game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val image1 = findViewById<ImageView>(R.id.image1)
        val image1Shadow = findViewById<ImageView>(R.id.image1_shadow)

        val image2 = findViewById<ImageView>(R.id.image2)
        val image2Shadow = findViewById<ImageView>(R.id.image2_shadow)

        val clean = findViewById<ImageView>(R.id.clean)
        val cleanShadow = findViewById<ImageView>(R.id.clean_shadow)

        val convert = findViewById<ImageView>(R.id.convert)
        val convertShadow = findViewById<ImageView>(R.id.convert_shadow)

        menu.isClickable = true
        menu.setOnClickListener {
            val popup = PopupMenu(this@MainActivity, menu)
            popup.menu.add(1, 1, 1, "CREDIT")
            popup.menu.add(2, 2, 2, "VERSION")
            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                when(it!!.itemId) {
                    1 -> {
                        CreditDialogFragment().show(supportFragmentManager, "simple")
                    }
                    2 -> {
                        VersionDialogFragment().show(supportFragmentManager, "simple")
                    }
                }

                true
            })

            popup.show()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        game.selectedTab = group
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
            val results = Recipe.alchemise(game.item1, game.item2)
            if (results.isNotEmpty()) {
                for (recipe in results) {
                    if (!game.unlocked.contains(recipe)) {
                        val toast = Toast.makeText(this@MainActivity, getString(recipe.result.textId), Toast.LENGTH_LONG)
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()

                        game.unlocked.add(recipe)
                    }
                }
                updateTabs(tabLayout)
                updateFlex(countTextView, flexboxLayout,
                    image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)

                game.item1 = Item.EMPTY
                game.item2 = Item.EMPTY
                updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
            }
        }

        updateTabs(tabLayout)
        updateFlex(countTextView, flexboxLayout,
            image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
        updatePot(image1, image1Shadow, image2, image2Shadow, clean, cleanShadow, convert, convertShadow)
    }

    private fun updateTabs(tabLayout: TabLayout) {
        val temp = game.selectedTab
        tabLayout.removeAllTabs()

        val tabAll = tabLayout.newTab()
        tabAll.setText(R.string.group_all)
        tabLayout.addTab(tabAll)

        for (group in Group.values()) {
            if (game.unlocked.any { it.result.group == group }) {
                val tab = tabLayout.newTab()
                tab.setText(group.textId)
                tabLayout.addTab(tab)

                if (group == temp) {
                    tab.select()
                }
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
            .filter { it.group != Group.ALL }
            .filter { game.selectedTab == Group.ALL || game.selectedTab == it.group }
        val unlockedItem = filteredItem
            .filter { item -> game.unlocked.any { it.result == item } }

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

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}