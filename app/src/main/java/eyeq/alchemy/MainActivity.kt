package eyeq.alchemy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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
        val imageLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 64.dpToPx())
        imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val textLayoutParams = ViewGroup.MarginLayoutParams(64.dpToPx(), 28.dpToPx())
        textLayoutParams.setMargins(8.dpToPx(), 0.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val layout = findViewById<FlexboxLayout>(R.id.flex)
        layout.removeAllViews()
        layout.setBackgroundColor(Color.BLACK)

        for (item in Item.values()) {
            if (unlocked.any { it.result == item }) {
                val image = generateImageView(item.resId, getColor(item.colorId))
                image.isClickable = true
                image.setOnClickListener {
                    if (item1 == Item.EMPTY) {
                        item1 = item
                    } else if (item2 == Item.EMPTY) {
                        item2 = item
                    }
                    updatePot()
                }

                val text = TextView(this)
                text.setText(item.textId)
                text.setTextColor(Color.WHITE)
                text.textSize = 12f

                val sub = LinearLayout(this)
                sub.orientation = LinearLayout.VERTICAL
                sub.addView(image, imageLayoutParams)
                sub.addView(text, textLayoutParams)
                layout.addView(sub)
            }
        }
    }

    private fun updatePot() {
        val imageLayoutParams = ViewGroup.MarginLayoutParams(32.dpToPx(), 32.dpToPx())
        imageLayoutParams.setMargins(8.dpToPx(), 8.dpToPx(), 8.dpToPx(), 8.dpToPx())

        val symbolLayoutParams = ViewGroup.MarginLayoutParams(16.dpToPx(), 16.dpToPx())
        symbolLayoutParams.setMargins(0.dpToPx(), 12.dpToPx(), 0.dpToPx(), 12.dpToPx())

        val layout = findViewById<LinearLayout>(R.id.pot)
        layout.removeAllViews()

        val image1 = generateImageView(item1.resId, getColor(item1.colorId))
        image1.isClickable = true
        image1.setOnClickListener {
            item1 = Item.EMPTY
            updatePot()
        }
        layout.addView(image1, imageLayoutParams)

        layout.addView(generateImageView(R.drawable.symbol_plus, Color.WHITE), symbolLayoutParams)

        val image2 = generateImageView(item2.resId, getColor(item2.colorId))
        image2.isClickable = true
        image2.setOnClickListener {
            item2 = Item.EMPTY
            updatePot()
        }
        layout.addView(image2, imageLayoutParams)

        layout.addView(generateImageView(R.drawable.symbol_arrow, Color.WHITE), symbolLayoutParams)

        val reload = generateImageView(R.drawable.symbol_reload, Color.WHITE)
        reload.isClickable = true
        reload.setOnClickListener {
            val results = Recipe.alchemise(item1, item2)
            if (results.isNotEmpty()) {
                for (recipe in results) {
                    if (!unlocked.contains(recipe)) {
                        val toast = Toast.makeText(this, getString(recipe.result.textId), Toast.LENGTH_LONG)
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()

                        unlocked.add(recipe)
                    }
                }
                updateFlex()

                item1 = Item.EMPTY
                item2 = Item.EMPTY
                updatePot()
            }
        }
        layout.addView(reload, imageLayoutParams)
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