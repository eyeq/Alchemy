package eyeq.util

import android.content.Context
import android.content.pm.PackageManager

class PackageManagerExtensions {
    companion object {
        fun getApplicationName(context: Context?): String {
            return try {
                context!!
                val packageManager = context.packageManager
                val info = packageManager.getApplicationInfo(context.packageName, 0)
                packageManager.getApplicationLabel(info).toString()
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }

        fun getVersionName(context: Context?): String {
            return try {
                context!!
                val packageManager = context.packageManager
                val info = packageManager.getPackageInfo(context.packageName, PackageManager.GET_META_DATA)
                info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }
    }
}