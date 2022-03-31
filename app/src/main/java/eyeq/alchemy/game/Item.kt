package eyeq.alchemy.game

import eyeq.alchemy.R

enum class Item(val group: Group, val resId: Int, val colorId: Int, val textId: Int, val quoteId: Int) {
    EMPTY(Group.ALL, R.drawable.item_empty, R.color.transparent, R.string.empty, R.string.empty),

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

    // MATERIAL - ARCHE
    HOT(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.red, R.string.item_hot, R.string.quote_hot),
    WET(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.blue, R.string.item_wet, R.string.quote_wet),
    COLD(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.cyan, R.string.item_cold, R.string.quote_cold),
    DRY(Group.MATERIAL, R.drawable.emoji_u25ab, R.color.yellow, R.string.item_dry, R.string.quote_dry),

    EARTH(Group.MATERIAL, R.drawable.soil, R.color.transparent, R.string.item_earth, R.string.quote_earth),
    WATER(Group.MATERIAL, R.drawable.emoji_u1f4a7, R.color.transparent, R.string.item_water, R.string.quote_water),
    AIR(Group.MATERIAL, R.drawable.emoji_u1f4ad, R.color.transparent, R.string.item_air, R.string.quote_air),
    FIRE(Group.MATERIAL, R.drawable.emoji_u1f525, R.color.transparent, R.string.item_fire, R.string.quote_fire),
    METAL(Group.MATERIAL, R.drawable.mineral, R.color.transparent, R.string.item_metal, R.string.quote_metal),
    ICE(Group.MATERIAL, R.drawable.emoji_u1f9ca, R.color.transparent, R.string.item_ice, R.string.quote_ice),
    PLANT(Group.MATERIAL, R.drawable.emoji_u1f331, R.color.transparent, R.string.item_plant, R.string.quote_plant),
    ANIMAL(Group.MATERIAL, R.drawable.emoji_u1f435, R.color.transparent, R.string.item_animal, R.string.quote_animal),
    THUNDER(Group.MATERIAL, R.drawable.emoji_u1f329, R.color.transparent, R.string.item_thunder, R.string.quote_thunder),
    SPACE(Group.MATERIAL, R.drawable.galaxy, R.color.transparent, R.string.item_space, R.string.quote_space),
    TIME(Group.MATERIAL, R.drawable.emoji_u1f505, R.color.transparent, R.string.item_time, R.string.quote_time),

    // MATERIAL - EARTH or METAL
    STONE(Group.MATERIAL, R.drawable.emoji_u1faa8, R.color.transparent, R.string.item_stone, R.string.quote_stone),
    MAGMA(Group.MATERIAL, R.drawable.emoji_u303d, R.color.red_translucent, R.string.item_magma, R.string.quote_magma),
    MUD(Group.MATERIAL, R.drawable.spot, R.color.yellow_translucent, R.string.item_mud, R.string.quote_mud),
    SAND(Group.MATERIAL, R.drawable.sand, R.color.transparent, R.string.item_sand, R.string.quote_sand),
    GRAVEL(Group.MATERIAL, R.drawable.stone, R.color.transparent, R.string.item_gravel, R.string.quote_gravel),
    COAL(Group.MATERIAL, R.drawable.coal, R.color.transparent, R.string.item_coal, R.string.quote_coal),
    DIAMOND(Group.MATERIAL, R.drawable.emoji_u1f48e, R.color.transparent, R.string.item_diamond, R.string.quote_diamond),
    CLAY(Group.MATERIAL, R.drawable.pile, R.color.red_translucent, R.string.item_clay, R.string.quote_clay),
    PIGMENT(Group.MATERIAL, R.drawable.powder, R.color.transparent, R.string.item_pigment, R.string.quote_pigment),
    DYE(Group.MATERIAL, R.drawable.spot, R.color.transparent, R.string.item_dye, R.string.quote_dye),

    // MATERIAL - WATER or ICE
    STEAM(Group.MATERIAL, R.drawable.emoji_u2668, R.color.transparent, R.string.item_steam, R.string.quote_steam),
    QUARTZ(Group.MATERIAL, R.drawable.crystals, R.color.transparent, R.string.item_quartz, R.string.quote_quartz),
    BUBBLE(Group.MATERIAL, R.drawable.emoji_u1fae7, R.color.transparent, R.string.item_bubble, R.string.quote_bubble),
    WAVE(Group.MATERIAL, R.drawable.emoji_u1f30a, R.color.transparent, R.string.item_wave, R.string.quote_wave),
    LIFE(Group.MATERIAL, R.drawable.emoji_u1f300, R.color.transparent, R.string.item_life, R.string.quote_life),
    DNA(Group.MATERIAL, R.drawable.emoji_u1f9ec, R.color.transparent, R.string.item_dna, R.string.quote_dna),
    CELL(Group.MATERIAL, R.drawable.emoji_u1f9a0, R.color.transparent, R.string.item_cell, R.string.quote_cell),

    SICKNESS(Group.MATERIAL, R.drawable.emoji_u1f480, R.color.transparent, R.string.item_sickness, R.string.quote_sickness),
    INJURY(Group.MATERIAL, R.drawable.emoji_u2764_200d_1fa79, R.color.transparent, R.string.item_injury, R.string.quote_injury),
    SENESCENCE(Group.MATERIAL, R.drawable.walking_stick, R.color.transparent, R.string.item_senescence, R.string.quote_senescence),
    DISEASE(Group.MATERIAL, R.drawable.emoji_u1f47f, R.color.transparent, R.string.item_disease, R.string.quote_disease),
    POISON(Group.MATERIAL, R.drawable.emoji_u2695, R.color.transparent, R.string.item_poison, R.string.quote_poison),
    MEDICINE(Group.MATERIAL, R.drawable.emoji_u1f48a, R.color.transparent, R.string.item_medicine, R.string.quote_medicine),
    VACCINE(Group.MATERIAL, R.drawable.emoji_u1f489, R.color.transparent, R.string.item_vaccine, R.string.quote_vaccine),

    // MATERIAL - AIR or PLANT or ANIMAL
    VIBRATION(Group.MATERIAL, R.drawable.emoji_u3030, R.color.transparent, R.string.item_vibration, R.string.quote_vibration),
    SOUND(Group.MATERIAL, R.drawable.emoji_u1f50a, R.color.transparent, R.string.item_sound, R.string.quote_sound),
    WIND(Group.MATERIAL, R.drawable.wind, R.color.transparent, R.string.item_wind, R.string.quote_wind),
    SMOKE(Group.MATERIAL, R.drawable.smoke, R.color.gray_translucent, R.string.item_smoke, R.string.quote_smoke),

    LEAF(Group.MATERIAL, R.drawable.emoji_u1f343, R.color.transparent, R.string.item_leaf, R.string.quote_leaf),
    ASH(Group.MATERIAL, R.drawable.pile, R.color.gray_translucent, R.string.item_ash, R.string.quote_ash),
    LYE(Group.MATERIAL, R.drawable.emoji_u1f95b, R.color.gray_translucent, R.string.item_lye, R.string.quote_lye),
    STEM(Group.MATERIAL, R.drawable.emoji_u1f33f, R.color.transparent, R.string.item_stem, R.string.quote_stem),
    ROOT(Group.MATERIAL, R.drawable.roots, R.color.transparent, R.string.item_root, R.string.quote_root),
    FLOWER(Group.MATERIAL, R.drawable.flower, R.color.transparent, R.string.item_flower, R.string.quote_flower),
    SEED(Group.MATERIAL, R.drawable.seeds, R.color.transparent, R.string.item_seed, R.string.quote_seed),
    TREE(Group.MATERIAL, R.drawable.emoji_u1f333, R.color.transparent, R.string.item_tree, R.string.quote_tree),
    STICK(Group.MATERIAL, R.drawable.branch, R.color.transparent, R.string.item_stick, R.string.quote_stick),
    STRING(Group.MATERIAL, R.drawable.emoji_u1f9f5, R.color.transparent, R.string.item_string, R.string.quote_string),
    STUMP(Group.MATERIAL, R.drawable.stump, R.color.transparent, R.string.item_stump, R.string.quote_stump),
    WOOD(Group.MATERIAL, R.drawable.emoji_u1fab5, R.color.transparent, R.string.item_wood, R.string.quote_wood),
    FIREWOOD(Group.MATERIAL, R.drawable.wood, R.color.transparent, R.string.item_firewood, R.string.quote_firewood),

    EGG(Group.MATERIAL, R.drawable.emoji_u1f95a, R.color.transparent, R.string.item_egg, R.string.quote_egg),
    HEAD(Group.MATERIAL, R.drawable.emoji_u1f9b3, R.color.transparent, R.string.item_head, R.string.quote_head),
    FOOT(Group.MATERIAL, R.drawable.emoji_u1f9b6, R.color.transparent, R.string.item_foot, R.string.quote_foot),
    HAND(Group.MATERIAL, R.drawable.emoji_u1f590, R.color.transparent, R.string.item_hand, R.string.quote_hand),
    FLIPPER(Group.MATERIAL, R.drawable.whale, R.color.transparent, R.string.item_flipper, R.string.quote_flipper),
    WING(Group.MATERIAL, R.drawable.wing, R.color.transparent, R.string.item_wing, R.string.quote_wing),
    TAIL(Group.MATERIAL, R.drawable.meat, R.color.transparent, R.string.item_tail, R.string.quote_tail),
    BLOOD(Group.MATERIAL, R.drawable.emoji_u1fa78, R.color.transparent, R.string.item_blood, R.string.quote_blood),
    BONE(Group.MATERIAL, R.drawable.emoji_u1f9b4, R.color.transparent, R.string.item_bone, R.string.quote_bone),
    HORN(Group.MATERIAL, R.drawable.cornucopia, R.color.transparent, R.string.item_horn, R.string.quote_horn),
    MEAT(Group.MATERIAL, R.drawable.emoji_u1f969, R.color.transparent, R.string.item_meat, R.string.quote_meat),
    FUR(Group.MATERIAL, R.drawable.fur, R.color.transparent, R.string.item_fur, R.string.quote_fur),
    OIL(Group.MATERIAL, R.drawable.fat, R.color.transparent, R.string.item_oil, R.string.quote_oil),

    // MATERIAL - FIRE or THUNDER
    ELECTRICITY(Group.MATERIAL, R.drawable.emoji_u26a1, R.color.transparent, R.string.item_electricity, R.string.quote_electricity),
    MAGNET(Group.MATERIAL, R.drawable.emoji_u1f9f2, R.color.transparent, R.string.item_magnet, R.string.quote_magnet),

    // MATERIAL - SPACE or TIME
    MIND(Group.MATERIAL, R.drawable.emoji_u1f9e0, R.color.transparent, R.string.item_mind, R.string.quote_mind),
    HEART(Group.MATERIAL, R.drawable.emoji_u1fac0, R.color.transparent, R.string.item_heart, R.string.quote_heart),

    GRAVITY(Group.MATERIAL, R.drawable.gravity, R.color.transparent, R.string.item_gravity, R.string.quote_gravity),
    DIRECTION(Group.MATERIAL, R.drawable.directions, R.color.transparent, R.string.item_direction, R.string.quote_direction),
    SKY(Group.MATERIAL, R.drawable.cloudy, R.color.transparent, R.string.item_sky, R.string.quote_sky),
    STAR(Group.MATERIAL, R.drawable.emoji_u2b50, R.color.transparent, R.string.item_star, R.string.quote_star),
    PHOTON(Group.MATERIAL, R.drawable.emoji_u1f538, R.color.transparent, R.string.item_photon, R.string.quote_photon),
    LIGHT(Group.MATERIAL, R.drawable.emoji_u2728, R.color.transparent, R.string.item_light, R.string.quote_light),
    COLOR(Group.MATERIAL, R.drawable.rgb, R.color.transparent, R.string.item_color, R.string.quote_color),
    GRAVITON(Group.MATERIAL, R.drawable.emoji_u1f539, R.color.transparent, R.string.item_graviton, R.string.quote_graviton),

    // NATURE
    SUN(Group.NATURE, R.drawable.emoji_u2600, R.color.transparent, R.string.item_sun, R.string.quote_sun),
    MOON(Group.NATURE, R.drawable.emoji_u1f315, R.color.transparent, R.string.item_moon, R.string.quote_moon),
    PLANET(Group.NATURE, R.drawable.emoji_u1fa90, R.color.transparent, R.string.item_planet, R.string.quote_planet),
    PLANET_MERCURY(Group.NATURE, R.drawable.mercury, R.color.transparent, R.string.item_planet_mercury, R.string.quote_planet_mercury),
    PLANET_VENUS(Group.NATURE, R.drawable.venus, R.color.transparent, R.string.item_planet_venus, R.string.quote_planet_venus),
    PLANET_MARS(Group.NATURE, R.drawable.mars, R.color.transparent, R.string.item_planet_mars, R.string.quote_planet_mars),
    PLANET_JUPITER(Group.NATURE, R.drawable.jupiter, R.color.transparent, R.string.item_planet_jupiter, R.string.quote_planet_jupiter),
    PLANET_SATURN(Group.NATURE, R.drawable.saturn, R.color.transparent, R.string.item_planet_saturn, R.string.quote_planet_saturn),
    PLANET_URANUS(Group.NATURE, R.drawable.uranus, R.color.transparent, R.string.item_planet_uranus, R.string.quote_planet_uranus),
    PLANET_NEPTUNE(Group.NATURE, R.drawable.neptune, R.color.transparent, R.string.item_planet_neptune, R.string.quote_planet_neptune),
    ECLIPSE(Group.NATURE, R.drawable.emoji_u1f311, R.color.transparent, R.string.item_eclipse, R.string.quote_eclipse),
    DAY(Group.NATURE, R.drawable.emoji_u1f305, R.color.transparent, R.string.item_day, R.string.quote_day),
    NIGHT(Group.NATURE, R.drawable.emoji_u1f30c, R.color.transparent, R.string.item_night, R.string.quote_night),
    COMET(Group.NATURE, R.drawable.emoji_u2604, R.color.transparent, R.string.item_comet, R.string.quote_comet),
    METEOR(Group.NATURE, R.drawable.meteor, R.color.transparent, R.string.item_meteor, R.string.quote_meteor),
    SHOOTING_STAR(Group.NATURE, R.drawable.shooting_star, R.color.transparent, R.string.item_shooting_star, R.string.quote_shooting_star),
    BLACK_HOLE(Group.NATURE, R.drawable.black_hole, R.color.transparent, R.string.item_black_hole, R.string.quote_black_hole),
    AURORA(Group.NATURE, R.drawable.northern_lights, R.color.transparent, R.string.item_aurora, R.string.quote_aurora),

    CLOUD(Group.NATURE, R.drawable.emoji_u2601, R.color.transparent, R.string.item_cloud, R.string.quote_cloud),
    RAIN(Group.NATURE, R.drawable.emoji_u1f327, R.color.transparent, R.string.item_rain, R.string.quote_rain),
    SNOW(Group.NATURE, R.drawable.emoji_u1f328, R.color.transparent, R.string.item_snow, R.string.quote_snow),
    RAINBOW(Group.NATURE, R.drawable.emoji_u1f308, R.color.transparent, R.string.item_rainbow, R.string.quote_rainbow),

    VOLCANO(Group.NATURE, R.drawable.emoji_u1f30b, R.color.transparent, R.string.item_volcano, R.string.quote_volcano),
    MOUNTAIN(Group.NATURE, R.drawable.emoji_u26f0, R.color.transparent, R.string.item_mountain, R.string.quote_mountain),
    RIVER(Group.NATURE, R.drawable.river, R.color.transparent, R.string.item_river, R.string.quote_river),
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
    WATERFALL(Group.MATERIAL, R.drawable.waterfall, R.color.transparent, R.string.item_waterfall, R.string.quote_waterfall),
    WHIRLPOOL(Group.NATURE, R.drawable.cyclone, R.color.transparent, R.string.item_whirlpool, R.string.quote_whirlpool),
    WHIRLWIND(Group.NATURE, R.drawable.emoji_u1f32a, R.color.transparent, R.string.item_whirlwind, R.string.quote_whirlwind),
    MIRAGE(Group.NATURE, R.drawable.mirage, R.color.transparent, R.string.item_mirage, R.string.quote_mirage),
    FOG(Group.NATURE, R.drawable.emoji_u1f32b, R.color.transparent, R.string.item_fog, R.string.quote_fog),
    FROST(Group.NATURE, R.drawable.emoji_u2744, R.color.transparent, R.string.item_frost, R.string.quote_frost),
    ICICLE(Group.NATURE, R.drawable.icicles, R.color.transparent, R.string.item_icicle, R.string.quote_icicle),

    // ARTIFACT
    BRICK(Group.ARTIFACT, R.drawable.brick, R.color.transparent, R.string.item_brick, R.string.quote_brick),
    WALL(Group.ARTIFACT, R.drawable.emoji_u1f9f1, R.color.transparent, R.string.item_wall, R.string.quote_wall),
    EARTHENWARE(Group.ARTIFACT, R.drawable.vase, R.color.transparent, R.string.item_earthenware, R.string.quote_earthenware),
    POTTERY(Group.ARTIFACT, R.drawable.emoji_u26b1, R.color.transparent, R.string.item_pottery, R.string.quote_pottery),
    GLASS(Group.ARTIFACT, R.drawable.microscope_slides, R.color.transparent, R.string.item_glass, R.string.quote_glass),
    CONSTELLATION(Group.ARTIFACT, R.drawable.constellation, R.color.transparent, R.string.item_constellation, R.string.quote_constellation),
    PERFUME(Group.ARTIFACT, R.drawable.perfume, R.color.transparent, R.string.item_perfume, R.string.quote_perfume),
    TOTEM(Group.ARTIFACT, R.drawable.totem, R.color.transparent, R.string.item_totem, R.string.quote_totem),

    // TOOL
    LAMP(Group.TOOL, R.drawable.emoji_u1fa94, R.color.transparent, R.string.item_lamp, R.string.quote_lamp),
    HAND_AXE(Group.TOOL, R.drawable.axe, R.color.transparent, R.string.item_hand_axe, R.string.quote_hand_axe),
    SWORD(Group.TOOL, R.drawable.emoji_u1f5e1, R.color.transparent, R.string.item_sword, R.string.quote_sword),
    KNIFE(Group.TOOL, R.drawable.emoji_u1f52a, R.color.transparent, R.string.item_knife, R.string.quote_knife),
    AXE(Group.TOOL, R.drawable.emoji_u1fa93, R.color.transparent, R.string.item_axe, R.string.quote_axe),
    COMPASS(Group.TOOL, R.drawable.emoji_u1f9ed, R.color.transparent, R.string.item_compass, R.string.quote_compass),
    BONFIRE(Group.TOOL, R.drawable.bonfire, R.color.transparent, R.string.item_bonfire, R.string.quote_bonfire),
    NEEDLE(Group.TOOL, R.drawable.needle, R.color.transparent, R.string.item_needle, R.string.quote_needle),
    SPEAR(Group.TOOL, R.drawable.spear, R.color.transparent, R.string.item_spear, R.string.quote_spear),
    BOW_AND_ARROW(Group.TOOL, R.drawable.emoji_u1f3f9, R.color.transparent, R.string.item_bow_and_arrow, R.string.quote_bow_and_arrow),
    FISHING_ROD(Group.TOOL, R.drawable.emoji_u1f3a3, R.color.transparent, R.string.item_fishing_rod, R.string.quote_fishing_rod),

    // TECHNOLOGY
    PAINTING(Group.TECHNOLOGY, R.drawable.emoji_u1f5bc, R.color.transparent, R.string.item_painting, R.string.quote_painting),
    TRAPPING(Group.TECHNOLOGY, R.drawable.emoji_u1f573, R.color.transparent, R.string.item_trapping, R.string.quote_trapping),

    // FOOD
    SALT(Group.FOOD, R.drawable.emoji_u1f9c2, R.color.transparent, R.string.item_salt, R.string.quote_salt),

    // CREATURE - VIRUS
    VIRUS(Group.CREATURE, R.drawable.coronavirus, R.color.transparent, R.string.item_virus, R.string.quote_virus),

    // CREATURE - BACTERIA
    BACTERIA(Group.CREATURE, R.drawable.emoji_u1f9a0, R.color.transparent, R.string.item_bacteria, R.string.quote_bacteria),
    BLUE_GREEN_ALGAE(Group.CREATURE, R.drawable.synechocystis_cyanobacteria, R.color.transparent, R.string.item_blue_green_algae, R.string.quote_blue_green_algae),
    BLACK_DEATH(Group.CREATURE, R.drawable.emoji_u2620, R.color.transparent, R.string.item_black_death, R.string.quote_black_death),

    // CREATURE - ARCHAEA
    @Suppress("NO-IMAGE") ARCHAEA(Group.CREATURE, R.drawable.emoji_u1f9a0, R.color.cyan_translucent, R.string.item_archaea, R.string.quote_archaea),
    @Suppress("NO-IMAGE") THERMOPHILE(Group.CREATURE, R.drawable.emoji_u1f9a0, R.color.yellow_translucent, R.string.item_thermophile, R.string.quote_thermophile),
    @Suppress("NO-IMAGE") HALOARCHAEA(Group.CREATURE, R.drawable.emoji_u1f9a0, R.color.magenta_translucent, R.string.item_haloarchaea, R.string.quote_haloarchaea),
    @Suppress("NO-IMAGE") METHANOGEN(Group.CREATURE, R.drawable.emoji_u1f9a0, R.color.red_translucent, R.string.item_methanogen, R.string.quote_methanogen),

    // CREATURE - EUKARYOTE
    @Suppress("NO-IMAGE") EUKARYOTE(Group.CREATURE, R.drawable.emoji_u1f9a0, R.color.blue_translucent, R.string.item_eukaryote, R.string.quote_eukaryote),
    AMOEBA(Group.CREATURE, R.drawable.amoeba, R.color.transparent, R.string.item_amoeba, R.string.quote_amoeba),
    SPOROZOA(Group.CREATURE, R.drawable.plasmodium_falciparum, R.color.transparent, R.string.item_sporozoa, R.string.quote_sporozoa),
    FLAGELLATE(Group.CREATURE, R.drawable.euglena, R.color.transparent, R.string.item_flagellate, R.string.quote_flagellate),
    PROTOZOA(Group.CREATURE, R.drawable.protist, R.color.transparent, R.string.item_protozoa, R.string.quote_protozoa),
    CILIATE(Group.CREATURE, R.drawable.paramecium, R.color.transparent, R.string.item_ciliate, R.string.quote_ciliate),

    // PLANT
    @Suppress("NO-IMAGE") BROWN_ALGAE(Group.PLANT, R.drawable.seaweed, R.color.yellow_translucent, R.string.item_brown_algae, R.string.quote_brown_algae),
    @Suppress("NO-IMAGE") RED_ALGAE(Group.PLANT, R.drawable.seaweed, R.color.red_translucent, R.string.item_red_algae, R.string.quote_red_algae),
    @Suppress("NO-IMAGE") GREEN_ALGAE(Group.PLANT, R.drawable.seaweed, R.color.transparent, R.string.item_green_algae, R.string.quote_green_algae),
    EMBRYOPHYTE(Group.PLANT, R.drawable.pigment, R.color.transparent, R.string.item_embryophyte, R.string.quote_embryophyte),
    MOSS(Group.PLANT, R.drawable.moss, R.color.transparent, R.string.item_moss, R.string.quote_moss),
    LYCOPHYTE(Group.PLANT, R.drawable.bird_nest_fern, R.color.transparent, R.string.item_lycophyte, R.string.quote_lycophyte),
    FERN(Group.PLANT, R.drawable.fern, R.color.transparent, R.string.item_fern, R.string.quote_fern),
    CYCAD(Group.PLANT, R.drawable.sago_palm, R.color.transparent, R.string.item_cycad, R.string.quote_cycad),
    GINKGO(Group.PLANT, R.drawable.ginkgo, R.color.transparent, R.string.item_ginkgo, R.string.quote_ginkgo),
    CONIFER(Group.PLANT, R.drawable.emoji_u1f332, R.color.transparent, R.string.item_conifer, R.string.quote_conifer),

    // PLANT - ANGIOSPERM
    ANGIOSPERM(Group.PLANT, R.drawable.osmanthus, R.color.transparent, R.string.item_angiosperm, R.string.quote_angiosperm),

    // PLANT - ANGIOSPERM - Nymphaeales
    WATER_LILY(Group.PLANT, R.drawable.emoji_u1fab7, R.color.transparent, R.string.item_water_lily, R.string.quote_water_lily),

    // PLANT - ANGIOSPERM - Magnoliids
    CAMPHOR_TREE(Group.PLANT, R.drawable.bay_tree, R.color.transparent, R.string.item_camphor_tree, R.string.quote_camphor_tree),
    HOUTTUYNIA(Group.PLANT, R.drawable.leaf, R.color.transparent, R.string.item_houttuynia, R.string.quote_houttuynia),
    PEPPER(Group.PLANT, R.drawable.black_pepper, R.color.transparent, R.string.item_pepper, R.string.quote_pepper),

    // PLANT - ANGIOSPERM - Alismatales
    TARO(Group.PLANT, R.drawable.taro, R.color.transparent, R.string.item_taro, R.string.quote_taro),
    KONJAC(Group.PLANT, R.drawable.potato, R.color.transparent, R.string.item_konjac, R.string.quote_konjac),

    // PLANT - ANGIOSPERM - Dioscoreales
    YAM(Group.PLANT, R.drawable.diet, R.color.transparent, R.string.item_yam, R.string.quote_yam),

    // PLANT - ANGIOSPERM - Liliales
    LILY(Group.PLANT, R.drawable.lily, R.color.transparent, R.string.item_lily, R.string.quote_lily),

    // PLANT - ANGIOSPERM - Asparagales
    ORCHID(Group.PLANT, R.drawable.orchid, R.color.transparent, R.string.item_orchid, R.string.quote_orchid),
    LEEK(Group.PLANT, R.drawable.leek, R.color.transparent, R.string.item_leek, R.string.quote_leek),
    ONION(Group.PLANT, R.drawable.emoji_u1f9c5, R.color.transparent, R.string.item_onion, R.string.quote_onion),

    // PLANT - ANGIOSPERM - Poales
    PINEAPPLE(Group.PLANT, R.drawable.emoji_u1f34d, R.color.transparent, R.string.item_pineapple, R.string.quote_pineapple),
    BAMBOO(Group.PLANT, R.drawable.bamboo, R.color.transparent, R.string.item_bamboo, R.string.quote_bamboo),
    WHEAT(Group.PLANT, R.drawable.wheat, R.color.transparent, R.string.item_wheat, R.string.quote_wheat),
    RICE_PLANT(Group.PLANT, R.drawable.emoji_u1f33e, R.color.transparent, R.string.item_rice_plant, R.string.quote_rice_plant),
    MAIZE(Group.PLANT, R.drawable.emoji_u1f33d, R.color.transparent, R.string.item_maize, R.string.quote_maize),
    SUGAR_CANE(Group.PLANT, R.drawable.sugar_cane, R.color.transparent, R.string.item_sugar_cane, R.string.quote_sugar_cane),

    // PLANT - ANGIOSPERM - Zingiberales
    BANANA(Group.PLANT, R.drawable.emoji_u1f34c, R.color.transparent, R.string.item_banana, R.string.quote_banana),

    // PLANT - ANGIOSPERM - Vitales
    GRAPE(Group.PLANT, R.drawable.emoji_u1f347, R.color.transparent, R.string.item_grape, R.string.quote_grape),

    // PLANT - ANGIOSPERM - Fabales
    SOYBEAN(Group.PLANT, R.drawable.emoji_u1fad8, R.color.black_translucent, R.string.item_soybean, R.string.quote_soybean),

    // PLANT - ANGIOSPERM - Rosales
    ROSE(Group.PLANT, R.drawable.emoji_u1f339, R.color.transparent, R.string.item_rose, R.string.quote_rose),
    STRAWBERRY(Group.PLANT, R.drawable.emoji_u1f353, R.color.transparent, R.string.item_strawberry, R.string.quote_strawberry),
    PEACH(Group.PLANT, R.drawable.emoji_u1f351, R.color.transparent, R.string.item_peach, R.string.quote_peach),
    CHERRY(Group.PLANT, R.drawable.emoji_u1f352, R.color.transparent, R.string.item_cherry, R.string.quote_cherry),
    PEAR(Group.PLANT, R.drawable.emoji_u1f350, R.color.transparent, R.string.item_pear, R.string.quote_pear),
    APPLE(Group.PLANT, R.drawable.emoji_u1f34e, R.color.transparent, R.string.item_apple, R.string.quote_apple),

    // PLANT - ANGIOSPERM - Fagales
    BEECH(Group.PLANT, R.drawable.beech, R.color.transparent, R.string.item_beech, R.string.quote_beech),
    CHESTNUT(Group.PLANT, R.drawable.emoji_u1f330, R.color.transparent, R.string.item_chestnut, R.string.quote_chestnut),
    WALNUT(Group.PLANT, R.drawable.nut, R.color.transparent, R.string.item_walnut, R.string.quote_walnut),

    // PLANT - ANGIOSPERM - Cucurbitales
    CALABASH(Group.PLANT, R.drawable.calabash, R.color.transparent, R.string.item_calabash, R.string.quote_calabash),
    CUCUMBER(Group.PLANT, R.drawable.emoji_u1f952, R.color.transparent, R.string.item_cucumber, R.string.quote_cucumber),
    PUMPKIN(Group.PLANT, R.drawable.pumpkin, R.color.transparent, R.string.item_pumpkin, R.string.quote_pumpkin),
    MELON(Group.PLANT, R.drawable.emoji_u1f348, R.color.transparent, R.string.item_melon, R.string.quote_melon),

    // PLANT - ANGIOSPERM - Malpighiales
    RAFFLESIA(Group.PLANT, R.drawable.rafflesia, R.color.transparent, R.string.item_rafflesia, R.string.quote_rafflesia),
    RUBBER_TREE(Group.PLANT, R.drawable.rubber_plant, R.color.transparent, R.string.item_rubber_tree, R.string.quote_rubber_tree),

    // PLANT - ANGIOSPERM - Sapindales
    ORANGE(Group.PLANT, R.drawable.emoji_u1f34a, R.color.transparent, R.string.item_orange, R.string.quote_orange),

    // PLANT - ANGIOSPERM - Brassicales
    MUSTARD(Group.PLANT, R.drawable.kale, R.color.transparent, R.string.item_mustard, R.string.quote_mustard),
    CABBAGE(Group.PLANT, R.drawable.cabbage, R.color.transparent, R.string.item_cabbage, R.string.quote_cabbage),
    TURNIP(Group.PLANT, R.drawable.turnip, R.color.transparent, R.string.item_turnip, R.string.quote_turnip),
    RADISH(Group.PLANT, R.drawable.radish, R.color.transparent, R.string.item_radish, R.string.quote_radish),

    // PLANT - ANGIOSPERM - Santalales
    MISTLETOE(Group.PLANT, R.drawable.mistletoe, R.color.transparent, R.string.item_mistletoe, R.string.quote_mistletoe),

    // PLANT - ANGIOSPERM - Caryophyllales
    SPINACH(Group.PLANT, R.drawable.spinach, R.color.transparent, R.string.item_spinach, R.string.quote_spinach),
    SUGAR_BEET(Group.PLANT, R.drawable.beet, R.color.transparent, R.string.item_sugar_beet, R.string.quote_sugar_beet),
    CACTUS(Group.PLANT, R.drawable.emoji_u1f335, R.color.transparent, R.string.item_cactus, R.string.quote_cactus),

    // PLANT - ANGIOSPERM - Asterales
    CHRYSANTHEMUM(Group.PLANT, R.drawable.chrysanthemum, R.color.transparent, R.string.item_chrysanthemum, R.string.quote_chrysanthemum),
    SUNFLOWER(Group.PLANT, R.drawable.emoji_u1f33b, R.color.transparent, R.string.item_sunflower, R.string.quote_sunflower),
    LETTUCE(Group.PLANT, R.drawable.emoji_u1f96c, R.color.transparent, R.string.item_lettuce, R.string.quote_lettuce),
    BURDOCK(Group.PLANT, R.drawable.burdock, R.color.transparent, R.string.item_burdock, R.string.quote_burdock),

    // PLANT - ANGIOSPERM - Apiales
    CARROT(Group.PLANT, R.drawable.emoji_u1f955, R.color.transparent, R.string.item_carrot, R.string.quote_carrot),

    // PLANT - ANGIOSPERM - Solanales
    EGGPLANT(Group.PLANT, R.drawable.emoji_u1f346, R.color.transparent, R.string.item_eggplant, R.string.quote_eggplant),
    TOMATO(Group.PLANT, R.drawable.emoji_u1f345, R.color.transparent, R.string.item_tomato, R.string.quote_tomato),
    POTATO(Group.PLANT, R.drawable.emoji_u1f954, R.color.transparent, R.string.item_potato, R.string.quote_potato),
    BELL_PEPPER(Group.PLANT, R.drawable.emoji_u1fad1, R.color.transparent, R.string.item_bell_pepper, R.string.quote_bell_pepper),

    // PLANT - ANGIOSPERM - Lamiales
    OLIVE(Group.PLANT, R.drawable.emoji_u1fad2, R.color.transparent, R.string.item_olive, R.string.quote_olive),
    SESAME(Group.PLANT, R.drawable.sesame, R.color.transparent, R.string.item_sesame, R.string.quote_sesame),

    // ANIMAL - Fungi
    FUNGI(Group.ANIMAL, R.drawable.fungi, R.color.transparent, R.string.item_fungi, R.string.quote_fungi),
    MUSHROOM(Group.ANIMAL, R.drawable.emoji_u1f344, R.color.transparent, R.string.item_mushroom, R.string.quote_mushroom),
    MOLD(Group.ANIMAL, R.drawable.mould, R.color.transparent, R.string.item_mold, R.string.quote_mold),
    YEAST(Group.ANIMAL, R.drawable.yeast, R.color.transparent, R.string.item_yeast, R.string.quote_yeast),

    // ANIMAL - Porifera
    SPONGE(Group.ANIMAL, R.drawable.emoji_u1f9fd, R.color.transparent, R.string.item_sponge, R.string.quote_sponge),

    // ANIMAL - Ctenophora
    SEA_GOOSEBERRY(Group.ANIMAL, R.drawable.comb_jelly, R.color.transparent, R.string.item_sea_gooseberry, R.string.quote_sea_gooseberry),

    // ANIMAL - Cnidaria
    SEA_ANEMONE(Group.ANIMAL, R.drawable.sea_anemone, R.color.transparent, R.string.item_sea_anemone, R.string.quote_sea_anemone),
    CORAL(Group.ANIMAL, R.drawable.emoji_u1fab8, R.color.transparent, R.string.item_coral, R.string.quote_coral),
    JELLYFISH(Group.ANIMAL, R.drawable.jellyfish, R.color.transparent, R.string.item_jellyfish, R.string.quote_jellyfish),

    // ANIMAL - Echinodermata
    STARFISH(Group.ANIMAL, R.drawable.starfish, R.color.transparent, R.string.item_starfish, R.string.quote_starfish),
    SEA_URCHIN(Group.ANIMAL, R.drawable.sea_urchin, R.color.transparent, R.string.item_sea_urchin, R.string.quote_sea_urchin),
    SEA_CUCUMBER(Group.ANIMAL, R.drawable.sea_cucumber, R.color.transparent, R.string.item_sea_cucumber, R.string.quote_sea_cucumber),

    // ANIMAL - Arthropoda - Chelicerata
    SEA_SPIDER(Group.ANIMAL, R.drawable.spider, R.color.transparent, R.string.item_sea_spider, R.string.quote_sea_spider),
    // HORSESHOE_CRAB(Group.ANIMAL, R.drawable.item_empty, R.color.transparent, R.string.item_horseshoe_crab, R.string.quote_horseshoe_crab),
    MITE(Group.ANIMAL, R.drawable.mite, R.color.transparent, R.string.item_mite, R.string.quote_mite),
    SCORPION(Group.ANIMAL, R.drawable.emoji_u1f982, R.color.transparent, R.string.item_scorpion, R.string.quote_scorpion),
    SPIDER(Group.ANIMAL, R.drawable.emoji_u1f577, R.color.transparent, R.string.item_spider, R.string.quote_spider),

    // ANIMAL - Arthropoda - Myriapoda
    CENTIPEDE(Group.ANIMAL, R.drawable.centipede, R.color.transparent, R.string.item_centipede, R.string.quote_centipede),

    // ANIMAL - Arthropoda - Crustacea
    SHRIMP(Group.ANIMAL, R.drawable.emoji_u1f990, R.color.transparent, R.string.item_shrimp, R.string.quote_shrimp),
    HERMIT_CRAB(Group.ANIMAL, R.drawable.hermit_crab, R.color.transparent, R.string.item_hermit_crab, R.string.quote_hermit_crab),
    CRAB(Group.ANIMAL, R.drawable.emoji_u1f980, R.color.transparent, R.string.item_crab, R.string.quote_crab),
    CRAYFISH(Group.ANIMAL, R.drawable.emoji_u1f99e, R.color.transparent, R.string.item_crayfish, R.string.quote_crayfish),
    PILL_BUG(Group.ANIMAL, R.drawable.pill_bug, R.color.transparent, R.string.item_pill_bug, R.string.quote_pill_bug),

    // ANIMAL - Arthropoda - Insecta
    DRAGONFLY(Group.ANIMAL, R.drawable.dragonfly, R.color.transparent, R.string.item_dragonfly, R.string.quote_dragonfly),
    GRASSHOPPER(Group.ANIMAL, R.drawable.emoji_u1f997, R.color.transparent, R.string.item_grasshopper, R.string.quote_grasshopper),
    MANTIS(Group.ANIMAL, R.drawable.praying_mantis, R.color.transparent, R.string.item_mantis, R.string.quote_mantis),
    COCKROACH(Group.ANIMAL, R.drawable.emoji_u1fab3, R.color.transparent, R.string.item_cockroach, R.string.quote_cockroach),
    WATER_STRIDER(Group.ANIMAL, R.drawable.water_strider, R.color.transparent, R.string.item_water_strider, R.string.quote_water_strider),
    STINK_BUG(Group.ANIMAL, R.drawable.stink_bug, R.color.transparent, R.string.item_stink_bug, R.string.quote_stink_bug),
    CICADA(Group.ANIMAL, R.drawable.cicada, R.color.transparent, R.string.item_cicada, R.string.quote_cicada),
    MOSQUITO(Group.ANIMAL, R.drawable.emoji_u1f99f, R.color.transparent, R.string.item_mosquito, R.string.quote_mosquito),
    FLY(Group.ANIMAL, R.drawable.emoji_u1fab0, R.color.transparent, R.string.item_fly, R.string.quote_fly),
    FLEA(Group.ANIMAL, R.drawable.flea, R.color.transparent, R.string.item_flea, R.string.quote_flea),
    MOTH(Group.ANIMAL, R.drawable.moth, R.color.transparent, R.string.item_moth, R.string.quote_moth),
    BUTTERFLY(Group.ANIMAL, R.drawable.emoji_u1f98b, R.color.transparent, R.string.item_butterfly, R.string.quote_butterfly),
    BEE(Group.ANIMAL, R.drawable.emoji_u1f41d, R.color.transparent, R.string.item_bee, R.string.quote_bee),
    ANT(Group.ANIMAL, R.drawable.emoji_u1f41c, R.color.transparent, R.string.item_ant, R.string.quote_ant),
    FIREFLY(Group.ANIMAL, R.drawable.firefly, R.color.transparent, R.string.item_firefly, R.string.quote_firefly),
    LADYBUG(Group.ANIMAL, R.drawable.emoji_u1f41e, R.color.transparent, R.string.item_ladybug, R.string.quote_ladybug),
    SCARAB_BEETLE(Group.ANIMAL, R.drawable.emoji_u1fab2, R.color.transparent, R.string.item_scarab_beetle, R.string.quote_scarab_beetle),
    RHINOCEROS_BEETLE(Group.ANIMAL, R.drawable.rhinoceros_beetle, R.color.transparent, R.string.item_rhinoceros_beetle, R.string.quote_rhinoceros_beetle),
    STAG_BEETLE(Group.ANIMAL, R.drawable.stag_beetle, R.color.transparent, R.string.item_stag_beetle, R.string.quote_stag_beetle),

    // ANIMAL - Annelida
    EARTHWORM(Group.ANIMAL, R.drawable.emoji_u1fab1, R.color.transparent, R.string.item_earthworm, R.string.quote_earthworm),
    LEECH(Group.ANIMAL, R.drawable.leech, R.color.transparent, R.string.item_leech, R.string.quote_leech),

    // ANIMAL - Mollusca
    SHELLFISH(Group.ANIMAL, R.drawable.emoji_u1f41a, R.color.transparent, R.string.item_shellfish, R.string.quote_shellfish),
    SEA_SLUG(Group.ANIMAL, R.drawable.sea_slug, R.color.transparent, R.string.item_sea_slug, R.string.quote_sea_slug),
    SNAIL(Group.ANIMAL, R.drawable.emoji_u1f40c, R.color.transparent, R.string.item_snail, R.string.quote_snail),
    SLUG(Group.ANIMAL, R.drawable.slug, R.color.transparent, R.string.item_slug, R.string.quote_slug),
    NAUTILUS(Group.ANIMAL, R.drawable.nautilus, R.color.transparent, R.string.item_nautilus, R.string.quote_nautilus),
    OCTOPUS(Group.ANIMAL, R.drawable.emoji_u1f419, R.color.transparent, R.string.item_octopus, R.string.quote_octopus),
    SQUID(Group.ANIMAL, R.drawable.emoji_u1f991, R.color.transparent, R.string.item_squid, R.string.quote_squid),

    // ANIMAL - Chordata - Chondrichthyes
    SHARK(Group.ANIMAL, R.drawable.emoji_u1f988, R.color.transparent, R.string.item_shark, R.string.quote_shark),
    RAY(Group.ANIMAL, R.drawable.ray, R.color.transparent, R.string.item_ray, R.string.quote_ray),
    @Suppress("NO-IMAGE") ELECTRIC_RAY(Group.ANIMAL, R.drawable.ray, R.color.yellow_translucent, R.string.item_electric_ray, R.string.quote_electric_ray),

    // ANIMAL - Chordata - Actinopterygii
    VERTEBRATE(Group.ANIMAL, R.drawable.shark, R.color.transparent, R.string.item_vertebrate, R.string.quote_vertebrate),
    MORAY_EEL(Group.ANIMAL, R.drawable.moray, R.color.transparent, R.string.item_moray_eel, R.string.quote_moray_eel),
    EEL(Group.ANIMAL, R.drawable.eel, R.color.transparent, R.string.item_eel, R.string.quote_eel),

    HERRING(Group.ANIMAL, R.drawable.herring, R.color.transparent, R.string.item_herring, R.string.quote_herring),
    // LOACH(Group.ANIMAL, R.drawable.item_empty, R.color.transparent, R.string.item_loach, R.string.quote_loach),
    CARP(Group.ANIMAL, R.drawable.carp, R.color.transparent, R.string.item_carp, R.string.quote_carp),
    KOI(Group.ANIMAL, R.drawable.koi_fish, R.color.transparent, R.string.item_koi, R.string.quote_koi),
    GOLDFISH(Group.ANIMAL, R.drawable.gold_fish, R.color.transparent, R.string.item_goldfish, R.string.quote_goldfish),
    PIRANHA(Group.ANIMAL, R.drawable.piranha, R.color.transparent, R.string.item_piranha, R.string.quote_piranha),
    CATFISH(Group.ANIMAL, R.drawable.catfish, R.color.transparent, R.string.item_catfish, R.string.quote_catfish),
    @Suppress("NO-IMAGE") ELECTRIC_CATFISH(Group.ANIMAL, R.drawable.catfish, R.color.yellow_translucent, R.string.item_electric_catfish, R.string.quote_electric_catfish),
    @Suppress("NO-IMAGE") ELECTRIC_EEL(Group.ANIMAL, R.drawable.eel, R.color.yellow_translucent, R.string.item_electric_eel, R.string.quote_electric_eel),
    SALMON(Group.ANIMAL, R.drawable.salmon, R.color.transparent, R.string.item_salmon, R.string.quote_salmon),
    // SMELT(Group.ANIMAL, R.drawable.item_empty, R.color.transparent, R.string.item_smelt, R.string.quote_smelt),
    // LITTLE_DRAGONFISH(Group.ANIMAL, R.drawable.item_empty, R.color.transparent, R.string.item_little_dragonfish, R.string.quote_little_dragonfish),
    // LEAFY_SEADRAGON(Group.ANIMAL, R.drawable.item_empty, R.color.transparent, R.string.item_leafy_seadragon, R.string.quote_leafy_seadragon),
    SEAHORSE(Group.ANIMAL, R.drawable.seahorse, R.color.transparent, R.string.item_seahorse, R.string.quote_seahorse),
    FLATFISH(Group.ANIMAL, R.drawable.flounder, R.color.transparent, R.string.item_flatfish, R.string.quote_flatfish),
    CLOWNFISH(Group.ANIMAL, R.drawable.clownfish, R.color.transparent, R.string.item_clownfish, R.string.quote_clownfish),
    TUNA(Group.ANIMAL, R.drawable.tuna, R.color.transparent, R.string.item_tuna, R.string.quote_tuna),
    SEA_BASS(Group.ANIMAL, R.drawable.perch, R.color.transparent, R.string.item_sea_bass, R.string.quote_sea_bass),
    @Suppress("NO-IMAGE") BLACK_BASS(Group.ANIMAL, R.drawable.perch, R.color.gray_translucent, R.string.item_black_bass, R.string.quote_black_bass),
    SEA_BREAM(Group.ANIMAL, R.drawable.bream, R.color.transparent, R.string.item_sea_bream, R.string.quote_sea_bream),
    SUNFISH(Group.ANIMAL, R.drawable.sunfish, R.color.transparent, R.string.item_sunfish, R.string.quote_sunfish),
    PORCUPINEFISH(Group.ANIMAL, R.drawable.emoji_u1f421, R.color.transparent, R.string.item_porcupinefish, R.string.quote_porcupinefish),
    PUFFERFISH(Group.ANIMAL, R.drawable.puffer_fish, R.color.transparent, R.string.item_pufferfish, R.string.quote_pufferfish),
    ANGLERFISH(Group.ANIMAL, R.drawable.angler, R.color.transparent, R.string.item_anglerfish, R.string.quote_anglerfish),
    FOOTBALLFISH(Group.ANIMAL, R.drawable.footballfish, R.color.transparent, R.string.item_footballfish, R.string.quote_footballfish),

    // ANIMAL - Chordata - Sarcopterygii
    TETRAPOD(Group.ANIMAL, R.drawable.tadpole, R.color.transparent, R.string.item_tetrapod, R.string.quote_tetrapod),

    // ANIMAL - Chordata - Sarcopterygii - Amphibia
    FROG(Group.ANIMAL, R.drawable.frog, R.color.transparent, R.string.item_frog, R.string.quote_frog),
    SALAMANDER(Group.ANIMAL, R.drawable.salamander, R.color.transparent, R.string.item_salamander, R.string.quote_salamander),

    // ANIMAL - Chordata - Sarcopterygii - Reptilia
    ICHTHYOSAUR(Group.ANIMAL, R.drawable.ichthyosaurus, R.color.transparent, R.string.item_Ichthyosaur, R.string.quote_Ichthyosaur),
    LIZARD(Group.ANIMAL, R.drawable.emoji_u1f98e, R.color.transparent, R.string.item_lizard, R.string.quote_lizard),
    @Suppress("NO-IMAGE") FLYING_LIZARD(Group.ANIMAL, R.drawable.emoji_u1f98e, R.color.gray_translucent, R.string.item_flying_lizard, R.string.quote_flying_lizard),
    CHAMELEON(Group.ANIMAL, R.drawable.chameleon, R.color.transparent, R.string.item_chameleon, R.string.quote_chameleon),
    SNAKE(Group.ANIMAL, R.drawable.emoji_u1f40d, R.color.transparent, R.string.item_snake, R.string.quote_snake),
    PLESIOSAUR(Group.ANIMAL, R.drawable.plesiosaur, R.color.transparent, R.string.item_plesiosaur, R.string.quote_plesiosaur),
    TURTLE(Group.ANIMAL, R.drawable.turtle, R.color.transparent, R.string.item_turtle, R.string.quote_turtle),
    SEA_TURTLE(Group.ANIMAL, R.drawable.sea_turtle, R.color.transparent, R.string.item_sea_turtle, R.string.quote_sea_turtle),
    CROCODILE(Group.ANIMAL, R.drawable.emoji_u1f40a, R.color.transparent, R.string.item_crocodile, R.string.quote_crocodile),

    // ANIMAL - Chordata - Dinosauria
    PTEROSAUR(Group.ANIMAL, R.drawable.pterosaur, R.color.transparent, R.string.item_pterosaur, R.string.quote_pterosaur),
    SAUROPODA(Group.ANIMAL, R.drawable.emoji_u1f995, R.color.transparent, R.string.item_sauropod, R.string.quote_sauropod),
    STEGOSAUR(Group.ANIMAL, R.drawable.stegosaurus, R.color.transparent, R.string.item_stegosaur, R.string.quote_stegosaur),
    ANKYLOSAUR(Group.ANIMAL, R.drawable.ankylosaurus, R.color.transparent, R.string.item_ankylosaur, R.string.quote_ankylosaur),
    PACHYCEPHALOSAUR(Group.ANIMAL, R.drawable.pachycephalosaurus, R.color.transparent, R.string.item_pachycephalosaur, R.string.quote_pachycephalosaur),
    CERATOPS(Group.ANIMAL, R.drawable.triceratops, R.color.transparent, R.string.item_ceratops, R.string.quote_ceratops),
    THEROPODA(Group.ANIMAL, R.drawable.emoji_u1f996, R.color.transparent, R.string.item_theropod, R.string.quote_theropod),

    // ANIMAL - Chordata - Aves
    ARCHAEOPTERYX(Group.ANIMAL, R.drawable.archaeopteryx, R.color.transparent, R.string.item_archaeopteryx, R.string.quote_archaeopteryx),
    BIRD(Group.ANIMAL, R.drawable.emoji_u1f426, R.color.transparent, R.string.item_bird, R.string.quote_bird),

    // ANIMAL - Chordata - Aves - Struthioniformes
    OSTRICH(Group.ANIMAL, R.drawable.ostrich, R.color.transparent, R.string.item_ostrich, R.string.quote_ostrich),
    EMU(Group.ANIMAL, R.drawable.emu, R.color.transparent, R.string.item_emu, R.string.quote_emu),

    // ANIMAL - Chordata - Aves	- Galliformes
    TURKEY(Group.ANIMAL, R.drawable.emoji_u1f983, R.color.transparent, R.string.item_turkey, R.string.quote_turkey),
    PEACOCK(Group.ANIMAL, R.drawable.emoji_u1f99a, R.color.transparent, R.string.item_peacock, R.string.quote_peacock),
    COCK(Group.ANIMAL, R.drawable.emoji_u1f413, R.color.transparent, R.string.item_cock, R.string.quote_cock),

    // ANIMAL - Chordata - Aves	- Anseriformes
    SWAN(Group.ANIMAL, R.drawable.emoji_u1f9a2, R.color.transparent, R.string.item_swan, R.string.quote_swan),
    DUCK(Group.ANIMAL, R.drawable.emoji_u1f986, R.color.transparent, R.string.item_duck, R.string.quote_duck),

    // ANIMAL - Chordata - Aves	- Phoenicopteriformes
    FLAMINGO(Group.ANIMAL, R.drawable.emoji_u1f9a9, R.color.transparent, R.string.item_flamingo, R.string.quote_flamingo),

    // ANIMAL - Chordata - Aves	- Columbiformes
    PIGEON(Group.ANIMAL, R.drawable.pigeon, R.color.transparent, R.string.item_pigeon, R.string.quote_pigeon),
    DODO(Group.ANIMAL, R.drawable.emoji_u1f9a4, R.color.transparent, R.string.item_dodo, R.string.quote_dodo),

    // ANIMAL - Chordata - Aves	- Cuculiformes
    CUCKOO(Group.ANIMAL, R.drawable.cuckoo, R.color.transparent, R.string.item_cuckoo, R.string.quote_cuckoo),

    // ANIMAL - Chordata - Aves	- Gruiformes
    CRANE(Group.ANIMAL, R.drawable.red_crowned_crane, R.color.transparent, R.string.item_crane, R.string.quote_crane),

    // ANIMAL - Chordata - Aves	- Apodiformes
    HUMMINGBIRD(Group.ANIMAL, R.drawable.hummingbird, R.color.transparent, R.string.item_hummingbird, R.string.quote_hummingbird),

    // ANIMAL - Chordata - Aves	- Sphenisciformes
    PENGUIN(Group.ANIMAL, R.drawable.emoji_u1f427, R.color.transparent, R.string.item_penguin, R.string.quote_penguin),

    // ANIMAL - Chordata - Aves	- Accipitriformes
    EAGLE(Group.ANIMAL, R.drawable.emoji_u1f985, R.color.transparent, R.string.item_eagle, R.string.quote_eagle),

    // ANIMAL - Chordata - Aves	- Strigiformes
    OWL(Group.ANIMAL, R.drawable.emoji_u1f989, R.color.transparent, R.string.item_owl, R.string.quote_owl),

    // ANIMAL - Chordata - Aves	- Piciformes
    WOODPECKER(Group.ANIMAL, R.drawable.woodpecker, R.color.transparent, R.string.item_woodpecker, R.string.quote_woodpecker),

    // ANIMAL - Chordata - Aves	- Falconiformes
    FALCON(Group.ANIMAL, R.drawable.falcon, R.color.transparent, R.string.item_falcon, R.string.quote_falcon),

    // ANIMAL - Chordata - Aves	- Psittaciformes
    PARROT(Group.ANIMAL, R.drawable.emoji_u1f99c, R.color.transparent, R.string.item_parrot, R.string.quote_parrot),

    // ANIMAL - Chordata - Aves	- Passeriformes
    SPARROW(Group.ANIMAL, R.drawable.sparrow, R.color.transparent, R.string.item_sparrow, R.string.quote_sparrow),
    NIGHTINGALE(Group.ANIMAL, R.drawable.nightingale, R.color.transparent, R.string.item_nightingale, R.string.quote_nightingale),
    SWALLOW(Group.ANIMAL, R.drawable.swallow, R.color.transparent, R.string.item_swallow, R.string.quote_swallow),
    CROW(Group.ANIMAL, R.drawable.crow, R.color.transparent, R.string.item_crow, R.string.quote_crow),

    // ANIMAL - Chordata - Mammalia
    MAMMAL(Group.ANIMAL, R.drawable.desman, R.color.transparent, R.string.item_mammal, R.string.quote_mammal),

    // ANIMAL - Chordata - Mammalia - Monotremata
    PLATYPUS(Group.ANIMAL, R.drawable.platypus, R.color.transparent, R.string.item_platypus, R.string.quote_platypus),
    @Suppress("NO-IMAGE") ECHIDNA(Group.ANIMAL, R.drawable.emoji_u1f994, R.color.gray_translucent, R.string.item_echidna, R.string.quote_echidna),

    // ANIMAL - Chordata - Mammalia - Didelphimorphia
    @Suppress("NO-IMAGE") OPOSSUM(Group.ANIMAL, R.drawable.mole, R.color.gray_translucent, R.string.item_opossum, R.string.quote_opossum),

    // ANIMAL - Chordata - Mammalia - Diprotodontia
    KANGAROO(Group.ANIMAL, R.drawable.emoji_u1f998, R.color.transparent, R.string.item_kangaroo, R.string.quote_kangaroo),
    KOALA(Group.ANIMAL, R.drawable.koala, R.color.transparent, R.string.item_koala, R.string.quote_koala),
    @Suppress("NO-IMAGE") FLYING_PHALANGER(Group.ANIMAL, R.drawable.mole, R.color.gray_translucent, R.string.item_flying_phalanger, R.string.quote_flying_phalanger),

    // ANIMAL - Chordata - Mammalia - Notoryctemorphia
    @Suppress("NO-IMAGE") MARSUPIAL_MOLE(Group.ANIMAL, R.drawable.mole, R.color.gray_translucent, R.string.item_marsupial_mole, R.string.quote_marsupial_mole),

    // ANIMAL - Chordata - Mammalia - Dasyuromorphia
    @Suppress("NO-IMAGE") QUOLL(Group.ANIMAL, R.drawable.mole, R.color.gray_translucent, R.string.item_quoll, R.string.quote_quoll),

    // ANIMAL - Chordata - Mammalia - Tubulidentata
    @Suppress("NO-IMAGE") AARDVARK(Group.ANIMAL, R.drawable.anteater, R.color.gray_translucent, R.string.item_aardvark, R.string.quote_aardvark),

    // ANIMAL - Chordata - Mammalia - Proboscidea
    ELEPHANT(Group.ANIMAL, R.drawable.emoji_u1f418, R.color.transparent, R.string.item_elephant, R.string.quote_elephant),

    // ANIMAL - Chordata - Mammalia - Sirenia
    DUGONG(Group.ANIMAL, R.drawable.dugong, R.color.transparent, R.string.item_dugong, R.string.quote_dugong),

    // ANIMAL - Chordata - Mammalia - Cingulata
    ARMADILLO(Group.ANIMAL, R.drawable.armadillo, R.color.transparent, R.string.item_armadillo, R.string.quote_armadillo),

    // ANIMAL - Chordata - Mammalia - Pilosa
    ANTEATER(Group.ANIMAL, R.drawable.anteater, R.color.transparent, R.string.item_anteater, R.string.quote_anteater),
    SLOTH(Group.ANIMAL, R.drawable.emoji_u1f9a5, R.color.transparent, R.string.item_sloth, R.string.quote_sloth),

    // ANIMAL - Chordata - Mammalia - Eulipotyphla
    MOLE(Group.ANIMAL, R.drawable.mole, R.color.transparent, R.string.item_mole, R.string.quote_mole),
    HEDGEHOG(Group.ANIMAL, R.drawable.emoji_u1f994, R.color.transparent, R.string.item_hedgehog, R.string.quote_hedgehog),

    // ANIMAL - Chordata - Mammalia - Chiroptera
    BAT(Group.ANIMAL, R.drawable.emoji_u1f987, R.color.transparent, R.string.item_bat, R.string.quote_bat),

    // ANIMAL - Chordata - Mammalia - Artiodactyla
    CAMEL(Group.ANIMAL, R.drawable.emoji_u1f42a, R.color.transparent, R.string.item_camel, R.string.quote_camel),
    LLAMA(Group.ANIMAL, R.drawable.emoji_u1f999, R.color.transparent, R.string.item_llama, R.string.quote_llama),
    BOAR(Group.ANIMAL, R.drawable.wild_boar, R.color.transparent, R.string.item_boar, R.string.quote_boar),
    PIG(Group.ANIMAL, R.drawable.emoji_u1f416, R.color.transparent, R.string.item_pig, R.string.quote_pig),
    GIRAFFE(Group.ANIMAL, R.drawable.emoji_u1f992, R.color.transparent, R.string.item_giraffe, R.string.quote_giraffe),
    DEER(Group.ANIMAL, R.drawable.emoji_u1f98c, R.color.transparent, R.string.item_deer, R.string.quote_deer),
    BUFFALO(Group.ANIMAL, R.drawable.emoji_u1f403, R.color.transparent, R.string.item_buffalo, R.string.quote_buffalo),
    BISON(Group.ANIMAL, R.drawable.emoji_u1f9ac, R.color.transparent, R.string.item_bison, R.string.quote_bison),
    BULL(Group.ANIMAL, R.drawable.emoji_u1f402, R.color.transparent, R.string.item_bull, R.string.quote_bull),
    COW(Group.ANIMAL, R.drawable.emoji_u1f404, R.color.transparent, R.string.item_cow, R.string.quote_cow),
    GOAT(Group.ANIMAL, R.drawable.emoji_u1f410, R.color.transparent, R.string.item_goat, R.string.quote_goat),
    SHEEP(Group.ANIMAL, R.drawable.emoji_u1f411, R.color.transparent, R.string.item_sheep, R.string.quote_sheep),
    HIPPOPOTAMUS(Group.ANIMAL, R.drawable.emoji_u1f99b, R.color.transparent, R.string.item_hippopotamus, R.string.quote_hippopotamus),
    WHALE(Group.ANIMAL, R.drawable.emoji_u1f40b, R.color.transparent, R.string.item_whale, R.string.quote_whale),
    DOLPHIN(Group.ANIMAL, R.drawable.emoji_u1f42c, R.color.transparent, R.string.item_dolphin, R.string.quote_dolphin),

    // ANIMAL - Chordata - Mammalia - Perissodactyla
    HORSE(Group.ANIMAL, R.drawable.emoji_u1f40e, R.color.transparent, R.string.item_horse, R.string.quote_horse),
    DONKEY(Group.ANIMAL, R.drawable.donkey, R.color.transparent, R.string.item_donkey, R.string.quote_donkey),
    ZEBRA(Group.ANIMAL, R.drawable.zebra, R.color.transparent, R.string.item_zebra, R.string.quote_zebra),
    TAPIR(Group.ANIMAL, R.drawable.tapir, R.color.transparent, R.string.item_tapir, R.string.quote_tapir),
    RHINOCEROS(Group.ANIMAL, R.drawable.emoji_u1f98f, R.color.transparent, R.string.item_rhinoceros, R.string.quote_rhinoceros),

    // ANIMAL - Chordata - Mammalia - Pholidota
    PANGOLIN(Group.ANIMAL, R.drawable.pangolin, R.color.transparent, R.string.item_pangolin, R.string.quote_pangolin),

    // ANIMAL - Chordata - Mammalia - Carnivora
    HYENA(Group.ANIMAL, R.drawable.hyena, R.color.transparent, R.string.item_hyena, R.string.quote_hyena),
    TIGER(Group.ANIMAL, R.drawable.emoji_u1f405, R.color.transparent, R.string.item_tiger, R.string.quote_tiger),
    LEOPARD(Group.ANIMAL, R.drawable.emoji_u1f406, R.color.transparent, R.string.item_leopard, R.string.quote_leopard),
    LION(Group.ANIMAL, R.drawable.lion, R.color.transparent, R.string.item_lion, R.string.quote_lion),
    CHEETAH(Group.ANIMAL, R.drawable.cheetah, R.color.transparent, R.string.item_cheetah, R.string.quote_cheetah),
    CAT(Group.ANIMAL, R.drawable.emoji_u1f408, R.color.transparent, R.string.item_cat, R.string.quote_cat),
    FOX(Group.ANIMAL, R.drawable.fox, R.color.transparent, R.string.item_fox, R.string.quote_fox),
    RACCOON_DOG(Group.ANIMAL, R.drawable.badger, R.color.transparent, R.string.item_raccoon_dog, R.string.quote_raccoon_dog),
    WOLF(Group.ANIMAL, R.drawable.wolf, R.color.transparent, R.string.item_wolf, R.string.quote_wolf),
    DOG(Group.ANIMAL, R.drawable.emoji_u1f415, R.color.transparent, R.string.item_dog, R.string.quote_dog),
    BADGER(Group.ANIMAL, R.drawable.emoji_u1f9a1, R.color.transparent, R.string.item_badger, R.string.quote_badger),
    PANDA(Group.ANIMAL, R.drawable.panda, R.color.transparent, R.string.item_panda, R.string.quote_panda),
    POLAR_BEAR(Group.ANIMAL, R.drawable.polar_bear, R.color.transparent, R.string.item_polar_bear, R.string.quote_polar_bear),
    BROWN_BEAR(Group.ANIMAL, R.drawable.bear, R.color.transparent, R.string.item_brown_bear, R.string.quote_brown_bear),
    SKUNK(Group.ANIMAL, R.drawable.emoji_u1f9a8, R.color.transparent, R.string.item_skunk, R.string.quote_skunk),
    OTTER(Group.ANIMAL, R.drawable.otter, R.color.transparent, R.string.item_otter, R.string.quote_otter),
    SEA_OTTER(Group.ANIMAL, R.drawable.emoji_u1f9a6, R.color.transparent, R.string.item_sea_otter, R.string.quote_sea_otter),
    SEAL(Group.ANIMAL, R.drawable.emoji_u1f9ad, R.color.transparent, R.string.item_seal, R.string.quote_seal),
    SEA_LION(Group.ANIMAL, R.drawable.sea_lion, R.color.transparent, R.string.item_sea_lion, R.string.quote_sea_lion),

    // ANIMAL - Chordata - Mammalia - Scandentia
    TREE_SHREW(Group.ANIMAL, R.drawable.shrew, R.color.transparent, R.string.item_tree_shrew, R.string.quote_tree_shrew),

    // ANIMAL - Chordata - Mammalia - Rodentia
    PORCUPINE(Group.ANIMAL, R.drawable.porcupine, R.color.transparent, R.string.item_porcupine, R.string.quote_porcupine),
    GUINEA_PIG(Group.ANIMAL, R.drawable.guinea_pig, R.color.transparent, R.string.item_guinea_pig, R.string.quote_guinea_pig),
    SQUIRREL(Group.ANIMAL, R.drawable.emoji_u1f43f, R.color.transparent, R.string.item_squirrel, R.string.quote_squirrel),
    @Suppress("NO-IMAGE") FLYING_SQUIRREL(Group.ANIMAL, R.drawable.emoji_u1f43f, R.color.gray_translucent, R.string.item_flying_squirrel, R.string.quote_flying_squirrel),
    BEAVER(Group.ANIMAL, R.drawable.emoji_u1f9ab, R.color.transparent, R.string.item_beaver, R.string.quote_beaver),
    RAT(Group.ANIMAL, R.drawable.emoji_u1f401, R.color.transparent, R.string.item_rat, R.string.quote_rat),
    HAMSTER(Group.ANIMAL, R.drawable.hamster, R.color.transparent, R.string.item_hamster, R.string.quote_hamster),

    // ANIMAL - Chordata - Mammalia - Rodentia
    JERBOA(Group.ANIMAL, R.drawable.jerboa, R.color.transparent, R.string.item_jerboa, R.string.quote_jerboa),

    // ANIMAL - Chordata - Mammalia - Lagomorpha
    HARE(Group.ANIMAL, R.drawable.emoji_u1f407, R.color.transparent, R.string.item_hare, R.string.quote_hare),
    RABBIT(Group.ANIMAL, R.drawable.rabbit, R.color.transparent, R.string.item_rabbit, R.string.quote_rabbit),

    // ANIMAL - Chordata - Mammalia - Dermoptera
    @Suppress("NO-IMAGE") FLYING_LEMUR(Group.ANIMAL, R.drawable.lemur, R.color.gray_translucent, R.string.item_flying_lemur, R.string.quote_flying_lemur),

    // ANIMAL - Chordata - Mammalia - Primates
    LEMUR(Group.ANIMAL, R.drawable.lemur, R.color.transparent, R.string.item_lemur, R.string.quote_lemur),
    MONKEY(Group.ANIMAL, R.drawable.emoji_u1f412, R.color.transparent, R.string.item_monkey, R.string.quote_monkey),
    ORANGUTAN(Group.ANIMAL, R.drawable.emoji_u1f9a7, R.color.transparent, R.string.item_orangutan, R.string.quote_orangutan),
    GORILLA(Group.ANIMAL, R.drawable.emoji_u1f98d, R.color.transparent, R.string.item_gorilla, R.string.quote_gorilla),
    CHIMPANZEE(Group.ANIMAL, R.drawable.chimpanzee, R.color.transparent, R.string.item_chimpanzee, R.string.quote_chimpanzee),
    HUMAN(Group.ANIMAL, R.drawable.emoji_u1f9cd, R.color.transparent, R.string.item_human, R.string.quote_human),
    ;
}