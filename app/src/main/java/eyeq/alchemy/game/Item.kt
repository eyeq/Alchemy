package eyeq.alchemy.game

import eyeq.alchemy.R

enum class Item(val group: Group, val resId: Int, val colorId: Int, val textId: Int) {
    EMPTY(Group.ALL, R.drawable.item_empty, R.color.transparent, R.string.item_empty),

    // ELEMENTAL
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

    // MATERIAL
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
    ANIMAL(Group.MATERIAL, R.drawable.emoji_u1f435, R.color.transparent, R.string.item_animal),
    THUNDER(Group.MATERIAL, R.drawable.emoji_u1f329, R.color.transparent, R.string.item_thunder),
    SPACE(Group.MATERIAL, R.drawable.galaxy, R.color.transparent, R.string.item_space),
    TIME(Group.MATERIAL, R.drawable.emoji_u1f505, R.color.transparent, R.string.item_time),

    // - EARTH or METAL
    STONE(Group.MATERIAL, R.drawable.emoji_u1faa8, R.color.transparent, R.string.item_stone),
    MAGMA(Group.MATERIAL, R.drawable.emoji_u303d, R.color.red_translucent, R.string.item_magma),
    MUD(Group.MATERIAL, R.drawable.spot, R.color.yellow_translucent, R.string.item_mud),
    SAND(Group.MATERIAL, R.drawable.sand, R.color.transparent, R.string.item_sand),
    GRAVEL(Group.MATERIAL, R.drawable.stone, R.color.transparent, R.string.item_gravel),
    COAL(Group.MATERIAL, R.drawable.coal, R.color.transparent, R.string.item_coal),
    DIAMOND(Group.MATERIAL, R.drawable.emoji_u1f48e, R.color.transparent, R.string.item_diamond),

    // - WATER or ICE
    STEAM(Group.MATERIAL, R.drawable.emoji_u2668, R.color.transparent, R.string.item_steam),
    QUARTZ(Group.MATERIAL, R.drawable.crystals, R.color.transparent, R.string.item_quartz),
    BUBBLE(Group.MATERIAL, R.drawable.emoji_u1fae7, R.color.transparent, R.string.item_bubble),
    WAVE(Group.MATERIAL, R.drawable.emoji_u1f30a, R.color.transparent, R.string.item_wave),
    LIFE(Group.MATERIAL, R.drawable.emoji_u1f300, R.color.transparent, R.string.item_life),

    // - AIR or PLANT
    VIBRATION(Group.MATERIAL, R.drawable.emoji_u3030, R.color.transparent, R.string.item_vibration),
    SOUND(Group.MATERIAL, R.drawable.emoji_u1f50a, R.color.transparent, R.string.item_sound),
    WIND(Group.MATERIAL, R.drawable.wind, R.color.transparent, R.string.item_wind),
    LEAF(Group.MATERIAL, R.drawable.emoji_u1f343, R.color.transparent, R.string.item_leaf),
    ASH(Group.MATERIAL, R.drawable.pile, R.color.gray_translucent, R.string.item_ash),
    LYE(Group.MATERIAL, R.drawable.emoji_u1f95b, R.color.gray_translucent, R.string.item_lye),
    SMOKE(Group.MATERIAL, R.drawable.smoke, R.color.black_translucent, R.string.item_smoke),

    // - FIRE or THUNDER
    ELECTRICITY(Group.MATERIAL, R.drawable.emoji_u26a1, R.color.transparent, R.string.item_electricity),
    MAGNET(Group.MATERIAL, R.drawable.emoji_u1f9f2, R.color.transparent, R.string.item_magnet),

    // - SPACE or TIME
    GRAVITY(Group.MATERIAL, R.drawable.gravity, R.color.transparent, R.string.item_gravity),
    DIRECTION(Group.MATERIAL, R.drawable.directions, R.color.transparent, R.string.item_direction),
    SKY(Group.MATERIAL, R.drawable.cloudy, R.color.transparent, R.string.item_sky),
    STAR(Group.MATERIAL, R.drawable.emoji_u2b50, R.color.transparent, R.string.item_star),

    STEM(Group.MATERIAL, R.drawable.emoji_u1f33f, R.color.transparent, R.string.item_stem),
    ROOT(Group.MATERIAL, R.drawable.roots, R.color.transparent, R.string.item_root),
    FLOWER(Group.MATERIAL, R.drawable.flower, R.color.transparent, R.string.item_flower),
    SEED(Group.MATERIAL, R.drawable.seeds, R.color.transparent, R.string.item_seed),
    TREE(Group.MATERIAL, R.drawable.emoji_u1f333, R.color.transparent, R.string.item_tree),
    EGG(Group.MATERIAL, R.drawable.emoji_u1f95a, R.color.transparent, R.string.item_egg),

    // NATURE
    SUN(Group.NATURE, R.drawable.emoji_u2600, R.color.transparent, R.string.item_sun),
    PLANET(Group.NATURE, R.drawable.emoji_u1fa90, R.color.transparent, R.string.item_planet),
    PLANET_MERCURY(Group.NATURE, R.drawable.mercury, R.color.transparent, R.string.item_planet_mercury),
    PLANET_VENUS(Group.NATURE, R.drawable.venus, R.color.transparent, R.string.item_planet_venus),
    PLANET_MARS(Group.NATURE, R.drawable.mars, R.color.transparent, R.string.item_planet_mars),
    PLANET_JUPITER(Group.NATURE, R.drawable.jupiter, R.color.transparent, R.string.item_planet_jupiter),
    PLANET_SATURN(Group.NATURE, R.drawable.saturn, R.color.transparent, R.string.item_planet_saturn),
    PLANET_URANUS(Group.NATURE, R.drawable.uranus, R.color.transparent, R.string.item_planet_uranus),
    PLANET_NEPTUNE(Group.NATURE, R.drawable.neptune, R.color.transparent, R.string.item_planet_neptune),
    MOON(Group.NATURE, R.drawable.emoji_u1f315, R.color.transparent, R.string.item_moon),
    ECLIPSE(Group.NATURE, R.drawable.emoji_u1f311, R.color.transparent, R.string.item_eclipse),
    DAY(Group.NATURE, R.drawable.emoji_u1f305, R.color.transparent, R.string.item_day),
    NIGHT(Group.NATURE, R.drawable.emoji_u1f30c, R.color.transparent, R.string.item_night),
    COMET(Group.NATURE, R.drawable.emoji_u2604, R.color.transparent, R.string.item_comet),
    METEORITE(Group.NATURE, R.drawable.meteorite, R.color.transparent, R.string.item_meteorite),
    METEOR(Group.NATURE, R.drawable.emoji_u1f320, R.color.transparent, R.string.item_meteor),
    BLACK_HOLE(Group.NATURE, R.drawable.black_hole, R.color.transparent, R.string.item_black_hole),
    AURORA(Group.NATURE, R.drawable.northern_lights, R.color.transparent, R.string.item_aurora),

    CLOUD(Group.NATURE, R.drawable.emoji_u2601, R.color.transparent, R.string.item_cloud),
    RAIN(Group.NATURE, R.drawable.emoji_u1f327, R.color.transparent, R.string.item_rain),
    RAINBOW(Group.NATURE, R.drawable.emoji_u1f308, R.color.transparent, R.string.item_rainbow),
    SNOW(Group.NATURE, R.drawable.emoji_u1f328, R.color.transparent, R.string.item_snow),

    VOLCANO(Group.NATURE, R.drawable.emoji_u1f30b, R.color.transparent, R.string.item_volcano),
    MOUNTAIN(Group.NATURE, R.drawable.emoji_u26f0, R.color.transparent, R.string.item_mountain),
    RIVER(Group.NATURE, R.drawable.emoji_u1f3de, R.color.transparent, R.string.item_river),
    LAKE(Group.NATURE, R.drawable.lake, R.color.transparent, R.string.item_lake),
    SEA(Group.NATURE, R.drawable.ocean, R.color.transparent, R.string.item_sea),
    DESERT(Group.NATURE, R.drawable.emoji_u1f3dc, R.color.transparent, R.string.item_desert),
    PLAIN(Group.NATURE, R.drawable.plains, R.color.transparent, R.string.item_plain),
    VALLEY(Group.NATURE, R.drawable.valley, R.color.transparent, R.string.item_valley),
    SWAMP(Group.NATURE, R.drawable.swamp, R.color.transparent, R.string.item_swamp),
    ISLAND(Group.NATURE, R.drawable.emoji_u1f3dd, R.color.transparent, R.string.item_island),
    COAST(Group.NATURE, R.drawable.bay, R.color.transparent, R.string.item_bay),
    CAVE(Group.NATURE, R.drawable.cave, R.color.transparent, R.string.item_cave),
    GLACIER(Group.NATURE, R.drawable.glacier, R.color.transparent, R.string.item_glacier),
    ICEBERG(Group.NATURE, R.drawable.iceberg, R.color.transparent, R.string.item_iceberg),
    FOREST(Group.NATURE, R.drawable.forest, R.color.transparent, R.string.item_forest),
    JUNGLE(Group.NATURE, R.drawable.jungle, R.color.transparent, R.string.item_jungle),
    LIGHTNING_STRIKE(Group.NATURE, R.drawable.lightning, R.color.transparent, R.string.item_lightning_strike),
    WHIRLPOOL(Group.NATURE, R.drawable.cyclone, R.color.transparent, R.string.item_whirlpool),
    WHIRLWIND(Group.NATURE, R.drawable.emoji_u1f32a, R.color.transparent, R.string.item_whirlwind),
    MIRAGE(Group.NATURE, R.drawable.mirage, R.color.transparent, R.string.item_mirage),
    FOG(Group.NATURE, R.drawable.emoji_u1f32b, R.color.transparent, R.string.item_fog),
    FROST(Group.NATURE, R.drawable.emoji_u2744, R.color.transparent, R.string.item_frost),
    ICICLE(Group.NATURE, R.drawable.icicles, R.color.transparent, R.string.item_icicles),
    ;
}