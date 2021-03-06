package eyeq.alchemy.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import eyeq.alchemy.R
import eyeq.alchemy.game.Item

class FabFragment : Fragment(R.layout.fragment_fab) {

    private lateinit var predict0: ImageView
    private lateinit var predict1: ImageView
    private lateinit var predict2: ImageView
    private lateinit var predict3: ImageView
    private lateinit var predict4: ImageView

    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView

    private lateinit var image1Button: FrameLayout
    private lateinit var image2Button: FrameLayout
    private lateinit var image3Button: FrameLayout

    private lateinit var cleanButton: FrameLayout
    private lateinit var convertButton: FrameLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        predict0 = view.findViewById<ImageView>(R.id.predict0)
        predict1 = view.findViewById<ImageView>(R.id.predict1)
        predict2 = view.findViewById<ImageView>(R.id.predict2)
        predict3 = view.findViewById<ImageView>(R.id.predict3)
        predict4 = view.findViewById<ImageView>(R.id.predict4)

        image1 = view.findViewById<ImageView>(R.id.image1)
        image2 = view.findViewById<ImageView>(R.id.image2)
        image3 = view.findViewById<ImageView>(R.id.image3)

        image1Button = view.findViewById<FrameLayout>(R.id.image1_button)
        image2Button = view.findViewById<FrameLayout>(R.id.image2_button)
        image3Button = view.findViewById<FrameLayout>(R.id.image3_button)

        cleanButton = view.findViewById<FrameLayout>(R.id.clean_button)
        convertButton = view.findViewById<FrameLayout>(R.id.convert_button)
    }

    fun setImage1OnClickListener(listener: View.OnClickListener) {
        image1Button.isClickable = true
        image1Button.setOnClickListener(listener)
    }

    fun setImage2OnClickListener(listener: View.OnClickListener) {
        image2Button.isClickable = true
        image2Button.setOnClickListener(listener)
    }

    fun setCleanOnClickListener(listener: View.OnClickListener) {
        cleanButton.isClickable = true
        cleanButton.setOnClickListener(listener)
    }

    fun setConvertOnClickListener(listener: View.OnClickListener) {
        convertButton.isClickable = true
        convertButton.setOnClickListener(listener)
    }

    fun update(isDone: Boolean, results: List<Item>, item1: Item, item2: Item) {
        val context = requireContext()

        predict0.setImageResource(R.drawable.symbol_question)
        predict0.setColorFilter(context.getColor(R.color.yellow))

        predict1.setImageDrawable(null)
        predict2.setImageDrawable(null)
        predict3.setImageDrawable(null)
        predict4.setImageDrawable(null)

        if (isDone) {
            if (results.any()) {
                predict0.setImageResource(R.drawable.symbol_check)
                predict0.setColorFilter(context.getColor(R.color.lime))

                if (results.count() > 0) {
                    predict1.setImageResource(results[0].resId)
                    predict1.setColorFilter(context.getColor(results[0].colorId))
                }
                if (results.count() > 1) {
                    predict2.setImageResource(results[1].resId)
                    predict2.setColorFilter(context.getColor(results[1].colorId))
                }
                if (results.count() > 2) {
                    predict3.setImageResource(results[2].resId)
                    predict3.setColorFilter(context.getColor(results[2].colorId))
                }
                if (results.count() > 3) {
                    predict4.setImageResource(results[3].resId)
                    predict4.setColorFilter(context.getColor(results[3].colorId))
                }
            } else {
                predict0.setImageResource(R.drawable.symbol_cross)
                predict0.setColorFilter(context.getColor(R.color.red))
            }
        }

        image1.setImageResource(item1.resId)
        image1.setColorFilter(context.getColor(item1.colorId))

        image2.setImageResource(item2.resId)
        image2.setColorFilter(context.getColor(item2.colorId))

        image3Button.visibility = View.GONE
    }

    fun vibrate(translate: Float) {
        ObjectAnimator.ofFloat(convertButton, View.TRANSLATION_X,
            *listOf(0f, -1f, 0.00f, 0.74f, 0f, -0.55f, 0f, 0.41f, 0f, -0.30f, 0f, 0.22f, 0f, -0.16f, 0f, 0.12f, 0f, -0.09f, 0f, 0.06f, 0f, -0.05f, 0f).map { it * translate }.toFloatArray()).apply {
            duration = 864
            interpolator = DecelerateInterpolator()
        }.start()
    }
}