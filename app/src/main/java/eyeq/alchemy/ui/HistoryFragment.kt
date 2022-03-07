package eyeq.alchemy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import eyeq.alchemy.R
import eyeq.alchemy.game.History
import eyeq.alchemy.game.Item

class HistoryFragment : Fragment(R.layout.fragment_history) {

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var historyListView: ListView

    var itemClickListener: OnItemClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyAdapter = HistoryAdapter()
        historyAdapter.itemClickListener = object : HistoryAdapter.OnItemClickListener {
            override fun onClick(item: Item) {
                itemClickListener?.onClick(item)
            }
        }

        historyListView = view.findViewById(R.id.history_list)
        historyListView.adapter = historyAdapter
    }

    fun update(historyList: List<History>) {
        historyAdapter.setData(historyList)
    }
}