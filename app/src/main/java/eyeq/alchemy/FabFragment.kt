package eyeq.alchemy

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import eyeq.alchemy.game.Item

class FabFragment : Fragment(R.layout.fragment_fab) {

    private lateinit var image1: ImageView
    private lateinit var image1Shadow: ImageView

    private lateinit var image2: ImageView
    private lateinit var image2Shadow: ImageView

    private lateinit var clean: ImageView
    private lateinit var cleanShadow: ImageView

    private lateinit var convert: ImageView
    private lateinit var convertShadow: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image1 = view.findViewById<ImageView>(R.id.image1)
        image1Shadow = view.findViewById<ImageView>(R.id.image1_shadow)

        image2 = view.findViewById<ImageView>(R.id.image2)
        image2Shadow = view.findViewById<ImageView>(R.id.image2_shadow)

        clean = view.findViewById<ImageView>(R.id.clean)
        cleanShadow = view.findViewById<ImageView>(R.id.clean_shadow)

        convert = view.findViewById<ImageView>(R.id.convert)
        convertShadow = view.findViewById<ImageView>(R.id.convert_shadow)
    }

    fun setImage1OnClickListener(listener: View.OnClickListener) {
        image1.isClickable = true
        image1.setOnClickListener(listener)
    }

    fun setImage2OnClickListener(listener: View.OnClickListener) {
        image2.isClickable = true
        image2.setOnClickListener(listener)
    }

    fun setCleanOnClickListener(listener: View.OnClickListener) {
        clean.isClickable = true
        clean.setOnClickListener(listener)
    }

    fun setConvertOnClickListener(listener: View.OnClickListener) {
        convert.isClickable = true
        convert.setOnClickListener(listener)
    }

    fun update(context: Context, item1: Item, item2: Item) {
        image1.setImageResource(item1.resId)
        image1.setColorFilter(context.getColor(item1.colorId))

        image1Shadow.setImageResource(item1.resId)
        image1Shadow.setColorFilter(context.getColor(item1.colorId))
        image1Shadow.alpha = 0.5f

        image2.setImageResource(item2.resId)
        image2.setColorFilter(context.getColor(item2.colorId))

        image2Shadow.setImageResource(item2.resId)
        image2Shadow.setColorFilter(context.getColor(item2.colorId))
        image2Shadow.alpha = 0.5f

        clean.setImageResource(R.drawable.symbol_clean)
        clean.setColorFilter(context.getColor(R.color.silver))

        cleanShadow.setImageResource(R.drawable.symbol_clean)
        cleanShadow.setColorFilter(context.getColor(R.color.silver))
        cleanShadow.alpha = 0.5f

        convert.setImageResource(R.drawable.symbol_reload)
        convert.setColorFilter(context.getColor(R.color.white))

        convertShadow.setImageResource(R.drawable.symbol_reload)
        convertShadow.setColorFilter(context.getColor(R.color.white))
        convertShadow.alpha = 0.5f
    }

    fun vibrate() {
        vibrate(convert, 20f, 10)
        vibrate(convertShadow, 20f, 10)
    }

    private fun vibrate(target: View, translate: Float, duration: Long) {
        val animatorList: MutableList<Animator> = ArrayList()

        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * 0.0f, translate * -1.0f).setDuration(duration * 1))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * -1.0f, translate * 0.7f).setDuration(duration * 3))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * 0.7f, translate * -0.5f).setDuration(duration * 6))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * -0.5f, translate * 0.4f).setDuration(duration * 10))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * 0.4f, translate * -0.3f).setDuration(duration * 15))
        animatorList.add(ObjectAnimator.ofFloat(target, "translationX", translate * -0.3f, translate * 0.0f).setDuration(duration * 21))

        val set = AnimatorSet()
        set.playSequentially(animatorList)
        set.start()
    }
}