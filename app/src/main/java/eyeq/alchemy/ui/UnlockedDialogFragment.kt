package eyeq.alchemy.ui

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eyeq.alchemy.game.Item
import eyeq.util.trimTrailingWhitespace

class UnlockedDialogFragment(private val itemList: List<Item>, private val backgroundColor: Int) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val context = requireContext()

        val html = "<p>With the update of world, you found the items.</p>";

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val adapter = ItemAdapter()
        adapter.setData(itemList)

        val view = RecyclerView(context)
        view.setBackgroundColor(backgroundColor)
        view.layoutManager = layoutManager
        view.adapter = adapter

        val builder = AlertDialog.Builder(context)
            .setTitle("Unlocked")
            .setMessage(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)
                .trimTrailingWhitespace())
            .setView(view)
            .setPositiveButton("close") { dialog, id -> }

        return builder.create()
    }
}