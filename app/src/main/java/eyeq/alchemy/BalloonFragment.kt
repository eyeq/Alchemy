package eyeq.alchemy

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import eyeq.alchemy.game.Recipe

class BalloonFragment : Fragment(R.layout.fragment_balloon) {

    fun addBalloon(context: Context, subLayoutParams: ViewGroup.LayoutParams, imageLayoutParams: ViewGroup.LayoutParams, textLayoutParams: ViewGroup.LayoutParams, textSize: Float, recipe: Recipe) {
        val image = ImageView(context)
        image.setImageResource(recipe.result.resId)
        image.setColorFilter(context.getColor(recipe.result.colorId))

        val text = TextView(context)
        text.setText(recipe.result.textId)
        text.setTextColor(context.getColor(R.color.white))
        text.textSize = textSize
        text.gravity = Gravity.CENTER_VERTICAL

        val sub = LinearLayout(context)
        sub.orientation = LinearLayout.HORIZONTAL
        sub.background = ContextCompat.getDrawable(context, R.drawable.balloon)
        sub.addView(image, imageLayoutParams)
        sub.addView(text, textLayoutParams)

        val linearLayout = view as LinearLayout
        linearLayout.addView(sub, subLayoutParams)

        Handler(Looper.getMainLooper()).postDelayed({
            linearLayout.removeView(sub)
        }, 4000)
    }
}