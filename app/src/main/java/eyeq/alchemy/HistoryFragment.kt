package eyeq.alchemy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import eyeq.alchemy.game.History

class HistoryFragment : Fragment() {

    private lateinit var historyListView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val layout = inflater.inflate(R.layout.fragment_history, container)

        historyListView = layout.findViewById(R.id.history_list)

        return layout
    }

    fun update(context: Context, historyList: List<History>, imageLayoutParams: ViewGroup.LayoutParams, symbolLayoutParams: ViewGroup.LayoutParams) {
        historyListView.adapter = HistoryAdapter(context, historyList, imageLayoutParams, symbolLayoutParams)
    }
}