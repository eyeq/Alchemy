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


class MainActivity : AppCompatActivity() {
    private val unlocked = mutableListOf<Recipe>()
    private var selectedTab = Group.ALL
    private var item1 = Item.EMPTY
    private var item2 = Item.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countTextView = findViewById<TextView>(R.id.count)
        countTextView.textSize = 14f

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setBackgroundColor(getColor(R.color.sumi))
        tabLayout.setTabTextColors(getColor(R.color.silver), getColor(R.color.white))

        val flexboxLayout = findViewById<FlexboxLayout>(R.id.flex)
        flexboxLayout.setBackgroundColor(getColor(R.color.black))

        val image1 = findViewById<ImageView>(R.id.image1)
        val image1Shadow = findViewById<ImageView>(R.id.image1_shadow)

        val image2 = findViewById<ImageView>(R.id.image2)
        val image2Shadow = findViewById<ImageView>(R.id.image2_shadow)

        val convert = findViewById<ImageView>(R.id.convert)
        val convertShadow = findViewById<ImageView>(R.id.convert_shadow)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        selectedTab = group
                    }
                }
                updateFlex(countTextView, flexboxLayout, image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        image1.isClickable = true
        image1.setOnClickListener {
            item1 = Item.EMPTY
            updatePot(image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
        }

        image2.isClickable = true
        image2.setOnClickListener {
            item2 = Item.EMPTY
            updatePot(image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
        }

        convert.isClickable = true
        convert.setOnClickListener {
            val results = Recipe.alchemise(item1, item2)
            if (results.isNotEmpty()) {
                for (recipe in results) {
                    if (!unlocked.contains(recipe)) {
                        val toast = Toast.makeText(this, getString(recipe.result.textId), Toast.LENGTH_LONG)
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()

                        unlocked.add(recipe)
                    }
                }
                updateTabs(tabLayout)
                updateFlex(countTextView, flexboxLayout, image1, image1Shadow, image2, image2Shadow, convert, convertShadow)

                item1 = Item.EMPTY
                item2 = Item.EMPTY
                updatePot(image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
            }
        }

        updateTabs(tabLayout)
        updateFlex(countTextView, flexboxLayout, image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
        updatePot(image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
    }

    private fun updateTabs(tabLayout: TabLayout) {
        val temp = selectedTab
        tabLayout.removeAllTabs()

        val tabAll = tabLayout.newTab()
        tabAll.setText(R.string.group_all)
        tabLayout.addTab(tabAll)

        for (group in Group.values()) {
            if (unlocked.any { it.result.group == group }) {
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
            .filter { selectedTab == Group.ALL || selectedTab == it.group }
        val unlockedItem = filteredItem
            .filter { item -> unlocked.any { it.result == item } }

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
                if (item1 == Item.EMPTY) {
                    item1 = item
                } else if (item2 == Item.EMPTY) {
                    item2 = item
                }
                updatePot(image1, image1Shadow, image2, image2Shadow, convert, convertShadow)
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
        convert: ImageView, convertShadow: ImageView
    ) {
        image1.setImageResource(item1.resId)
        image1.setColorFilter(getColor(item1.colorId))

        image1Shadow.setImageResource(item1.resId)
        image1Shadow.setColorFilter(getColor(item1.colorId))
        image1Shadow.alpha = 0.5f

        image2.setImageResource(item2.resId)
        image2.setColorFilter(getColor(item2.colorId))

        image2Shadow.setImageResource(item2.resId)
        image2Shadow.setColorFilter(getColor(item2.colorId))
        image2Shadow.alpha = 0.5f

        convert.setImageResource(R.drawable.symbol_reload)
        convert.setColorFilter(getColor(R.color.white))

        convertShadow.setImageResource(R.drawable.symbol_reload)
        convertShadow.setColorFilter(getColor(R.color.white))
        convertShadow.alpha = 0.5f
    }

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}