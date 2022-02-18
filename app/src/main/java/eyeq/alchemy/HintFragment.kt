package eyeq.alchemy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import eyeq.alchemy.game.Recipe

class HintFragment : Fragment() {

    private lateinit var adsButton: Button
    private lateinit var hintButton: Button
    private lateinit var hintListView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val layout = inflater.inflate(R.layout.fragment_hint, container)

        adsButton = layout.findViewById<Button>(R.id.ads_button)
        hintButton = layout.findViewById<Button>(R.id.hint_button)
        hintListView = layout.findViewById<ListView>(R.id.hint_list)

        return layout
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