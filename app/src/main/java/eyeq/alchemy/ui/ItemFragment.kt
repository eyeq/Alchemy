package eyeq.alchemy.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.google.android.material.tabs.TabLayout
import eyeq.alchemy.R
import eyeq.alchemy.game.Group
import eyeq.alchemy.game.Item
import eyeq.util.setTabBackgrounds

class ItemFragment : Fragment(R.layout.fragment_item) {

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    private lateinit var tabLayout: TabLayout

    private lateinit var itemAdapter: ItemAdapter
    private lateinit var flexboxLayout: RecyclerView

    private var _itemList = listOf<Item>()

    var tabTextColorNormal: Int? = null
    var tabTextColorSelected: Int? = null
    var tabBackgroundColor: Int? = null
    var tabBackgroundNormal: Drawable? = null
    var tabBackgroundSelected: Drawable? = null

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
                updateFlex()

                tabSelectedListener?.onTabSelected(tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tabSelectedListener?.onTabUnselected(tab)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tabSelectedListener?.onTabReselected(tab)
            }
        })

        itemAdapter = ItemAdapter()

        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.alignItems = AlignItems.FLEX_START
        layoutManager.flexWrap = FlexWrap.WRAP

        flexboxLayout = view.findViewById<RecyclerView>(R.id.flex)
        flexboxLayout.layoutManager = layoutManager
        flexboxLayout.adapter = itemAdapter
    }

    fun update(groupList: List<Group>, itemList: List<Item>, marginBottom: Int) {
        _itemList = itemList

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

        if (tabTextColorNormal != null && tabTextColorSelected != null) {
            tabLayout.setTabTextColors(tabTextColorNormal!!, tabTextColorSelected!!)
        }
        if (tabBackgroundColor != null) {
            tabLayout.setBackgroundColor(tabBackgroundColor!!)
        }
        tabLayout.setTabBackgrounds(tabBackgroundNormal, tabBackgroundSelected)

        itemAdapter.marginBottom = marginBottom
        itemAdapter.itemClickListener = object : ItemAdapter.OnItemClickListener {
            override fun onClick(item: Item) {
                itemClickListener?.onClick(item)
            }
        }
        updateFlex()
    }

    private fun updateFlex() {
        val itemList = _itemList.filter { selectedTab == Group.ALL || selectedTab == it.group }
        itemAdapter.setData(itemList)
    }
}