package eyeq.alchemy.game

import eyeq.alchemy.R

enum class Item(val group: Group, val resId: Int, val colorId: Int, val textId: Int) {
    EMPTY(Group.ALL, R.drawable.item_empty, R.color.black, R.string.item_empty),

    ELEMENTAL_VOID(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.gray, R.string.item_elemental_void),
    ELEMENTAL_EARTH(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.bluish_green, R.string.item_elemental_earth),
    ELEMENTAL_WATER(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.cyan, R.string.item_elemental_water),
    ELEMENTAL_AIR(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.magenta, R.string.item_elemental_air),
    ELEMENTAL_FIRE(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.greenish_red, R.string.item_elemental_fire),
    ELEMENTAL_METAL(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.red, R.string.item_elemental_metal),
    ELEMENTAL_ICE(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.white, R.string.item_elemental_ice),
    ELEMENTAL_PLANT(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.lime, R.string.item_elemental_plant),
    ELEMENTAL_THUNDER(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.reddish_blue, R.string.item_elemental_thunder),
    ELEMENTAL_DARK(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.blue, R.string.item_elemental_dark),
    ELEMENTAL_LIGHT(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.yellow, R.string.item_elemental_light),

    HOT(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.red, R.string.item_hot),
    WET(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.blue, R.string.item_wet),
    COLD(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.cyan, R.string.item_cold),
    DRY(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.yellow, R.string.item_dry),

    EARTH(Group.MATERIAL, R.drawable.soil, R.color.transparent, R.string.item_earth),
    WATER(Group.MATERIAL, R.drawable.emoji_u1f4a7, R.color.transparent, R.string.item_water),
    AIR(Group.MATERIAL, R.drawable.emoji_u1f4ad, R.color.transparent, R.string.item_air),
    FIRE(Group.MATERIAL, R.drawable.emoji_u1f525, R.color.transparent, R.string.item_fire),
    METAL(Group.MATERIAL, R.drawable.gold, R.color.transparent, R.string.item_metal),
    ICE(Group.MATERIAL, R.drawable.emoji_u1f9ca, R.color.transparent, R.string.item_ice),
    PLANT(Group.MATERIAL, R.drawable.emoji_u1f331, R.color.transparent, R.string.item_plant),
    THUNDER(Group.MATERIAL, R.drawable.emoji_u1f329, R.color.transparent, R.string.item_thunder),
    SPACE(Group.MATERIAL, R.drawable.galaxy, R.color.transparent, R.string.item_space),
    TIME(Group.MATERIAL, R.drawable.emoji_u1f505, R.color.transparent, R.string.item_time),

    VIBRATION(Group.MATERIAL, R.drawable.emoji_u3030, R.color.transparent, R.string.item_vibration),
    STONE(Group.MATERIAL, R.drawable.emoji_u1faa8, R.color.transparent, R.string.item_stone),
    MAGMA(Group.MATERIAL, R.drawable.emoji_u303d, R.color.red_translucent, R.string.item_magma),
    MUD(Group.MATERIAL, R.drawable.spot, R.color.yellow_translucent, R.string.item_mud),
    SAND(Group.MATERIAL, R.drawable.sand, R.color.transparent, R.string.item_sand),
    STEAM(Group.MATERIAL, R.drawable.emoji_u2668, R.color.transparent, R.string.item_steam),
    QUARTZ(Group.MATERIAL, R.drawable.crystals, R.color.transparent, R.string.item_quartz),
    WIND(Group.MATERIAL, R.drawable.wind, R.color.transparent, R.string.item_wind),
    SOUND(Group.MATERIAL, R.drawable.emoji_u1f50a, R.color.transparent, R.string.item_sound),
    ELECTRICITY(Group.MATERIAL, R.drawable.emoji_u26a1, R.color.transparent, R.string.item_electricity),
    MAGNET(Group.MATERIAL, R.drawable.emoji_u1f9f2, R.color.transparent, R.string.item_magnet),
    LEAF(Group.MATERIAL, R.drawable.emoji_u1f343, R.color.transparent, R.string.item_leaf),
    ASH(Group.MATERIAL, R.drawable.pile, R.color.gray_translucent, R.string.item_ash),
    LYE(Group.MATERIAL, R.drawable.emoji_u1f95b, R.color.gray_translucent, R.string.item_lye),
    GRAVITY(Group.MATERIAL, R.drawable.gravity, R.color.transparent, R.string.group_all),
    DIRECTION(Group.MATERIAL, R.drawable.directions, R.color.transparent, R.string.item_direction),
    SKY(Group.MATERIAL, R.drawable.cloudy, R.color.transparent, R.string.item_sky),
    STAR(Group.MATERIAL, R.drawable.emoji_u2b50, R.color.transparent, R.string.item_star),
    ;
}