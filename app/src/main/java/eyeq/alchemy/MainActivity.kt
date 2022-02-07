package eyeq.alchemy

import android.graphics.drawable.StateListDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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
        val image2 = findViewById<ImageView>(R.id.image2)
        val convert = findViewById<ImageView>(R.id.convert)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        selectedTab = group
                    }
                }
                updateFlex(countTextView, tabLayout, flexboxLayout, image1, image2, convert)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        image1.isClickable = true
        image1.setOnClickListener {
            item1 = Item.EMPTY
            updatePot(image1, image2, convert)
        }

        image2.isClickable = true
        image2.setOnClickListener {
            item2 = Item.EMPTY
            updatePot(image1, image2, convert)
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
                updateFlex(countTextView, tabLayout, flexboxLayout, image1, image2, convert)

                item1 = Item.EMPTY
                item2 = Item.EMPTY
                updatePot(image1, image2, convert)
            }
        }

        updateTabs(tabLayout)
        updateFlex(countTextView, tabLayout, flexboxLayout, image1, image2, convert)
        updatePot(image1, image2, convert)
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

    private fun updateFlex(countTextView: TextView, tabLayout: TabLayout, flexboxLayout: FlexboxLayout, image1: ImageView, image2: ImageView, convert: ImageView) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 64.dpToPx())
        imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

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
            val image = generateImageView(item.resId, getColor(item.colorId))
            image.isClickable = true
            image.setOnClickListener {
                if (item1 == Item.EMPTY) {
                    item1 = item
                } else if (item2 == Item.EMPTY) {
                    item2 = item
                }
                updatePot(image1, image2, convert)
            }

            val text = TextView(this)
            text.setText(item.textId)
            text.setTextColor(getColor(R.color.white))
            text.textSize = 12f

            val sub = LinearLayout(this)
            sub.orientation = LinearLayout.VERTICAL
            sub.addView(image, imageLayoutParams)
            sub.addView(text, textLayoutParams)
            flexboxLayout.addView(sub)
        }
    }

    private fun updatePot(image1: ImageView, image2: ImageView, convert: ImageView) {
        image1.setImageResource(item1.resId)
        image1.setColorFilter(getColor(item1.colorId))

        image2.setImageResource(item2.resId)
        image2.setColorFilter(getColor(item2.colorId))

        convert.setImageResource(R.drawable.symbol_reload)
        convert.setColorFilter(getColor(R.color.white))
    }

    private fun generateImageView(resId: Int, color: Int): ImageView {
        val image = ImageView(this)
        image.setImageResource(resId)
        image.setColorFilter(color)
        return image
    }

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}