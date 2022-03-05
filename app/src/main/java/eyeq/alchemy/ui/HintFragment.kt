package eyeq.alchemy.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import eyeq.alchemy.R
import eyeq.alchemy.game.Recipe

class HintFragment : Fragment(R.layout.fragment_hint) {

    interface OnItemClickListener {
        fun onClick(recipe: Recipe)
    }

    private lateinit var adsButton: Button
    private lateinit var hintButton: Button

    private lateinit var hintAdapter: HintAdapter
    private lateinit var hintListView: ListView

    var itemClickListener: OnItemClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adsButton = view.findViewById<Button>(R.id.ads_button)
        hintButton = view.findViewById<Button>(R.id.hint_button)

        hintAdapter = HintAdapter()

        hintListView = view.findViewById<ListView>(R.id.hint_list)
        hintListView.adapter = hintAdapter
        hintListView.setOnItemClickListener { parent, view, position, l ->
            itemClickListener?.onClick(parent.getItemAtPosition(position) as Recipe)
        }
    }

    fun setAdsOnClickListener(listener: View.OnClickListener) {
        adsButton.setOnClickListener(listener)
    }

    fun setHintOnClickListener(listener: View.OnClickListener) {
        hintButton.setOnClickListener(listener)
    }

    fun update(hintList: List<Recipe>, backgroundColorList: List<Int>) {
        hintAdapter.setData(hintList, backgroundColorList)
    }
}