package eyeq.alchemy

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import eyeq.alchemy.game.Recipe

class HintFragment : Fragment(R.layout.fragment_hint) {

    private lateinit var adsButton: Button
    private lateinit var hintButton: Button
    private lateinit var hintListView: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adsButton = view.findViewById<Button>(R.id.ads_button)
        hintButton = view.findViewById<Button>(R.id.hint_button)
        hintListView = view.findViewById<ListView>(R.id.hint_list)
    }

    fun setAdsEnabled(value: Boolean) {
        adsButton.isEnabled = value
    }

    fun setAdsOnClickListener(listener: View.OnClickListener) {
        adsButton.setOnClickListener(listener)
    }

    fun setHintOnClickListener(listener: View.OnClickListener) {
        hintButton.setOnClickListener(listener)
    }

    fun update(context: Context, hintList: List<Recipe>, imageLayoutParams: ViewGroup.LayoutParams, symbolLayoutParams: ViewGroup.LayoutParams, textLayoutParams: ViewGroup.LayoutParams, alphabetSize: Float, textSize: Float) {
        hintListView.adapter = HintAdapter(context, hintList, imageLayoutParams, symbolLayoutParams, textLayoutParams, alphabetSize, textSize)
    }
}