package eyeq.alchemy

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager


class Constant {
    companion object {
        fun getApplicationName(context: Context?): String {
            return try {
                context!!
                val pm: PackageManager = context.packageManager
                val info = pm.getApplicationInfo(context.packageName, 0)
                pm.getApplicationLabel(info).toString()
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }

        fun getVersionName(context: Context?): String {
            return try {
                context!!
                val pm: PackageManager = context.packageManager
                val info: PackageInfo = pm.getPackageInfo(context.packageName, PackageManager.GET_META_DATA)
                info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }
    }
}