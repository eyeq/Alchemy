package eyeq.alchemy.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.google.android.material.tabs.TabLayout
import eyeq.alchemy.R
import eyeq.alchemy.game.Group
import eyeq.alchemy.game.Item
import eyeq.util.setTabBackgrounds

class ItemFragment : Fragment(R.layout.fragment_item) {

    interface OnTabSelectedListener {
        fun onTabSelected(group: Group)
    }

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    interface OnItemLongClickListener {
        fun onLongClick(item: Item): Boolean
    }

    private lateinit var tabLayout: TabLayout

    private lateinit var itemAdapter: ItemAdapter
    private lateinit var flexboxLayout: RecyclerView

    var tabTextColorNormal: Int? = null
    var tabTextColorSelected: Int? = null
    var tabBackgroundColor: Int? = null
    var tabBackgroundNormal: Drawable? = null
    var tabBackgroundSelected: Drawable? = null

    var tabSelectedListener: OnTabSelectedListener? = null
    var itemClickListener: OnItemClickListener? = null
    var itemLongClickListener: OnItemLongClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = view.findViewById<TabLayout>(R.id.tabs)

        itemAdapter = ItemAdapter()
        itemAdapter.itemClickListener = object : ItemAdapter.OnItemClickListener {
            override fun onClick(item: Item) {
                itemClickListener?.onClick(item)
            }
        }
        itemAdapter.itemLongClickListener = object : ItemAdapter.OnItemLongClickListener {
            override fun onLongClick(item: Item): Boolean {
                return itemLongClickListener?.onLongClick(item) == true
            }
        }

        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.alignItems = AlignItems.FLEX_START
        layoutManager.flexWrap = FlexWrap.WRAP

        flexboxLayout = view.findViewById<RecyclerView>(R.id.flex)
        flexboxLayout.layoutManager = layoutManager
        flexboxLayout.adapter = itemAdapter
    }

    fun update(groupList: List<Group>, itemList: List<Item>, marginBottom: Int, selectedTab: Group) {
        tabLayout.clearOnTabSelectedListeners()
        if (tabLayout.tabCount != groupList.count() + 1) {
            tabLayout.removeAllTabs()

            val tabAll = tabLayout.newTab()
            tabAll.setText(Group.ALL.textId)
            tabLayout.addTab(tabAll)

            for (group in groupList) {
                val tab = tabLayout.newTab()
                tab.setText(group.textId)
                tabLayout.addTab(tab)

                if (group == selectedTab) {
                    tab.select()
                }
            }
        }
        if (tabTextColorNormal != null && tabTextColorSelected != null) {
            tabLayout.setTabTextColors(tabTextColorNormal!!, tabTextColorSelected!!)
        }
        if (tabBackgroundColor != null) {
            tabLayout.setBackgroundColor(tabBackgroundColor!!)
        }
        tabLayout.setTabBackgrounds(tabBackgroundNormal, tabBackgroundSelected)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (group in Group.values()) {
                    if (getText(group.textId) == tab.text) {
                        flexboxLayout.itemAnimator = null
                        updateFlex(itemList, group)

                        tabSelectedListener?.onTabSelected(group)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

        itemAdapter.marginBottom = marginBottom

        flexboxLayout.itemAnimator = DefaultItemAnimator()
        updateFlex(itemList, selectedTab)
    }

    private fun updateFlex(itemList: List<Item>, selectedTab: Group) {
        val list = itemList.filter { selectedTab == Group.ALL || selectedTab == it.group }
        itemAdapter.setData(list)
    }
}