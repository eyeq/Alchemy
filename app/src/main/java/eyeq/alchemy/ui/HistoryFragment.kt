package eyeq.alchemy.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import eyeq.alchemy.R
import eyeq.alchemy.game.History

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private lateinit var historyListView: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyListView = view.findViewById(R.id.history_list)
    }

    fun update(context: Context, historyList: List<History>, imageLayoutParams: ViewGroup.LayoutParams, symbolLayoutParams: ViewGroup.LayoutParams) {
        historyListView.adapter = HistoryAdapter(context, historyList, imageLayoutParams, symbolLayoutParams)
    }
}