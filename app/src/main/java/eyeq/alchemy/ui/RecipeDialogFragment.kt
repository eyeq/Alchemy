package eyeq.alchemy.ui

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import eyeq.alchemy.R
import eyeq.alchemy.game.History
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class RecipeDialogFragment(private val recipeList: List<Recipe>, private val itemStack: ArrayDeque<Item>, private val backgroundColor: Int): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireContext()
        val inflater = LayoutInflater.from(context)

        val item = itemStack.first()

        // title
        val title = inflater.inflate(R.layout.view_item_title, null, false)

        val titleText = title.findViewById<TextView>(R.id.text)
        titleText.setText(item.textId)

        val titleButton = title.findViewById<FrameLayout>(R.id.image)
        titleButton.isClickable = true
        titleButton.setOnClickListener {
            val text = titleText.text

            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.setPrimaryClip(ClipData.newPlainText("", text))

            Toast.makeText(context, "Copied; ${text}", Toast.LENGTH_SHORT).show();
        }

        // view
        val adapter = HistoryAdapter()
        val update = fun(item: Item) {
            titleText.setText(item.textId)
            (dialog as AlertDialog?)?.setMessage(context.getString(item.quoteId) + "\n")
            adapter.setData(getHistoryList())
        }
        adapter.itemClickListener = object : HistoryAdapter.OnItemClickListener {
            override fun onClick(item: Item) {
                if (item != Item.EMPTY && item != itemStack.first()) {
                    itemStack.addFirst(item)
                    update(itemStack.first())
                }
            }
        }

        val view = inflater.inflate(R.layout.view_recipe, null, false)
        val listView = view.findViewById<ListView>(R.id.list)
        listView.setBackgroundColor(backgroundColor)
        adapter.setData(getHistoryList())
        listView.adapter = adapter

        // dialog
        val builder = AlertDialog.Builder(context)
            .setCustomTitle(title)
            .setMessage(context.getString(item.quoteId) + "\n")
            .setView(view)
            .setPositiveButton("close") { dialog, id -> }
            .setOnKeyListener { dialog, keyCode, keyEvent ->
                if (keyEvent.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    itemStack.removeFirst()
                    if (itemStack.isNotEmpty()) {
                        update(itemStack.first())
                        return@setOnKeyListener true
                    }
                }
                return@setOnKeyListener false
            }

        return builder.create()
    }

    private fun getHistoryList(): List<History> {
        val item = itemStack.first()

        val results = recipeList.filter { it.result == item }
        val inputs = recipeList.filter { it.inputs.contains(item) }
        return (results + inputs).map {
            History(
                it.inputs.getOrElse(0) { Item.EMPTY },
                it.inputs.getOrElse(1) { Item.EMPTY },
                it.inputs.getOrElse(2) { Item.EMPTY })
        }.distinct()
    }
}