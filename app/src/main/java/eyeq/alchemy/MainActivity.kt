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

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setBackgroundColor(getColor(R.color.sumi))
        tabLayout.setTabTextColors(getColor(R.color.silver), getColor(R.color.white))

        val flexboxLayout = findViewById<FlexboxLayout>(R.id.flex)
        flexboxLayout.setBackgroundColor(getColor(R.color.black))

        val linearLayout = findViewById<LinearLayout>(R.id.pot)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        selectedTab = group
                    }
                }
                updateFlex(tabLayout, flexboxLayout, linearLayout)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        updateTabs(tabLayout)
        updateFlex(tabLayout, flexboxLayout, linearLayout)
        updatePot(tabLayout, flexboxLayout, linearLayout)
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

    private fun updateFlex(tabLayout: TabLayout, flexboxLayout: FlexboxLayout, linearLayout: LinearLayout) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 64.dpToPx())
        imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val textLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 28.dpToPx())
        textLayoutParams.setMargins(8.dpToPx(), 0.dpToPx(), 8.dpToPx(), 8.dpToPx())

        flexboxLayout.removeAllViews()

        for (item in Item.values()) {
            if (selectedTab == Group.ALL || selectedTab == item.group) {
                if (unlocked.any { it.result == item }) {
                    val image = generateImageView(item.resId, getColor(item.colorId))
                    image.isClickable = true
                    image.setOnClickListener {
                        if (item1 == Item.EMPTY) {
                            item1 = item
                        } else if (item2 == Item.EMPTY) {
                            item2 = item
                        }
                        updatePot(tabLayout, flexboxLayout, linearLayout)
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
        }
    }

    private fun updatePot(tabLayout: TabLayout, flexboxLayout: FlexboxLayout, linearLayout: LinearLayout) {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(32.dpToPx(), 32.dpToPx())
        imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val symbolLayoutParams = ViewGroup.MarginLayoutParams(16.dpToPx(), 16.dpToPx())
        symbolLayoutParams.setMargins(0.dpToPx(), 12.dpToPx(), 0.dpToPx(), 12.dpToPx())

        linearLayout.removeAllViews()

        val image1 = generateImageView(item1.resId, getColor(item1.colorId))
        image1.isClickable = true
        image1.setOnClickListener {
            item1 = Item.EMPTY
            updatePot(tabLayout, flexboxLayout, linearLayout)
        }
        linearLayout.addView(image1, imageLayoutParams)

        linearLayout.addView(generateImageView(R.drawable.symbol_plus, getColor(R.color.white)), symbolLayoutParams)

        val image2 = generateImageView(item2.resId, getColor(item2.colorId))
        image2.isClickable = true
        image2.setOnClickListener {
            item2 = Item.EMPTY
            updatePot(tabLayout, flexboxLayout, linearLayout)
        }
        linearLayout.addView(image2, imageLayoutParams)

        linearLayout.addView(generateImageView(R.drawable.symbol_arrow, getColor(R.color.white)), symbolLayoutParams)

        val reload = generateImageView(R.drawable.symbol_reload, getColor(R.color.white))
        reload.isClickable = true
        reload.setOnClickListener {
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
                updateFlex(tabLayout, flexboxLayout, linearLayout)

                item1 = Item.EMPTY
                item2 = Item.EMPTY
                updatePot(tabLayout, flexboxLayout, linearLayout)
            }
        }
        linearLayout.addView(reload, imageLayoutParams)
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