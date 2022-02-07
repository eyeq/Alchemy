package eyeq.alchemy

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class VersionDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("About")
            .setMessage("${Constant.getApplicationName(context)}\nver.${Constant.getVersionName(context)}")
            .setPositiveButton("close") { dialog, id -> }

        return builder.create()
    }
}