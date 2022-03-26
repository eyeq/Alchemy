package eyeq.alchemy.ui

import androidx.appcompat.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.DialogFragment
import eyeq.alchemy.BuildConfig
import eyeq.util.trimTrailingWhitespace
import java.text.SimpleDateFormat
import java.util.*

class VersionDialogFragment(private val recipeCount: Int, private val itemCount: Int) : DialogFragment() {

    override fun onStart() {
        super.onStart()

        val alertDialog = dialog as AlertDialog?
        if (alertDialog != null) {
            val textView = alertDialog.findViewById<TextView>(android.R.id.message)
            textView?.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val date = Date(BuildConfig.BUILD_TIME)

        val html = "<h6>${BuildConfig.APPLICATION_NAME}</6>" +
                "<p>ver.${BuildConfig.VERSION_NAME}（Build ${SimpleDateFormat("yyyy.MM.dd").format(date)}）</p>" +
                "<br>" +
                "<p>Components: ${recipeCount} recipes, ${itemCount} items</p>" +
                "<br>" +
                "<p>Release notes: <a href='https://github.com/eyeq/Alchemy/releases'>GitHub</a></p>" +
                "<p>Check for updates: <a href='https://play.google.com/store/apps/details?id=eyeq.alchemy'>Google Play</a></p>"

        val builder = AlertDialog.Builder(requireContext())
            .setTitle("About")
            .setMessage(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)
                .trimTrailingWhitespace())
            .setPositiveButton("close") { dialog, id -> }

        return builder.create()
    }
}