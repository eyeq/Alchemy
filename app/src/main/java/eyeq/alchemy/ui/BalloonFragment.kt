package eyeq.alchemy.ui

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import eyeq.alchemy.R
import eyeq.alchemy.game.Recipe

class BalloonFragment : Fragment(R.layout.fragment_balloon) {

    fun addBalloon(recipe: Recipe) {
        val parent = view as ViewGroup

        val context = requireContext()
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.view_balloon, parent, false)

        val image = layout.findViewById<ImageView>(R.id.image)
        image.setImageResource(recipe.result.resId)
        image.setColorFilter(context.getColor(recipe.result.colorId))

        val text = layout.findViewById<TextView>(R.id.text)
        text.setText(recipe.result.textId)

        parent.addView(layout)
        Handler(Looper.getMainLooper()).postDelayed({
            parent.removeView(layout)
        }, 4000)
    }
}