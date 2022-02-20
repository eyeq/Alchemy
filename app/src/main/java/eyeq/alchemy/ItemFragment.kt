package eyeq.alchemy

import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.tabs.TabLayout
import eyeq.alchemy.game.Group
import eyeq.alchemy.game.Item

class ItemFragment : Fragment(R.layout.fragment_item) {

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    private lateinit var tabLayout: TabLayout
    private lateinit var flexboxLayout: FlexboxLayout

    private var map = mutableMapOf<Item, View>()

    var selectedTab = Group.ALL

    var tabSelectedListener: TabLayout.OnTabSelectedListener? = null
    var itemClickListener: OnItemClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = view.findViewById<TabLayout>(R.id.tabs)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        selectedTab = group
                    }
                }
                updateVisible()

                tabSelectedListener?.onTabSelected(tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tabSelectedListener?.onTabUnselected(tab)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tabSelectedListener?.onTabReselected(tab)
            }
        })

        flexboxLayout = view.findViewById<FlexboxLayout>(R.id.flex)
    }

    fun update(context: Context, imageLayoutParams: ViewGroup.LayoutParams, shadowLayoutParams: ViewGroup.LayoutParams, textLayoutParams: ViewGroup.LayoutParams, textSize: Float, groupList: List<Group>, itemList: List<Item>) {
        val temp = selectedTab
        tabLayout.removeAllTabs()

        val tabAll = tabLayout.newTab()
        tabAll.setText(R.string.group_all)
        tabLayout.addTab(tabAll)

        for (group in groupList) {
            val tab = tabLayout.newTab()
            tab.setText(group.textId)
            tabLayout.addTab(tab)

            if (group == temp) {
                tab.select()
            }
        }

        tabLayout.setBackgroundColor(context.getColor(R.color.sumi))
        tabLayout.setTabTextColors(context.getColor(R.color.silver), context.getColor(R.color.white))
        for (tab in (tabLayout.getChildAt(0) as LinearLayout).children) {
            val res = StateListDrawable()
            res.addState(intArrayOf(android.R.attr.state_selected), ContextCompat.getDrawable(context, R.color.kuro))
            res.addState(intArrayOf(), ContextCompat.getDrawable(context, R.color.sumi))
            tab.background = res
        }


        flexboxLayout.setBackgroundColor(context.getColor(R.color.black))

        flexboxLayout.removeAllViews()

        map.clear()
        for (item in itemList) {
            val image = ImageView(context)
            image.setImageResource(item.resId)
            image.setColorFilter(context.getColor(item.colorId))

            val shadow = ImageView(context)
            shadow.setImageResource(item.resId)
            shadow.setColorFilter(context.getColor(item.colorId))
            shadow.alpha = 0.5f

            image.isClickable = true
            image.setOnClickListener {
                itemClickListener?.onClick(item)
            }

            val frame = FrameLayout(context)
            frame.addView(image, imageLayoutParams)
            frame.addView(shadow, shadowLayoutParams)

            val text = TextView(context)
            text.setText(item.textId)
            text.setTextColor(context.getColor(R.color.white))
            text.textSize = textSize
            text.gravity = Gravity.CENTER_HORIZONTAL

            val sub = LinearLayout(context)
            sub.orientation = LinearLayout.VERTICAL
            sub.addView(frame)
            sub.addView(text, textLayoutParams)
            flexboxLayout.addView(sub)

            map[item] = sub
        }

        updateVisible()
    }

    private fun updateVisible() {
        for ((k, v) in map) {
            if (selectedTab == Group.ALL || selectedTab == k.group) {
                v.visibility = View.VISIBLE
            } else {
                v.visibility = View.GONE
            }
        }
    }
}