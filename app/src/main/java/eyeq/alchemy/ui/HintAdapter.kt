package eyeq.alchemy.ui

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import eyeq.alchemy.R
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class HintAdapter(val context: Context, val hintList: List<Recipe>, val enabledList: List<Boolean>, val imageLayoutParams: ViewGroup.LayoutParams, val symbolLayoutParams: ViewGroup.LayoutParams, val textLayoutParams: ViewGroup.LayoutParams, val alphabetSize: Float, val textSize: Float) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val recipe = hintList[position]
        val enabled = enabledList[position]

        var inputs = recipe.inputs.toMutableList()
        while(inputs.count() < 3) {
            inputs.add(Item.EMPTY)
        }
        inputs = inputs.sortedBy { it != Item.EMPTY }.toMutableList() // 右詰め

        val view = LinearLayout(context)
        view.orientation = LinearLayout.HORIZONTAL
        if (!enabled) {
            view.setBackgroundColor(context.getColor(R.color.sumi))
        }

        var i = 0
        var alphabet = 0
        var prevItem = Item.EMPTY
        for (item in inputs) {
            if (prevItem != item) {
                alphabet += 1
                prevItem = item
            }

            val text = TextView(context)
            text.textSize = alphabetSize
            text.gravity = Gravity.CENTER
            when(alphabet) {
                1 -> {
                    text.setText(R.string.alpha)
                    text.setTextColor(context.getColor(R.color.alpha))
                }
                2 -> {
                    text.setText(R.string.beta)
                    text.setTextColor(context.getColor(R.color.beta))
                }
                3 -> {
                    text.setText(R.string.gamma)
                    text.setTextColor(context.getColor(R.color.gamma))
                }
            }
            view.addView(text, imageLayoutParams)

            val symbol = ImageView(context)
            if (i == 2) {
                symbol.setImageResource(R.drawable.symbol_arrow)
                symbol.setColorFilter(context.getColor(R.color.white))
            } else if (item != Item.EMPTY) {
                symbol.setImageResource(R.drawable.symbol_plus)
                symbol.setColorFilter(context.getColor(R.color.white))
            }
            view.addView(symbol, symbolLayoutParams)

            i += 1
        }

        val image = ImageView(context)
        image.setImageResource(recipe.result.resId)
        image.setColorFilter(context.getColor(recipe.result.colorId))
        view.addView(image, imageLayoutParams)

        val text = TextView(context)
        text.setText(recipe.result.textId)
        text.setTextColor(context.getColor(R.color.white))
        text.textSize = textSize
        text.gravity = Gravity.CENTER_HORIZONTAL
        view.addView(text, textLayoutParams)

        return view
    }

    override fun getItem(position: Int): Any {
        return hintList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return hintList.size
    }
}