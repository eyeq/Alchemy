package eyeq.alchemy.game

import eyeq.alchemy.R

enum class Item(val group: Group, val resId: Int, val colorId: Int, val textId: Int) {
    EMPTY(Group.ALL, R.drawable.item_empty, R.color.black, R.string.item_empty),

    ELEMENTAL_VOID(Group.ELEMENTAL, R.drawable.item_elemental, R.color.gray, R.string.item_elemental_void),
    ELEMENTAL_EARTH(Group.ELEMENTAL, R.drawable.item_elemental, R.color.bluish_green, R.string.item_elemental_earth),
    ELEMENTAL_WATER(Group.ELEMENTAL, R.drawable.item_elemental, R.color.cyan, R.string.item_elemental_water),
    ELEMENTAL_AIR(Group.ELEMENTAL, R.drawable.item_elemental, R.color.magenta, R.string.item_elemental_air),
    ELEMENTAL_FIRE(Group.ELEMENTAL, R.drawable.item_elemental, R.color.greenish_red, R.string.item_elemental_fire),
    ELEMENTAL_METAL(Group.ELEMENTAL, R.drawable.item_elemental, R.color.red, R.string.item_elemental_metal),
    ELEMENTAL_ICE(Group.ELEMENTAL, R.drawable.item_elemental, R.color.white, R.string.item_elemental_ice),
    ELEMENTAL_PLANT(Group.ELEMENTAL, R.drawable.item_elemental, R.color.lime, R.string.item_elemental_plant),
    ELEMENTAL_THUNDER(Group.ELEMENTAL, R.drawable.item_elemental, R.color.reddish_blue, R.string.item_elemental_thunder),
    ELEMENTAL_DARK(Group.ELEMENTAL, R.drawable.item_elemental, R.color.blue, R.string.item_elemental_dark),
    ELEMENTAL_LIGHT(Group.ELEMENTAL, R.drawable.item_elemental, R.color.yellow, R.string.item_elemental_light),

    HOT(Group.MATERIAL, R.drawable.item_element, R.color.red, R.string.item_hot),
    WET(Group.MATERIAL, R.drawable.item_element, R.color.blue, R.string.item_wet),
    COLD(Group.MATERIAL, R.drawable.item_element, R.color.cyan, R.string.item_cold),
    DRY(Group.MATERIAL, R.drawable.item_element, R.color.yellow, R.string.item_dry),

    EARTH(Group.MATERIAL, R.drawable.item_earth, R.color.red_iron_oxide, R.string.item_earth),
    WATER(Group.MATERIAL, R.drawable.item_water, R.color.cyan, R.string.item_water),
    AIR(Group.MATERIAL, R.drawable.item_air, R.color.bluish_green, R.string.item_air),
    FIRE(Group.MATERIAL, R.drawable.item_fire, R.color.greenish_red, R.string.item_fire),
    METAL(Group.MATERIAL, R.drawable.item_metal, R.color.red_copper_oxide, R.string.item_metal),
    ICE(Group.MATERIAL, R.drawable.item_ice, R.color.white, R.string.item_ice),
    PLANT(Group.MATERIAL, R.drawable.item_plant, R.color.lime, R.string.item_plant),
    THUNDER(Group.MATERIAL, R.drawable.item_thunder, R.color.reddish_blue, R.string.item_thunder),
    SPACE(Group.MATERIAL, R.drawable.item_space, R.color.blue, R.string.item_space),
    TIME(Group.MATERIAL, R.drawable.item_time, R.color.yellow, R.string.item_time),

    VIBRATION(Group.MATERIAL, R.drawable.item_vibration, R.color.white, R.string.item_vibration),
    STONE(Group.MATERIAL, R.drawable.item_stone, R.color.gray, R.string.item_stone),
    MAGMA(Group.MATERIAL, R.drawable.item_magma, R.color.red, R.string.item_magma),
    MUD(Group.MATERIAL, R.drawable.item_mud, R.color.yellow_iron_oxide_hydroxide, R.string.item_mud),
    SAND(Group.MATERIAL, R.drawable.item_sand, R.color.sand, R.string.item_sand),
    STEAM(Group.MATERIAL, R.drawable.item_steam, R.color.cyan, R.string.item_steam),
    QUARTZ(Group.MATERIAL, R.drawable.item_quartz, R.color.white, R.string.item_quartz),
    WIND(Group.MATERIAL, R.drawable.item_wind, R.color.bluish_green, R.string.item_wind),
    SOUND(Group.MATERIAL, R.drawable.item_sound, R.color.white, R.string.item_sound),
    ELECTRICITY(Group.MATERIAL, R.drawable.item_electricity, R.color.yellow, R.string.item_electricity),
    MAGNET(Group.MATERIAL, R.drawable.item_magnet, R.color.gray, R.string.item_magnet),
    LEAF(Group.MATERIAL, R.drawable.item_leaf, R.color.lime, R.string.item_leaf),
    ASH(Group.MATERIAL, R.drawable.item_ash, R.color.gray, R.string.item_ash),
    LYE(Group.MATERIAL, R.drawable.item_lye, R.color.gray, R.string.item_lye),
    GRAVITY(Group.MATERIAL, R.drawable.item_gravity, R.color.silver, R.string.group_all),
    DIRECTION(Group.MATERIAL, R.drawable.item_direction, R.color.silver, R.string.item_direction),
    SKY(Group.MATERIAL, R.drawable.item_sky, R.color.greenish_blue, R.string.item_sky),
    STAR(Group.MATERIAL, R.drawable.item_star, R.color.yellow, R.string.item_star),
    ;
}