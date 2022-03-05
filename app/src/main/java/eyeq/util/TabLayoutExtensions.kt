package eyeq.util

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.widget.LinearLayout
import androidx.core.view.children
import com.google.android.material.tabs.TabLayout

fun TabLayout.setTabBackgrounds(backgroundNormal: Drawable?, backgroundSelected: Drawable?) {
    for (tab in (this.getChildAt(0) as LinearLayout).children) {
        val res = StateListDrawable()
        res.addState(intArrayOf(android.R.attr.state_selected), backgroundNormal)
        res.addState(intArrayOf(), backgroundSelected)
        tab.background = res
    }
}