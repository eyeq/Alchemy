package eyeq.alchemy.game

import eyeq.alchemy.R

enum class Item(val group: Group, val resId: Int, val colorId: Int, val textId: Int, val quoteId: Int) {
    EMPTY(Group.ALL, R.drawable.item_empty, R.color.transparent, R.string.item_empty, R.string.quote_elemental_void),

    // ELEMENTAL
    ELEMENTAL_VOID(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.gray, R.string.item_elemental_void, R.string.quote_elemental_void),
    ELEMENTAL_EARTH(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.bluish_green, R.string.item_elemental_earth, R.string.quote_elemental_earth),
    ELEMENTAL_WATER(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.cyan, R.string.item_elemental_water, R.string.quote_elemental_water),
    ELEMENTAL_AIR(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.magenta, R.string.item_elemental_air, R.string.quote_elemental_air),
    ELEMENTAL_FIRE(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.greenish_red, R.string.item_elemental_fire, R.string.quote_elemental_fire),
    ELEMENTAL_METAL(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.red, R.string.item_elemental_metal, R.string.quote_elemental_metal),
    ELEMENTAL_ICE(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.white, R.string.item_elemental_ice, R.string.quote_elemental_ice),
    ELEMENTAL_PLANT(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.lime, R.string.item_elemental_plant, R.string.quote_elemental_plant),
    ELEMENTAL_THUNDER(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.reddish_blue, R.string.item_elemental_thunder, R.string.quote_elemental_thunder),
    ELEMENTAL_DARK(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.blue, R.string.item_elemental_dark, R.string.quote_elemental_dark),
    ELEMENTAL_LIGHT(Group.ELEMENTAL, R.drawable.emoji_u26aa, R.color.yellow, R.string.item_elemental_light, R.string.quote_elemental_light),

    // MATERIAL
    HOT(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.red, R.string.item_hot, R.string.quote_hot),
    WET(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.blue, R.string.item_wet, R.string.quote_wet),
    COLD(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.cyan, R.string.item_cold, R.string.quote_cold),
    DRY(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.yellow, R.string.item_dry, R.string.quote_dry),

    EARTH(Group.MATERIAL, R.drawable.soil, R.color.transparent, R.string.item_earth, R.string.quote_earth),
    WATER(Group.MATERIAL, R.drawable.emoji_u1f4a7, R.color.transparent, R.string.item_water, R.string.quote_water),
    AIR(Group.MATERIAL, R.drawable.emoji_u1f4ad, R.color.transparent, R.string.item_air, R.string.quote_air),
    FIRE(Group.MATERIAL, R.drawable.emoji_u1f525, R.color.transparent, R.string.item_fire, R.string.quote_fire),
    METAL(Group.MATERIAL, R.drawable.gold, R.color.transparent, R.string.item_metal, R.string.quote_metal),
    ICE(Group.MATERIAL, R.drawable.emoji_u1f9ca, R.color.transparent, R.string.item_ice, R.string.quote_ice),
    PLANT(Group.MATERIAL, R.drawable.emoji_u1f331, R.color.transparent, R.string.item_plant, R.string.quote_plant),
    ANIMAL(Group.MATERIAL, R.drawable.emoji_u1f435, R.color.transparent, R.string.item_animal, R.string.quote_animal),
    THUNDER(Group.MATERIAL, R.drawable.emoji_u1f329, R.color.transparent, R.string.item_thunder, R.string.quote_thunder),
    SPACE(Group.MATERIAL, R.drawable.galaxy, R.color.transparent, R.string.item_space, R.string.quote_space),
    TIME(Group.MATERIAL, R.drawable.emoji_u1f505, R.color.transparent, R.string.item_time, R.string.quote_time),

    // - EARTH or METAL
    STONE(Group.MATERIAL, R.drawable.emoji_u1faa8, R.color.transparent, R.string.item_stone, R.string.quote_stone),
    MAGMA(Group.MATERIAL, R.drawable.emoji_u303d, R.color.red_translucent, R.string.item_magma, R.string.quote_magma),
    MUD(Group.MATERIAL, R.drawable.spot, R.color.yellow_translucent, R.string.item_mud, R.string.quote_mud),
    SAND(Group.MATERIAL, R.drawable.sand, R.color.transparent, R.string.item_sand, R.string.quote_sand),
    GRAVEL(Group.MATERIAL, R.drawable.stone, R.color.transparent, R.string.item_gravel, R.string.quote_gravel),
    COAL(Group.MATERIAL, R.drawable.coal, R.color.transparent, R.string.item_coal, R.string.quote_coal),
    DIAMOND(Group.MATERIAL, R.drawable.emoji_u1f48e, R.color.transparent, R.string.item_diamond, R.string.quote_diamond),

    // - WATER or ICE
    STEAM(Group.MATERIAL, R.drawable.emoji_u2668, R.color.transparent, R.string.item_steam, R.string.quote_steam),
    QUARTZ(Group.MATERIAL, R.drawable.crystals, R.color.transparent, R.string.item_quartz, R.string.quote_quartz),
    BUBBLE(Group.MATERIAL, R.drawable.emoji_u1fae7, R.color.transparent, R.string.item_bubble, R.string.quote_bubble),
    WAVE(Group.MATERIAL, R.drawable.emoji_u1f30a, R.color.transparent, R.string.item_wave, R.string.quote_wave),
    LIFE(Group.MATERIAL, R.drawable.emoji_u1f300, R.color.transparent, R.string.item_life, R.string.quote_life),

    // - AIR or PLANT
    VIBRATION(Group.MATERIAL, R.drawable.emoji_u3030, R.color.transparent, R.string.item_vibration, R.string.quote_vibration),
    SOUND(Group.MATERIAL, R.drawable.emoji_u1f50a, R.color.transparent, R.string.item_sound, R.string.quote_sound),
    WIND(Group.MATERIAL, R.drawable.wind, R.color.transparent, R.string.item_wind, R.string.quote_wind),
    LEAF(Group.MATERIAL, R.drawable.emoji_u1f343, R.color.transparent, R.string.item_leaf, R.string.quote_leaf),
    ASH(Group.MATERIAL, R.drawable.pile, R.color.gray_translucent, R.string.item_ash, R.string.quote_ash),
    LYE(Group.MATERIAL, R.drawable.emoji_u1f95b, R.color.gray_translucent, R.string.item_lye, R.string.quote_lye),
    SMOKE(Group.MATERIAL, R.drawable.smoke, R.color.black_translucent, R.string.item_smoke, R.string.quote_smoke),

    // - FIRE or THUNDER
    ELECTRICITY(Group.MATERIAL, R.drawable.emoji_u26a1, R.color.transparent, R.string.item_electricity, R.string.quote_electricity),
    MAGNET(Group.MATERIAL, R.drawable.emoji_u1f9f2, R.color.transparent, R.string.item_magnet, R.string.quote_magnet),

    // - SPACE or TIME
    GRAVITY(Group.MATERIAL, R.drawable.gravity, R.color.transparent, R.string.item_gravity, R.string.quote_gravity),
    DIRECTION(Group.MATERIAL, R.drawable.directions, R.color.transparent, R.string.item_direction, R.string.quote_direction),
    SKY(Group.MATERIAL, R.drawable.cloudy, R.color.transparent, R.string.item_sky, R.string.quote_sky),
    STAR(Group.MATERIAL, R.drawable.emoji_u2b50, R.color.transparent, R.string.item_star, R.string.quote_star),

    STEM(Group.MATERIAL, R.drawable.emoji_u1f33f, R.color.transparent, R.string.item_stem, R.string.quote_stem),
    ROOT(Group.MATERIAL, R.drawable.roots, R.color.transparent, R.string.item_root, R.string.quote_root),
    FLOWER(Group.MATERIAL, R.drawable.flower, R.color.transparent, R.string.item_flower, R.string.quote_flower),
    SEED(Group.MATERIAL, R.drawable.seeds, R.color.transparent, R.string.item_seed, R.string.quote_seed),
    TREE(Group.MATERIAL, R.drawable.emoji_u1f333, R.color.transparent, R.string.item_tree, R.string.quote_tree),
    EGG(Group.MATERIAL, R.drawable.emoji_u1f95a, R.color.transparent, R.string.item_egg, R.string.quote_egg),

    // NATURE
    SUN(Group.NATURE, R.drawable.emoji_u2600, R.color.transparent, R.string.item_sun, R.string.quote_sun),
    PLANET(Group.NATURE, R.drawable.emoji_u1fa90, R.color.transparent, R.string.item_planet, R.string.quote_planet),
    PLANET_MERCURY(Group.NATURE, R.drawable.mercury, R.color.transparent, R.string.item_planet_mercury, R.string.quote_planet_mercury),
    PLANET_VENUS(Group.NATURE, R.drawable.venus, R.color.transparent, R.string.item_planet_venus, R.string.quote_planet_venus),
    PLANET_MARS(Group.NATURE, R.drawable.mars, R.color.transparent, R.string.item_planet_mars, R.string.quote_planet_mars),
    PLANET_JUPITER(Group.NATURE, R.drawable.jupiter, R.color.transparent, R.string.item_planet_jupiter, R.string.quote_planet_jupiter),
    PLANET_SATURN(Group.NATURE, R.drawable.saturn, R.color.transparent, R.string.item_planet_saturn, R.string.quote_planet_saturn),
    PLANET_URANUS(Group.NATURE, R.drawable.uranus, R.color.transparent, R.string.item_planet_uranus, R.string.quote_planet_uranus),
    PLANET_NEPTUNE(Group.NATURE, R.drawable.neptune, R.color.transparent, R.string.item_planet_neptune, R.string.quote_planet_neptune),
    MOON(Group.NATURE, R.drawable.emoji_u1f315, R.color.transparent, R.string.item_moon, R.string.quote_moon),
    ECLIPSE(Group.NATURE, R.drawable.emoji_u1f311, R.color.transparent, R.string.item_eclipse, R.string.quote_eclipse),
    DAY(Group.NATURE, R.drawable.emoji_u1f305, R.color.transparent, R.string.item_day, R.string.quote_day),
    NIGHT(Group.NATURE, R.drawable.emoji_u1f30c, R.color.transparent, R.string.item_night, R.string.quote_night),
    COMET(Group.NATURE, R.drawable.emoji_u2604, R.color.transparent, R.string.item_comet, R.string.quote_comet),
    METEORITE(Group.NATURE, R.drawable.meteorite, R.color.transparent, R.string.item_meteorite, R.string.quote_meteorite),
    METEOR(Group.NATURE, R.drawable.emoji_u1f320, R.color.transparent, R.string.item_meteor, R.string.quote_meteor),
    BLACK_HOLE(Group.NATURE, R.drawable.black_hole, R.color.transparent, R.string.item_black_hole, R.string.quote_black_hole),
    AURORA(Group.NATURE, R.drawable.northern_lights, R.color.transparent, R.string.item_aurora, R.string.quote_aurora),

    CLOUD(Group.NATURE, R.drawable.emoji_u2601, R.color.transparent, R.string.item_cloud, R.string.quote_cloud),
    RAIN(Group.NATURE, R.drawable.emoji_u1f327, R.color.transparent, R.string.item_rain, R.string.quote_rain),
    RAINBOW(Group.NATURE, R.drawable.emoji_u1f308, R.color.transparent, R.string.item_rainbow, R.string.quote_rainbow),
    SNOW(Group.NATURE, R.drawable.emoji_u1f328, R.color.transparent, R.string.item_snow, R.string.quote_snow),

    VOLCANO(Group.NATURE, R.drawable.emoji_u1f30b, R.color.transparent, R.string.item_volcano, R.string.quote_volcano),
    MOUNTAIN(Group.NATURE, R.drawable.emoji_u26f0, R.color.transparent, R.string.item_mountain, R.string.quote_mountain),
    RIVER(Group.NATURE, R.drawable.emoji_u1f3de, R.color.transparent, R.string.item_river, R.string.quote_river),
    LAKE(Group.NATURE, R.drawable.lake, R.color.transparent, R.string.item_lake, R.string.quote_lake),
    SEA(Group.NATURE, R.drawable.ocean, R.color.transparent, R.string.item_sea, R.string.quote_sea),
    DESERT(Group.NATURE, R.drawable.emoji_u1f3dc, R.color.transparent, R.string.item_desert, R.string.quote_desert),
    PLAIN(Group.NATURE, R.drawable.plains, R.color.transparent, R.string.item_plain, R.string.quote_plant),
    VALLEY(Group.NATURE, R.drawable.valley, R.color.transparent, R.string.item_valley, R.string.quote_valley),
    SWAMP(Group.NATURE, R.drawable.swamp, R.color.transparent, R.string.item_swamp, R.string.quote_swamp),
    ISLAND(Group.NATURE, R.drawable.emoji_u1f3dd, R.color.transparent, R.string.item_island, R.string.quote_island),
    COAST(Group.NATURE, R.drawable.bay, R.color.transparent, R.string.item_bay, R.string.quote_bay),
    CAVE(Group.NATURE, R.drawable.cave, R.color.transparent, R.string.item_cave, R.string.quote_cave),
    GLACIER(Group.NATURE, R.drawable.glacier, R.color.transparent, R.string.item_glacier, R.string.quote_glacier),
    ICEBERG(Group.NATURE, R.drawable.iceberg, R.color.transparent, R.string.item_iceberg, R.string.quote_iceberg),
    FOREST(Group.NATURE, R.drawable.forest, R.color.transparent, R.string.item_forest, R.string.quote_forest),
    JUNGLE(Group.NATURE, R.drawable.jungle, R.color.transparent, R.string.item_jungle, R.string.quote_jungle),
    LIGHTNING_STRIKE(Group.NATURE, R.drawable.lightning, R.color.transparent, R.string.item_lightning_strike, R.string.quote_lightning_strike),
    WHIRLPOOL(Group.NATURE, R.drawable.cyclone, R.color.transparent, R.string.item_whirlpool, R.string.quote_whirlpool),
    WHIRLWIND(Group.NATURE, R.drawable.emoji_u1f32a, R.color.transparent, R.string.item_whirlwind, R.string.quote_whirlwind),
    MIRAGE(Group.NATURE, R.drawable.mirage, R.color.transparent, R.string.item_mirage, R.string.quote_mirage),
    FOG(Group.NATURE, R.drawable.emoji_u1f32b, R.color.transparent, R.string.item_fog, R.string.quote_fog),
    FROST(Group.NATURE, R.drawable.emoji_u2744, R.color.transparent, R.string.item_frost, R.string.quote_frost),
    ICICLE(Group.NATURE, R.drawable.icicles, R.color.transparent, R.string.item_icicle, R.string.quote_icicle),
    ;
}