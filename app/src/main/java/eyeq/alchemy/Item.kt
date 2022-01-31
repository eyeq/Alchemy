package eyeq.alchemy

import android.graphics.Color

enum class Item(val resId: Int, val color: Int) {
    ELEMENTAL_VOID(R.drawable.item_elemental, Color.parseColor("#808080")),
    ELEMENTAL_EARTH(R.drawable.item_elemental, Color.parseColor("#800000")),
    ELEMENTAL_WATER(R.drawable.item_elemental, Color.parseColor("#00FFFF")),
    ELEMENTAL_AIR(R.drawable.item_elemental, Color.parseColor("#FF80FF")),
    ELEMENTAL_FIRE(R.drawable.item_elemental, Color.parseColor("#FF8000")),
    ELEMENTAL_METAL(R.drawable.item_elemental, Color.parseColor("#FF0000")),
    ELEMENTAL_ICE(R.drawable.item_elemental, Color.parseColor("#0000FF")),
    ELEMENTAL_PLANT(R.drawable.item_elemental, Color.parseColor("#00FF80")),
    ELEMENTAL_THUNDER(R.drawable.item_elemental, Color.parseColor("#8000FF")),
    ELEMENTAL_LIGHT(R.drawable.item_elemental, Color.parseColor("#FFFF00")),
    ELEMENTAL_DARK(R.drawable.item_elemental, Color.parseColor("#000000")),
    ;
}