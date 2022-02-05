package eyeq.alchemy

enum class Item(val resId: Int, val colorId: Int, val textId: Int) {
    EMPTY(R.drawable.item_empty, R.color.black, R.string.item_empty),
    ELEMENTAL_VOID(R.drawable.item_elemental, R.color.gray, R.string.item_elemental_void),
    ELEMENTAL_EARTH(R.drawable.item_elemental, R.color.bluish_green, R.string.item_elemental_earth),
    ELEMENTAL_WATER(R.drawable.item_elemental, R.color.cyan, R.string.item_elemental_water),
    ELEMENTAL_AIR(R.drawable.item_elemental, R.color.magenta, R.string.item_elemental_air),
    ELEMENTAL_FIRE(R.drawable.item_elemental, R.color.greenish_red, R.string.item_elemental_fire),
    ELEMENTAL_METAL(R.drawable.item_elemental, R.color.red, R.string.item_elemental_metal),
    ELEMENTAL_ICE(R.drawable.item_elemental, R.color.white, R.string.item_elemental_ice),
    ELEMENTAL_PLANT(R.drawable.item_elemental, R.color.lime, R.string.item_elemental_plant),
    ELEMENTAL_THUNDER(R.drawable.item_elemental, R.color.reddish_blue, R.string.item_elemental_thunder),
    ELEMENTAL_LIGHT(R.drawable.item_elemental, R.color.yellow, R.string.item_elemental_light),
    ELEMENTAL_DARK(R.drawable.item_elemental, R.color.blue, R.string.item_elemental_dark),
    ;
}