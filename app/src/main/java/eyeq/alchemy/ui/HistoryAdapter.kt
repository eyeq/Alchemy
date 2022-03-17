package eyeq.alchemy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import eyeq.alchemy.R
import eyeq.alchemy.game.History
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class HistoryAdapter : BaseAdapter() {

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    private var historyList = listOf<History>()

    var itemClickListener: OnItemClickListener? = null

    fun setData(list: List<History>) {
        historyList = list
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val history = historyList[position]

        val inputs = listOf<Item>(history.item1, history.item2, history.item3).sortedBy { it != Item.EMPTY } // 右詰め
        val result = Recipe.getRecipeListByInputs(history.item1, history.item2, history.item3)

        val context = parent?.context
        val layout : View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            layout = inflater.inflate(R.layout.view_history, parent, false)
        } else {
            layout = convertView
        }
        context!!

        val input1 = layout.findViewById<ImageView>(R.id.input1)
        val input2 = layout.findViewById<ImageView>(R.id.input2)
        val input3 = layout.findViewById<ImageView>(R.id.input3)

        val symbol1 = layout.findViewById<ImageView>(R.id.symbol1)
        val symbol2 = layout.findViewById<ImageView>(R.id.symbol2)
        val symbol3 = layout.findViewById<ImageView>(R.id.symbol3)

        var i = 0
        for (item in inputs) {
            var input = input1
            var symbol = symbol1
            when(i) {
                0 -> {
                    input = input1
                    symbol = symbol1
                }
                1 -> {
                    input = input2
                    symbol = symbol2
                }
                2 -> {
                    input = input3
                    symbol = symbol3
                }
            }

            input.setImageResource(item.resId)
            input.setColorFilter(context.getColor(item.colorId))
            input.isClickable = true
            input.setOnClickListener {
                itemClickListener?.onClick(item)
            }

            if (item != Item.EMPTY) {
                symbol.visibility = View.VISIBLE
            } else {
                symbol.visibility = View.INVISIBLE
            }

            i += 1
        }

        val result1 = layout.findViewById<ImageView>(R.id.result1)
        val result2 = layout.findViewById<ImageView>(R.id.result2)
        val result3 = layout.findViewById<ImageView>(R.id.result3)
        val result4 = layout.findViewById<ImageView>(R.id.result4)

        result1.setImageDrawable(null)
        result2.setImageDrawable(null)
        result3.setImageDrawable(null)
        result4.setImageDrawable(null)
        if(result.isEmpty()) {
            result1.setImageResource(R.drawable.symbol_cross)
            result1.setColorFilter(context.getColor(R.color.red))
        }

        i = 0
        for (recipe in result) {
            var image = result1
            when(i) {
                0 -> {
                    image = result1
                }
                1 -> {
                    image = result2
                }
                2 -> {
                    image = result3
                }
                3 -> {
                    image = result4
                }
            }

            val item = recipe.result
            image.setImageResource(item.resId)
            image.setColorFilter(context.getColor(item.colorId))
            image.isClickable = true
            image.setOnClickListener {
                itemClickListener?.onClick(item)
            }

            i += 1
        }

        return layout
    }

    override fun getItem(position: Int): Any {
        return historyList[position]
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getItemId(position: Int): Long {
        val history = historyList[position]

        var ret = 0L
        ret += history.item1.ordinal
        ret *= 65536
        ret += history.item2.ordinal
        ret *= 65536
        ret += history.item3.ordinal
        return ret
    }

    override fun getCount(): Int {
        return historyList.size
    }
}