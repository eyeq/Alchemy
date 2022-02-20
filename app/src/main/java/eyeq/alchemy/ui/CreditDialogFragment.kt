package eyeq.alchemy.ui

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.DialogFragment
import eyeq.util.CharSequenceExtensions

class CreditDialogFragment : DialogFragment() {

    override fun onStart() {
        super.onStart()

        val alertDialog = dialog as AlertDialog?
        if (alertDialog != null) {
            val textView = alertDialog.findViewById<TextView>(R.id.message)
            textView.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val html = "<p>Created by： eyeq800</p>" +
                "<br>" +
                "<p>Image provided by: <a href='https://icooon-mono.com/'>icooon-mono.com</a></p>"

        val builder = AlertDialog.Builder(activity)
            .setTitle("Credit")
            .setMessage(CharSequenceExtensions.trimTrailingWhitespace(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)))
            .setPositiveButton("close") { dialog, id -> }

        return builder.create()
    }
}