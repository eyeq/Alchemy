package eyeq.alchemy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eyeq.alchemy.R
import eyeq.alchemy.game.Item

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    interface OnItemLongClickListener {
        fun onLongClick(item: Item): Boolean
    }

    private var itemList = listOf<Item>()

    var marginBottom = 0
    var itemClickListener: OnItemClickListener? = null
    var itemLongClickListener: OnItemLongClickListener? = null

    init {
        setHasStableIds(true)
    }

    fun setData(list: List<Item>) {
        itemList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.view_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]

        val context = holder.itemView.context
        val button = holder.itemView.findViewById<FrameLayout>(R.id.button)
        val shadow = holder.itemView.findViewById<ImageView>(R.id.shadow)
        val image = holder.itemView.findViewById<ImageView>(R.id.image)
        val text = holder.itemView.findViewById<TextView>(R.id.text)

        button.isClickable = true
        button.setOnClickListener {
            itemClickListener?.onClick(item)
        }
        button.setOnLongClickListener {
            itemLongClickListener?.onLongClick(item) == true
        }

        shadow.setImageResource(item.resId)
        shadow.setColorFilter(context.getColor(item.colorId))

        image.setImageResource(item.resId)
        image.setColorFilter(context.getColor(item.colorId))

        text.setText(item.textId)

        // bottomMargin
        if (position == itemList.lastIndex) {
            val params = holder.itemView.layoutParams as RecyclerView.LayoutParams
            params.bottomMargin = marginBottom
        } else {
            val params = holder.itemView.layoutParams as RecyclerView.LayoutParams
            params.bottomMargin = 0
        }
    }

    override fun getItemId(position: Int): Long {
        val item = itemList[position]
        return item.ordinal.toLong()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}