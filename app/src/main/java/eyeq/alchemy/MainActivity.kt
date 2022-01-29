package eyeq.alchemy

import android.graphics.Color
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
        val image = ImageView(this)
        image.setImageResource(R.drawable.dummy)
        image.setColorFilter(Color.parseColor("#000000"))
        layout.addView(image, ViewGroup.LayoutParams(100.dpToPx(), 100.dpToPx()))
    }

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}