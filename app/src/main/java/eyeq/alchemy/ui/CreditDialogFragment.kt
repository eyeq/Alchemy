package eyeq.alchemy.ui

import android.R
import androidx.appcompat.app.AlertDialog
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
            textView?.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val html = "<h6 style='text-align: center'>Created by</h6>" +
                "<p style='text-align: center'>eyeq</p>" +
                "<br>" +
                "<h6 style='text-align: center'>Image provided by</h6>" +
                "<p style='text-align: center'>Google Note Emoji</p>" +
                "<p style='text-align: center'><a href='https://github.com/googlefonts/noto-emoji'>github.com/googlefonts/noto-emoji</a></p>" +
                "<p style='text-align: center'><a href='https://www.apache.org/licenses/LICENSE-2.0'>Apache License 2.0.</a></p>" +
                "<br>" +
                "<p style='text-align: center'>Freepik - Flaticon</p>" +
                "<p style='text-align: center'><a href='https://www.flaticon.com/authors/freepik'>www.flaticon.com/authors/freepik</a></p>" +
                "<p style='text-align: center'><a style='text-align: right' href='https://www.freepikcompany.com/legal'>Flaticon License</a></p>" +
                "<br>" +
                "<p style='text-align: center'>ICOON MONO</p>" +
                "<p style='text-align: center'><a href='https://icooon-mono.com'>icooon-mono.com</a></p>" +
                "<p style='text-align: center'><a style='text-align: right' href='https://icooon-mono.com/license'>License</a></p>"

        val builder = AlertDialog.Builder(requireContext())
            .setTitle("Credit")
            .setMessage(CharSequenceExtensions.trimTrailingWhitespace(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)))
            .setPositiveButton("close") { dialog, id -> }

        return builder.create()
    }
}