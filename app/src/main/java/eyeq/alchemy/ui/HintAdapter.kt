package eyeq.alchemy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import eyeq.alchemy.R
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class HintAdapter : BaseAdapter() {

    private var hintList = listOf<Recipe>()
    private var backgroundColorList = listOf<Int>()

    fun setData(list: List<Recipe>, backgroundColor: List<Int>) {
        hintList = list
        backgroundColorList = backgroundColor
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val recipe = hintList[position]
        val backgroundColor = backgroundColorList[position]

        var inputs = recipe.inputs.toMutableList()
        while(inputs.count() < 3) {
            inputs.add(Item.EMPTY)
        }
        inputs = inputs.sortedBy { it != Item.EMPTY }.toMutableList() // 右詰め

        val context = parent?.context
        val layout : View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            layout = inflater.inflate(R.layout.view_hint, parent, false)
        } else {
            layout = convertView
        }
        context!!

        layout.setBackgroundColor(backgroundColor)

        val input1 = layout.findViewById<TextView>(R.id.input1)
        val input2 = layout.findViewById<TextView>(R.id.input2)
        val input3 = layout.findViewById<TextView>(R.id.input3)

        val symbol1 = layout.findViewById<ImageView>(R.id.symbol1)
        val symbol2 = layout.findViewById<ImageView>(R.id.symbol2)
        val symbol3 = layout.findViewById<ImageView>(R.id.symbol3)

        var i = 0
        var alphabet = 0
        var prevItem = Item.EMPTY
        for (item in inputs) {
            if (prevItem != item) {
                alphabet += 1
                prevItem = item
            }

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

            when(alphabet) {
                0 -> {
                    input.text = ""
                }
                1 -> {
                    input.setText(R.string.alpha)
                    input.setTextColor(context.getColor(R.color.alpha))
                }
                2 -> {
                    input.setText(R.string.beta)
                    input.setTextColor(context.getColor(R.color.beta))
                }
                3 -> {
                    input.setText(R.string.gamma)
                    input.setTextColor(context.getColor(R.color.gamma))
                }
            }

            if (item != Item.EMPTY) {
                symbol.visibility = View.VISIBLE
            } else {
                symbol.visibility = View.INVISIBLE
            }

            i += 1
        }

        val image = layout.findViewById<ImageView>(R.id.image)
        image.setImageResource(recipe.result.resId)
        image.setColorFilter(context.getColor(recipe.result.colorId))

        val text = layout.findViewById<TextView>(R.id.text)
        text.setText(recipe.result.textId)

        return layout
    }

    override fun getItem(position: Int): Any {
        return hintList[position]
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getItemId(position: Int): Long {
        val item = hintList[position].result
        return item.ordinal.toLong()
    }

    override fun getCount(): Int {
        return hintList.size
    }
}