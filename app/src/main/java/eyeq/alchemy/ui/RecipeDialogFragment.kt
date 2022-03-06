package eyeq.alchemy.ui

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import eyeq.alchemy.game.History
import eyeq.alchemy.game.Item
import eyeq.alchemy.game.Recipe

class RecipeDialogFragment(private val recipeList: List<Recipe>, private val itemStack: ArrayDeque<Item>, private val backgroundColor: Int, private val height: Int): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireContext()

        val adapter = HistoryAdapter()
        adapter.setData(getHistoryList())

        val listView = ListView(context)
        listView.setBackgroundColor(backgroundColor)
        listView.adapter = adapter

        val view = LinearLayout(context)
        view.addView(listView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height))

        val builder = AlertDialog.Builder(context)
            .setTitle(itemStack.first().textId)
            .setMessage("")
            .setView(view)
            .setPositiveButton("close") { dialog, id -> }

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