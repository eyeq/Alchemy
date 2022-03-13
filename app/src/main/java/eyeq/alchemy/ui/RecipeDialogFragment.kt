package eyeq.alchemy.ui

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import eyeq.alchemy.R
import eyeq.alchemy.game.History
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class RecipeDialogFragment(private val recipeList: List<Recipe>, private val itemStack: ArrayDeque<Item>, private val backgroundColor: Int, private val height: Int): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireContext()

        val inflater = LayoutInflater.from(context)
        val title = inflater.inflate(R.layout.view_item_title, null)

        val titleText = title.findViewById<TextView>(R.id.text)

        val titleButton = title.findViewById<ImageView>(R.id.image)
        titleButton.isClickable = true
        titleButton.setOnClickListener {
            val text = titleText.text

            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.setPrimaryClip(ClipData.newPlainText("", text))

            Toast.makeText(context, "Copied; ${text}", Toast.LENGTH_SHORT).show();
        }

        val adapter = HistoryAdapter()
        adapter.itemClickListener = object : HistoryAdapter.OnItemClickListener {
            override fun onClick(item: Item) {
                if (item != Item.EMPTY && item != itemStack.first()) {
                    itemStack.addFirst(item)

                    val dialog = dialog as? AlertDialog
                    titleText.setText(item.textId)
                    dialog?.setMessage(context.getString(item.quoteId) + "\n")
                    adapter.setData(getHistoryList())
                }
            }
        }
        adapter.setData(getHistoryList())

        val listView = ListView(context)
        listView.setBackgroundColor(backgroundColor)
        listView.adapter = adapter

        val view = FrameLayout(context)
        view.addView(listView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height))

        val item = itemStack.first()
        titleText.setText(item.textId)

        val builder = AlertDialog.Builder(context)
            .setCustomTitle(title)
            .setMessage(context.getString(item.quoteId) + "\n")
            .setView(view)
            .setPositiveButton("close") { dialog, id -> }
            .setOnKeyListener { dialog, keyCode, keyEvent ->
                if (keyEvent.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    itemStack.removeFirst()
                    if (itemStack.isNotEmpty()) {
                        val item = itemStack.first()

                        getDialog()?.setTitle(context.getText(item.textId))
                        adapter.setData(getHistoryList())
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