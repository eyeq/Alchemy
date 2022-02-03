package eyeq.alchemy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.flexbox.FlexboxLayout

class MainActivity : AppCompatActivity() {
    private val unlocked = mutableListOf<Recipe>()
    private var item1 = Item.EMPTY
    private var item2 = Item.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateFlex()
        updatePot()
    }

    private fun updateFlex() {
        val layoutParams = ViewGroup.MarginLayoutParams(48.dpToPx(), 48.dpToPx())
        layoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val layout = findViewById<FlexboxLayout>(R.id.flex)
        layout.removeAllViews()
        layout.setBackgroundColor(Color.BLACK)

        for (item in Item.values()) {
            if (unlocked.any { it.result == item }) {
                val image = generateImageView(item.resId, item.color)
                image.isClickable = true
                image.setOnClickListener {
                    if (item1 == Item.EMPTY) {
                        item1 = item
                    } else if (item2 == Item.EMPTY) {
                        item2 = item
                    }
                    updatePot()
                }
                layout.addView(image, layoutParams)
            }
        }
    }

    private fun updatePot() {
        val layoutParams = ViewGroup.MarginLayoutParams(48.dpToPx(), 48.dpToPx())
        layoutParams.setMargins(2.dpToPx(), 2.dpToPx(), 2.dpToPx(), 2.dpToPx())

        val layout = findViewById<LinearLayout>(R.id.pot)
        layout.removeAllViews()

        val image1 = generateImageView(item1.resId, item1.color)
        image1.isClickable = true
        image1.setOnClickListener {
            item1 = Item.EMPTY
            updatePot()
        }
        layout.addView(image1, layoutParams)

        layout.addView(generateImageView(R.drawable.symbol_plus, Color.WHITE), layoutParams)

        val image2 = generateImageView(item2.resId, item2.color)
        image2.isClickable = true
        image2.setOnClickListener {
            item2 = Item.EMPTY
            updatePot()
        }
        layout.addView(image2, layoutParams)

        layout.addView(generateImageView(R.drawable.symbol_arrow, Color.WHITE), layoutParams)

        val reload = generateImageView(R.drawable.symbol_reload, Color.WHITE)
        reload.isClickable = true
        reload.setOnClickListener {
            val results = Recipe.alchemise(item1, item2)
            if (results.isNotEmpty()) {
                unlocked.addAll(results)
                updateFlex()

                item1 = Item.EMPTY
                item2 = Item.EMPTY
                updatePot()
            }
        }
        layout.addView(reload, layoutParams)
    }

    private fun generateImageView(resId: Int, color: Int): ImageView {
        val image = ImageView(this)
        image.setImageResource(resId)
        image.setColorFilter(color)
        return image
    }

    private fun Int.pxToDp(): Int = (this / resources.displayMetrics.density).toInt()
    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}