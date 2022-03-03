package eyeq.alchemy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import eyeq.alchemy.R
import eyeq.alchemy.game.History

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var historyListView: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyAdapter = HistoryAdapter()

        historyListView = view.findViewById(R.id.history_list)
        historyListView.adapter = historyAdapter
    }

    fun update(historyList: List<History>) {
        historyAdapter.setData(historyList)
    }
}