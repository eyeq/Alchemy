package eyeq.alchemy.ui

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eyeq.alchemy.R
import eyeq.alchemy.game.Item
import eyeq.util.CharSequenceExtensions

class UnlockedDialogFragment(private val itemList: List<Item>) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val context = requireContext()

        val html = "<p>With the update of world, you found the items.</p>";

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val adapter = ItemAdapter()
        adapter.setData(itemList)

        val view = RecyclerView(context)
        view.setBackgroundColor(context.getColor(R.color.black))
        view.layoutManager = layoutManager
        view.adapter = adapter

        val builder = AlertDialog.Builder(context)
            .setTitle("Unlocked")
            .setMessage(CharSequenceExtensions.trimTrailingWhitespace(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)))
            .setView(view)
            .setPositiveButton("close") { dialog, id -> }

        return builder.create()
    }
}