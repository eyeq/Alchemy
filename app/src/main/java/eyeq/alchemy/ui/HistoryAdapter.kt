package eyeq.alchemy.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import eyeq.alchemy.R
import eyeq.alchemy.game.History
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class HistoryAdapter(val context: Context, val historyList: List<History>, val imageLayoutParams: ViewGroup.LayoutParams, val symbolLayoutParams: ViewGroup.LayoutParams) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val history = historyList[position]

        val inputs = listOf<Item>(history.item1, history.item2, history.item3).sortedBy { it != Item.EMPTY } // 右詰め
        val result = Recipe.getRecipeListByInputs(history.item1, history.item2, history.item3)

        val view = LinearLayout(context)

        var i = 0
        for (item in inputs) {
            val image = ImageView(context)
            image.setImageResource(item.resId)
            image.setColorFilter(context.getColor(item.colorId))

            val symbol = ImageView(context)
            if (i == 2) {
                symbol.setImageResource(R.drawable.symbol_arrow)
                symbol.setColorFilter(context.getColor(R.color.white))
            } else if (item != Item.EMPTY) {
                symbol.setImageResource(R.drawable.symbol_plus)
                symbol.setColorFilter(context.getColor(R.color.white))
            }

            view.addView(image, imageLayoutParams)
            view.addView(symbol, symbolLayoutParams)
            i += 1
        }
        if(result.isEmpty()) {
            val image = ImageView(context)
            image.setImageResource(R.drawable.symbol_cross)
            image.setColorFilter(context.getColor(R.color.red))
            view.addView(image, imageLayoutParams)
        }
        for (recipe in result) {
            val image = ImageView(context)
            image.setImageResource(recipe.result.resId)
            image.setColorFilter(context.getColor(recipe.result.colorId))
            view.addView(image, imageLayoutParams)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return historyList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return historyList.size
    }
}