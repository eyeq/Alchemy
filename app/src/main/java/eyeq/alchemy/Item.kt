package eyeq.alchemy

import android.graphics.Color

enum class Item(val resId: Int, val color: Int, val textId: Int) {
    EMPTY(R.drawable.item_empty, Color.parseColor("#000000"), R.string.item_empty),
    ELEMENTAL_VOID(R.drawable.item_elemental, Color.parseColor("#808080"), R.string.item_elemental_void),
    ELEMENTAL_EARTH(R.drawable.item_elemental, Color.parseColor("#800000"), R.string.item_elemental_earth),
    ELEMENTAL_WATER(R.drawable.item_elemental, Color.parseColor("#00FFFF"), R.string.item_elemental_water),
    ELEMENTAL_AIR(R.drawable.item_elemental, Color.parseColor("#FF80FF"), R.string.item_elemental_air),
    ELEMENTAL_FIRE(R.drawable.item_elemental, Color.parseColor("#FF8000"), R.string.item_elemental_fire),
    ELEMENTAL_METAL(R.drawable.item_elemental, Color.parseColor("#FF0000"), R.string.item_elemental_metal),
    ELEMENTAL_ICE(R.drawable.item_elemental, Color.parseColor("#FFFFFF"), R.string.item_elemental_ice),
    ELEMENTAL_PLANT(R.drawable.item_elemental, Color.parseColor("#00FF80"), R.string.item_elemental_plant),
    ELEMENTAL_THUNDER(R.drawable.item_elemental, Color.parseColor("#8000FF"), R.string.item_elemental_thunder),
    ELEMENTAL_LIGHT(R.drawable.item_elemental, Color.parseColor("#FFFF00"), R.string.item_elemental_light),
    ELEMENTAL_DARK(R.drawable.item_elemental, Color.parseColor("#0000FF"), R.string.item_elemental_dark),
    ;
}