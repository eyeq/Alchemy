package eyeq.alchemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.flexbox.FlexboxLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<FlexboxLayout>(R.id.flex)
        for (item in Item.values()) {
            val image = ImageView(this)
            image.setImageResource(item.resId)
            image.setColorFilter(item.color)

            var layoutParams: ViewGroup.MarginLayoutParams = ViewGroup.MarginLayoutParams(80.dpToPx(), 80.dpToPx())
            layoutParams.setMargins(10.dpToPx(), 10.dpToPx(), 10.dpToPx(), 10.dpToPx())
            layout.addView(image, layoutParams)
        }
    }

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}