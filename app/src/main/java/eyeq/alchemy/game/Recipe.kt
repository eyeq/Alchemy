package eyeq.alchemy.game

class Recipe(val result: Item, vararg _inputs: Item) {
    val inputs = _inputs.toList()

    companion object {
        val recipes = listOf<Recipe>(
            // from Elemental
            Recipe(Item.ELEMENTAL_VOID),

            Recipe(Item.ELEMENTAL_EARTH, Item.ELEMENTAL_VOID, Item.ELEMENTAL_VOID),
            Recipe(Item.ELEMENTAL_WATER, Item.ELEMENTAL_VOID, Item.ELEMENTAL_VOID),
            Recipe(Item.ELEMENTAL_AIR, Item.ELEMENTAL_VOID, Item.ELEMENTAL_VOID),
            Recipe(Item.ELEMENTAL_FIRE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_VOID),

            Recipe(Item.ELEMENTAL_METAL, Item.ELEMENTAL_EARTH, Item.ELEMENTAL_FIRE),
            Recipe(Item.ELEMENTAL_ICE, Item.ELEMENTAL_AIR, Item.ELEMENTAL_WATER),
            Recipe(Item.ELEMENTAL_PLANT, Item.ELEMENTAL_EARTH, Item.ELEMENTAL_WATER),
            Recipe(Item.ELEMENTAL_THUNDER, Item.ELEMENTAL_AIR, Item.ELEMENTAL_FIRE),
            Recipe(Item.ELEMENTAL_DARK, Item.ELEMENTAL_EARTH, Item.ELEMENTAL_AIR),
            Recipe(Item.ELEMENTAL_LIGHT, Item.ELEMENTAL_WATER, Item.ELEMENTAL_FIRE),

            Recipe(Item.EARTH, Item.ELEMENTAL_VOID, Item.ELEMENTAL_EARTH),
            Recipe(Item.EARTH, Item.COLD, Item.DRY),
            Recipe(Item.WATER, Item.ELEMENTAL_VOID, Item.ELEMENTAL_WATER),
            Recipe(Item.WATER, Item.COLD, Item.WET),
            Recipe(Item.WATER, Item.ICE, Item.HOT),
            Recipe(Item.AIR, Item.ELEMENTAL_VOID, Item.ELEMENTAL_AIR),
            Recipe(Item.AIR, Item.HOT, Item.WET),
            Recipe(Item.FIRE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_FIRE),
            Recipe(Item.FIRE, Item.HOT, Item.DRY),
            Recipe(Item.METAL, Item.ELEMENTAL_VOID, Item.ELEMENTAL_METAL),
            Recipe(Item.METAL, Item.STONE, Item.AXE),
            Recipe(Item.ICE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_ICE),
            Recipe(Item.ICE, Item.WATER, Item.COLD),
            Recipe(Item.PLANT, Item.ELEMENTAL_VOID, Item.ELEMENTAL_PLANT),
            Recipe(Item.THUNDER, Item.ELEMENTAL_VOID, Item.ELEMENTAL_THUNDER),
            Recipe(Item.SPACE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_DARK),
            Recipe(Item.TIME, Item.ELEMENTAL_VOID, Item.ELEMENTAL_LIGHT),

            Recipe(Item.HOT, Item.AIR, Item.FIRE),
            Recipe(Item.WET, Item.AIR, Item.WATER),
            Recipe(Item.COLD, Item.EARTH, Item.WATER),
            Recipe(Item.DRY, Item.EARTH, Item.FIRE),

            Recipe(Item.VIBRATION, Item.HOT),

            // from Earth
            Recipe(Item.STONE, Item.EARTH, Item.EARTH),
            Recipe(Item.STONE, Item.MAGMA, Item.COLD),
            Recipe(Item.MAGMA, Item.EARTH, Item.HOT),
            Recipe(Item.MAGMA, Item.STONE, Item.HOT),
            Recipe(Item.VOLCANO, Item.MAGMA, Item.MAGMA),
            Recipe(Item.MUD, Item.EARTH, Item.WET),
            Recipe(Item.SAND, Item.EARTH, Item.DRY),
            Recipe(Item.DESERT, Item.SAND, Item.SAND),
            Recipe(Item.GLASS, Item.QUARTZ, Item.HOT),
            Recipe(Item.GLASS, Item.SAND, Item.ASH, Item.HOT),
            Recipe(Item.TRAPPING, Item.EARTH, Item.AXE),

            // from Earth - Stone
            Recipe(Item.ANIMAL, Item.STONE, Item.THUNDER),
            Recipe(Item.GRAVEL, Item.STONE, Item.RIVER),
            Recipe(Item.MOUNTAIN, Item.STONE, Item.GRAVITY),
            Recipe(Item.HAND_AXE, Item.STONE, Item.STONE),
            Recipe(Item.SWORD, Item.HAND_AXE, Item.STICK),
            Recipe(Item.KNIFE, Item.STONE, Item.SAND),
            Recipe(Item.AXE, Item.KNIFE, Item.STICK),

            // from Earth - Mud
            Recipe(Item.EARTHENWARE, Item.MUD, Item.HOT),
            Recipe(Item.CLAY, Item.MUD, Item.GRAVITY),
            Recipe(Item.POTTERY, Item.CLAY, Item.HOT),
            Recipe(Item.BRICK, Item.MUD, Item.DRY),
            Recipe(Item.WALL, Item.BRICK, Item.BRICK),
            Recipe(Item.WALL, Item.WOOD, Item.EARTH),

            // from Water
            Recipe(Item.STEAM, Item.WATER, Item.HOT),
            Recipe(Item.QUARTZ, Item.WATER, Item.DRY),
            Recipe(Item.BUBBLE, Item.WATER, Item.WIND),

            // from Water - Steam
            Recipe(Item.CLOUD, Item.STEAM, Item.COLD),
            Recipe(Item.RAIN, Item.CLOUD, Item.CLOUD),
            Recipe(Item.SNOW, Item.RAIN, Item.COLD),
            Recipe(Item.RAINBOW, Item.RAIN, Item.SUN),
            Recipe(Item.RAINBOW, Item.WATERFALL, Item.SUN),
            Recipe(Item.CAVE, Item.RAIN, Item.STONE),
            Recipe(Item.RIVER, Item.RAIN, Item.MOUNTAIN),
            Recipe(Item.GLACIER, Item.SNOW, Item.SNOW),
            Recipe(Item.ICEBERG, Item.GLACIER, Item.SEA),
            Recipe(Item.PLAIN, Item.RIVER),
            Recipe(Item.WATERFALL, Item.RIVER, Item.GRAVITY),
            Recipe(Item.VALLEY, Item.RIVER, Item.MOUNTAIN),
            Recipe(Item.LAKE, Item.RIVER, Item.VOLCANO),
            Recipe(Item.LAKE, Item.RIVER, Item.RAIN),
            Recipe(Item.SWAMP, Item.LAKE, Item.MUD),
            Recipe(Item.SEA, Item.LAKE, Item.LAKE),
            Recipe(Item.SALT, Item.SEA, Item.HOT),
            Recipe(Item.ISLAND, Item.SEA, Item.VOLCANO),
            Recipe(Item.COAST, Item.SEA, Item.ISLAND),
            Recipe(Item.WHIRLPOOL, Item.SEA, Item.WAVE),
            Recipe(Item.WAVE, Item.SEA, Item.MOON),
            Recipe(Item.LIFE, Item.SEA, Item.MOON),

            // from Water - Steam - Life
            Recipe(Item.COLOR, Item.LIFE, Item.LIGHT),
            Recipe(Item.MIND, Item.LIFE, Item.TIME),
            Recipe(Item.HEART, Item.MIND, Item.ELECTRICITY),
            Recipe(Item.SICKNESS, Item.LIFE, Item.ECLIPSE),
            Recipe(Item.INJURY, Item.SICKNESS, Item.EARTH),
            Recipe(Item.SENESCENCE, Item.SICKNESS, Item.WATER),
            Recipe(Item.DISEASE, Item.SICKNESS, Item.AIR),
            Recipe(Item.POISON, Item.SICKNESS, Item.FIRE),
            Recipe(Item.MEDICINE, Item.DISEASE, Item.POISON),
            Recipe(Item.VACCINE, Item.VIRUS, Item.MEDICINE),
            Recipe(Item.VACCINE, Item.BACTERIA, Item.MEDICINE),
            Recipe(Item.DNA, Item.LIFE, Item.LIFE),

            // from Air
            Recipe(Item.WIND, Item.AIR, Item.AIR),
            Recipe(Item.FOG, Item.AIR, Item.WET),
            Recipe(Item.FROST, Item.AIR, Item.COLD),
            Recipe(Item.MIRAGE, Item.AIR, Item.HOT),
            Recipe(Item.SOUND, Item.AIR, Item.VIBRATION),
            Recipe(Item.WHIRLWIND, Item.WIND, Item.HOT),

            // from Metal
            Recipe(Item.ELECTRICITY, Item.METAL, Item.THUNDER),
            Recipe(Item.PHOTON, Item.ELECTRICITY),
            Recipe(Item.LIGHT, Item.PHOTON),
            Recipe(Item.GRAVITON, Item.GRAVITY),
            Recipe(Item.PIGMENT, Item.METAL, Item.STONE),
            Recipe(Item.PIGMENT, Item.METAL, Item.HAND_AXE),
            Recipe(Item.PAINTING, Item.PIGMENT, Item.HAND),
            Recipe(Item.PAINTING, Item.PIGMENT, Item.STICK),
            Recipe(Item.MAGNET, Item.METAL, Item.ELECTRICITY),
            Recipe(Item.AURORA, Item.MAGNET, Item.ELECTRICITY),
            Recipe(Item.COMPASS, Item.MAGNET, Item.DIRECTION),

            // from Plant
            Recipe(Item.LEAF, Item.PLANT),
            Recipe(Item.DYE, Item.PLANT, Item.WATER),
            Recipe(Item.ASH, Item.PLANT, Item.FIRE),
            Recipe(Item.SMOKE, Item.ASH, Item.AIR),
            Recipe(Item.LYE, Item.ASH, Item.WATER),
            Recipe(Item.COAL, Item.PLANT, Item.GRAVITY),
            Recipe(Item.COAL, Item.WOOD, Item.FIRE),
            Recipe(Item.DIAMOND, Item.COAL, Item.GRAVITY),
            Recipe(Item.STEM, Item.PLANT, Item.AIR),
            Recipe(Item.ROOT, Item.PLANT, Item.EARTH),
            Recipe(Item.FLOWER, Item.PLANT, Item.LIFE),
            Recipe(Item.SEED, Item.FLOWER),
            Recipe(Item.PERFUME, Item.FLOWER, Item.OIL),
            Recipe(Item.TREE, Item.STEM, Item.LIFE),

            // from Plant - Tree
            Recipe(Item.STICK, Item.TREE),
            Recipe(Item.STRING, Item.STICK, Item.PLANT),
            Recipe(Item.STUMP, Item.TREE, Item.AXE),
            Recipe(Item.WOOD, Item.TREE, Item.AXE),
            Recipe(Item.FIREWOOD, Item.WOOD, Item.AXE),
            Recipe(Item.BONFIRE, Item.FIREWOOD, Item.FIRE),
            Recipe(Item.TOTEM, Item.WOOD, Item.KNIFE),
            Recipe(Item.FOREST, Item.TREE, Item.TREE),
            Recipe(Item.JUNGLE, Item.FOREST, Item.RAIN),
            Recipe(Item.LIGHTNING_STRIKE, Item.TREE, Item.THUNDER),

            // from Plant - Tree - Animal
            Recipe(Item.EGG, Item.ANIMAL, Item.LIFE),
            Recipe(Item.HEAD, Item.ANIMAL, Item.MIND),
            Recipe(Item.FOOT, Item.ANIMAL, Item.EARTH),
            Recipe(Item.HAND, Item.FOOT, Item.TREE),
            Recipe(Item.FLIPPER, Item.ANIMAL, Item.WATER),
            Recipe(Item.WING, Item.ANIMAL, Item.AIR),
            Recipe(Item.TAIL, Item.ANIMAL, Item.FIRE),
            Recipe(Item.BLOOD, Item.ANIMAL, Item.SWORD),
            Recipe(Item.BONE, Item.ANIMAL, Item.SWORD),
            Recipe(Item.MEAT, Item.ANIMAL, Item.SWORD),
            Recipe(Item.OIL, Item.MEAT, Item.HOT),
            Recipe(Item.LAMP, Item.OIL, Item.FIRE),
            Recipe(Item.FUR, Item.ANIMAL, Item.SWORD),

            // from Plant - Tree - Animal - Bone
            Recipe(Item.HORN, Item.BONE, Item.HEAD),
            Recipe(Item.NEEDLE, Item.BONE, Item.STONE),
            Recipe(Item.NEEDLE, Item.BONE, Item.HAND_AXE),
            Recipe(Item.FISHING_ROD, Item.NEEDLE, Item.STRING),
            Recipe(Item.SPEAR, Item.NEEDLE, Item.STICK),
            Recipe(Item.BOW_AND_ARROW, Item.SPEAR, Item.STICK),

            // from Space
            Recipe(Item.GRAVITY, Item.SPACE),
            Recipe(Item.DIRECTION, Item.SPACE, Item.EARTH),
            Recipe(Item.SKY, Item.SPACE, Item.EARTH),
            Recipe(Item.STAR, Item.SPACE, Item.STONE),
            Recipe(Item.METEOR, Item.STAR, Item.STAR),
            Recipe(Item.SHOOTING_STAR, Item.METEOR, Item.FIRE),
            Recipe(Item.CONSTELLATION, Item.STAR, Item.PAINTING),

            // from Space - Gravity
            Recipe(Item.BLACK_HOLE, Item.GRAVITY, Item.GRAVITY),
            Recipe(Item.COMET, Item.COLD, Item.GRAVITY),
            Recipe(Item.SUN, Item.HOT, Item.GRAVITY),
            Recipe(Item.PLANET, Item.SUN, Item.GRAVITY),
            Recipe(Item.PLANET_MERCURY, Item.PLANET, Item.WATER),
            Recipe(Item.PLANET_VENUS, Item.PLANET, Item.METAL),
            Recipe(Item.PLANET_MARS, Item.PLANET, Item.FIRE),
            Recipe(Item.PLANET_JUPITER, Item.PLANET, Item.PLANT),
            Recipe(Item.PLANET_SATURN, Item.PLANET, Item.EARTH),
            Recipe(Item.PLANET_URANUS, Item.PLANET, Item.AIR),
            Recipe(Item.PLANET_NEPTUNE, Item.PLANET, Item.ICE),
            Recipe(Item.MOON, Item.PLANET, Item.GRAVITY),
            Recipe(Item.ECLIPSE, Item.SUN, Item.MOON),
            Recipe(Item.DAY, Item.SUN, Item.TIME),
            Recipe(Item.NIGHT, Item.MOON, Item.TIME),

            // from Water - Steam - Life - DNA
            Recipe(Item.CELL, Item.DNA),
            Recipe(Item.VIRUS, Item.DNA, Item.LIFE),

            Recipe(Item.BACTERIA, Item.CELL, Item.WET),
            Recipe(Item.ARCHAEA, Item.CELL, Item.DRY),

            // from Water - Steam - Life - DNA - Bacteria
            Recipe(Item.BLUE_GREEN_ALGAE, Item.BACTERIA, Item.SUN),
            Recipe(Item.BLACK_DEATH, Item.BACTERIA, Item.FLEA),

            // from Water - Steam - Life - DNA - Archaea
            Recipe(Item.THERMOPHILE, Item.ARCHAEA, Item.HOT),
            Recipe(Item.HALOARCHAEA, Item.ARCHAEA, Item.SALT),
            Recipe(Item.METHANOGEN, Item.ARCHAEA, Item.COAL),
            Recipe(Item.EUKARYOTE, Item.ARCHAEA, Item.WET),

            // from Water - Steam - Life - DNA - Archaea - Eukaryote
            Recipe(Item.AMOEBA, Item.EUKARYOTE, Item.EARTH),
            Recipe(Item.SPOROZOA, Item.EUKARYOTE, Item.AIR),
            Recipe(Item.FLAGELLATE, Item.EUKARYOTE, Item.WATER),
            Recipe(Item.PROTOZOA, Item.EUKARYOTE, Item.WATER),

            // from Water - Steam - Life - DNA - Archaea - Eukaryote - Protozoa
            Recipe(Item.CILIATE, Item.PROTOZOA),
            Recipe(Item.BROWN_ALGAE, Item.PROTOZOA, Item.PLANT),
            Recipe(Item.RED_ALGAE, Item.PROTOZOA, Item.PLANT),
            Recipe(Item.GREEN_ALGAE, Item.PROTOZOA, Item.PLANT),
            Recipe(Item.EMBRYOPHYTE, Item.PROTOZOA, Item.PLANT),
            Recipe(Item.SPONGE, Item.PROTOZOA, Item.ANIMAL),
            Recipe(Item.FUNGI, Item.PROTOZOA, Item.ANIMAL),

            Recipe(Item.MOSS, Item.EMBRYOPHYTE),
            Recipe(Item.LYCOPHYTE, Item.EMBRYOPHYTE, Item.STEM),
            Recipe(Item.FERN, Item.EMBRYOPHYTE, Item.ROOT),
            Recipe(Item.CYCAD, Item.EMBRYOPHYTE, Item.TREE),
            Recipe(Item.GINKGO, Item.EMBRYOPHYTE, Item.TREE),
            Recipe(Item.CONIFER, Item.EMBRYOPHYTE, Item.TREE),
            Recipe(Item.ANGIOSPERM, Item.EMBRYOPHYTE, Item.FLOWER),

            Recipe(Item.TARO, Item.ANGIOSPERM, Item.EARTH),
            Recipe(Item.KONJAC, Item.ANGIOSPERM, Item.EARTH),
            Recipe(Item.WATER_LILY, Item.ANGIOSPERM, Item.WATER),
            Recipe(Item.CAMPHOR_TREE, Item.ANGIOSPERM, Item.FIRE),
            Recipe(Item.HOUTTUYNIA, Item.ANGIOSPERM, Item.FIRE),
            Recipe(Item.SPINACH, Item.ANGIOSPERM, Item.AIR),
            Recipe(Item.SUGAR_BEET, Item.ANGIOSPERM, Item.AIR),
            Recipe(Item.PEPPER, Item.ANGIOSPERM, Item.FIRE),
            Recipe(Item.GRAPE, Item.ANGIOSPERM, Item.STICK),
            Recipe(Item.MISTLETOE, Item.ANGIOSPERM, Item.APPLE),

            Recipe(Item.YAM, Item.TARO, Item.FIRE),
            Recipe(Item.LILY, Item.TARO, Item.FLOWER),

            Recipe(Item.PINEAPPLE, Item.LILY, Item.FIRE),
            Recipe(Item.ORCHID, Item.LILY, Item.MUSHROOM),

            Recipe(Item.LEEK, Item.ORCHID, Item.POISON),
            Recipe(Item.ONION, Item.ORCHID, Item.POISON),

            Recipe(Item.BAMBOO, Item.PINEAPPLE, Item.EARTH),
            Recipe(Item.WHEAT, Item.PINEAPPLE, Item.EARTH),
            Recipe(Item.RICE_PLANT, Item.PINEAPPLE, Item.WATER),
            Recipe(Item.MAIZE, Item.PINEAPPLE, Item.WATER),
            Recipe(Item.SUGAR_CANE, Item.PINEAPPLE, Item.WATER),
            Recipe(Item.BANANA, Item.PINEAPPLE, Item.TREE),

            Recipe(Item.RAFFLESIA, Item.GRAPE, Item.GRAPE),
            Recipe(Item.RUBBER_TREE, Item.GRAPE, Item.TREE),
            Recipe(Item.ORANGE, Item.GRAPE, Item.TREE),
            Recipe(Item.SOYBEAN, Item.GRAPE, Item.BACTERIA),

            Recipe(Item.ROSE, Item.SOYBEAN, Item.NEEDLE),
            Recipe(Item.STRAWBERRY, Item.SOYBEAN, Item.NEEDLE),
            Recipe(Item.PEACH, Item.SOYBEAN, Item.TREE),
            Recipe(Item.CHERRY, Item.SOYBEAN, Item.TREE),
            Recipe(Item.PEAR, Item.SOYBEAN, Item.TREE),
            Recipe(Item.APPLE, Item.SOYBEAN, Item.TREE),

            Recipe(Item.CALABASH, Item.ROSE, Item.FIRE),
            Recipe(Item.CUCUMBER, Item.ROSE, Item.FIRE),
            Recipe(Item.PUMPKIN, Item.ROSE, Item.FIRE),
            Recipe(Item.MELON, Item.ROSE, Item.FIRE),
            Recipe(Item.BEECH, Item.ROSE, Item.TREE),
            Recipe(Item.CHESTNUT, Item.ROSE, Item.TREE),
            Recipe(Item.WALNUT, Item.ROSE, Item.TREE),

            Recipe(Item.MUSTARD, Item.ORANGE, Item.EARTH),
            Recipe(Item.CABBAGE, Item.ORANGE, Item.EARTH),
            Recipe(Item.TURNIP, Item.ORANGE, Item.EARTH),
            Recipe(Item.RADISH, Item.ORANGE, Item.EARTH),

            Recipe(Item.OLIVE, Item.SPINACH, Item.FIRE),
            Recipe(Item.SESAME, Item.SPINACH, Item.FIRE),
            Recipe(Item.CHRYSANTHEMUM, Item.SPINACH, Item.FLOWER),
            Recipe(Item.SUNFLOWER, Item.SPINACH, Item.FLOWER),
            Recipe(Item.LETTUCE, Item.SPINACH, Item.FLOWER),
            Recipe(Item.BURDOCK, Item.SPINACH, Item.FLOWER),
            Recipe(Item.EGGPLANT, Item.SPINACH, Item.POISON),
            Recipe(Item.CACTUS, Item.SPINACH, Item.NEEDLE),
            Recipe(Item.TOMATO, Item.SPINACH, Item.POISON),
            Recipe(Item.POTATO, Item.SPINACH, Item.POISON),
            Recipe(Item.BELL_PEPPER, Item.SPINACH, Item.POISON),

            Recipe(Item.CARROT, Item.CHRYSANTHEMUM, Item.WATER),

            // from Water - Steam - Life - DNA - Archaea - Animalia
            Recipe(Item.MUSHROOM, Item.FUNGI),
            Recipe(Item.MOLD, Item.FUNGI),
            Recipe(Item.YEAST, Item.FUNGI),

            Recipe(Item.SEA_GOOSEBERRY, Item.SPONGE, Item.AIR),
            Recipe(Item.SEA_ANEMONE, Item.SPONGE, Item.FLOWER),

            Recipe(Item.STARFISH, Item.SEA_ANEMONE, Item.EARTH),
            Recipe(Item.SEA_URCHIN, Item.SEA_ANEMONE, Item.EARTH),
            Recipe(Item.SEA_CUCUMBER, Item.SEA_ANEMONE, Item.EARTH),
            Recipe(Item.EARTHWORM, Item.SEA_ANEMONE, Item.WATER),
            Recipe(Item.LEECH, Item.SEA_ANEMONE, Item.WATER),
            Recipe(Item.JELLYFISH, Item.SEA_ANEMONE, Item.AIR),
            Recipe(Item.SEA_SPIDER, Item.SEA_ANEMONE, Item.FIRE),
            Recipe(Item.CENTIPEDE, Item.SEA_ANEMONE, Item.FIRE),
            Recipe(Item.CORAL, Item.SEA_ANEMONE, Item.METAL),
            Recipe(Item.SHELLFISH, Item.SEA_ANEMONE, Item.METAL),
            Recipe(Item.VERTEBRATE, Item.SEA_ANEMONE, Item.BONE),

            // Recipe(Item.HORSESHOE_CRAB, Item.SEA_SPIDER, Item.WATER),
            Recipe(Item.SCORPION, Item.SEA_SPIDER, Item.WATER),
            Recipe(Item.MITE, Item.SEA_SPIDER, Item.AIR),

            Recipe(Item.SPIDER, Item.SCORPION, Item.AIR),

            Recipe(Item.HERMIT_CRAB, Item.SHRIMP, Item.SHELLFISH),
            Recipe(Item.SHRIMP, Item.CENTIPEDE, Item.WATER),
            Recipe(Item.CRAB, Item.SHRIMP, Item.EARTH),
            Recipe(Item.CRAYFISH, Item.SHRIMP, Item.EARTH),
            Recipe(Item.PILL_BUG, Item.SHRIMP, Item.EARTH),
            Recipe(Item.DRAGONFLY, Item.SHRIMP, Item.AIR),

            Recipe(Item.GRASSHOPPER, Item.DRAGONFLY, Item.EARTH),
            Recipe(Item.MANTIS, Item.DRAGONFLY, Item.EARTH),
            Recipe(Item.COCKROACH, Item.DRAGONFLY, Item.EARTH),

            Recipe(Item.MOTH, Item.GRASSHOPPER, Item.AIR),
            Recipe(Item.BUTTERFLY, Item.GRASSHOPPER, Item.AIR),
            Recipe(Item.BEE, Item.GRASSHOPPER, Item.FIRE),
            Recipe(Item.ANT, Item.GRASSHOPPER, Item.FIRE),
            Recipe(Item.FIREFLY, Item.GRASSHOPPER, Item.METAL),
            Recipe(Item.LADYBUG, Item.GRASSHOPPER, Item.METAL),
            Recipe(Item.SCARAB_BEETLE, Item.GRASSHOPPER, Item.METAL),
            Recipe(Item.WATER_STRIDER, Item.GRASSHOPPER, Item.NEEDLE),
            Recipe(Item.CICADA, Item.GRASSHOPPER, Item.NEEDLE),
            Recipe(Item.MOSQUITO, Item.GRASSHOPPER, Item.NEEDLE),
            Recipe(Item.FLY, Item.GRASSHOPPER, Item.NEEDLE),

            Recipe(Item.STINK_BUG, Item.WATER_STRIDER, Item.POISON),

            Recipe(Item.FLEA, Item.MOSQUITO, Item.TIME),

            Recipe(Item.RHINOCEROS_BEETLE, Item.SCARAB_BEETLE, Item.HORN),
            Recipe(Item.STAG_BEETLE, Item.SCARAB_BEETLE, Item.HORN),

            Recipe(Item.SEA_SLUG, Item.SHELLFISH, Item.TIME),
            Recipe(Item.SNAIL, Item.SHELLFISH, Item.EARTH),
            Recipe(Item.NAUTILUS, Item.SHELLFISH, Item.AIR),

            Recipe(Item.SLUG, Item.SNAIL, Item.TIME),

            Recipe(Item.OCTOPUS, Item.NAUTILUS, Item.TIME),
            Recipe(Item.SQUID, Item.NAUTILUS, Item.TIME),

            Recipe(Item.SHARK, Item.VERTEBRATE, Item.OIL),
            Recipe(Item.RAY, Item.VERTEBRATE, Item.OIL),
            Recipe(Item.MORAY_EEL, Item.VERTEBRATE, Item.TIME),
            Recipe(Item.HERRING, Item.VERTEBRATE, Item.RIVER),
            Recipe(Item.SALMON, Item.VERTEBRATE, Item.RIVER),
            // Recipe(Item.SMELT, Item.VERTEBRATE, Item.LAKE),
            Recipe(Item.TETRAPOD, Item.VERTEBRATE, Item.FOOT),

            Recipe(Item.ELECTRIC_RAY, Item.RAY, Item.ELECTRICITY),

            Recipe(Item.EEL, Item.MORAY_EEL, Item.RIVER),

            // Recipe(Item.LOACH, Item.HERRING, Item.SWAMP),
            Recipe(Item.CARP, Item.HERRING, Item.SWAMP),
            // Recipe(Item.LITTLE_DRAGONFISH, Item.HERRING, Item.STONE),
            // Recipe(Item.LEAFY_SEADRAGON, Item.HERRING, Item.BROWN_ALGAE),
            Recipe(Item.SEAHORSE, Item.HERRING, Item.CORAL),
            Recipe(Item.FLATFISH, Item.HERRING, Item.SAND),
            Recipe(Item.CLOWNFISH, Item.HERRING, Item.SEA_ANEMONE),
            Recipe(Item.TUNA, Item.HERRING, Item.SEA),
            Recipe(Item.SEA_BASS, Item.HERRING, Item.SEA),

            Recipe(Item.KOI, Item.CARP, Item.HUMAN),
            Recipe(Item.GOLDFISH, Item.CARP, Item.HUMAN),
            Recipe(Item.PIRANHA, Item.CARP, Item.RIVER),

            Recipe(Item.CATFISH, Item.PIRANHA, Item.SWAMP),
            Recipe(Item.ELECTRIC_EEL, Item.PIRANHA, Item.ELECTRICITY),

            Recipe(Item.ELECTRIC_CATFISH, Item.CATFISH, Item.ELECTRICITY),

            Recipe(Item.BLACK_BASS, Item.SEA_BASS, Item.RIVER),
            Recipe(Item.SEA_BREAM, Item.SEA_BASS, Item.SHRIMP),

            Recipe(Item.SUNFISH, Item.SEA_BREAM, Item.SUN),
            Recipe(Item.ANGLERFISH, Item.SEA_BREAM, Item.FISHING_ROD),

            Recipe(Item.PORCUPINEFISH, Item.SUNFISH, Item.NEEDLE),
            Recipe(Item.PUFFERFISH, Item.SUNFISH, Item.POISON),

            Recipe(Item.FOOTBALLFISH, Item.ANGLERFISH, Item.LIGHT),

            // from Water - Steam - Life - DNA - Archaea - Animalia - Vertebrate
            Recipe(Item.FROG, Item.TETRAPOD, Item.RIVER),
            Recipe(Item.SALAMANDER, Item.TETRAPOD, Item.RIVER),
            Recipe(Item.ICHTHYOSAUR, Item.TETRAPOD, Item.SEA),
            Recipe(Item.LIZARD, Item.TETRAPOD, Item.SUN),
            Recipe(Item.MAMMAL, Item.TETRAPOD, Item.FUR),

            Recipe(Item.SNAKE, Item.LIZARD, Item.TIME),
            Recipe(Item.FLYING_LIZARD, Item.LIZARD, Item.JUNGLE),
            Recipe(Item.CHAMELEON, Item.LIZARD, Item.JUNGLE),
            Recipe(Item.PLESIOSAUR, Item.LIZARD, Item.BONE),
            Recipe(Item.CROCODILE, Item.LIZARD, Item.RIVER),
            Recipe(Item.PTEROSAUR, Item.LIZARD, Item.WING),

            Recipe(Item.TURTLE, Item.PLESIOSAUR, Item.TIME),
            Recipe(Item.SEA_TURTLE, Item.TURTLE, Item.SEA),

            Recipe(Item.SAUROPODA, Item.PTEROSAUR, Item.FOOT),
            Recipe(Item.STEGOSAUR, Item.PTEROSAUR, Item.TAIL),
            Recipe(Item.ANKYLOSAUR, Item.PTEROSAUR, Item.BONE),
            Recipe(Item.PACHYCEPHALOSAUR, Item.PTEROSAUR, Item.HEAD),
            Recipe(Item.CERATOPS, Item.PTEROSAUR, Item.HORN),
            Recipe(Item.THEROPODA, Item.PTEROSAUR, Item.FUR),

            Recipe(Item.ARCHAEOPTERYX, Item.THEROPODA, Item.TIME),
            Recipe(Item.BIRD, Item.THEROPODA, Item.TIME),

            Recipe(Item.OSTRICH, Item.BIRD, Item.DESERT),
            Recipe(Item.EMU, Item.BIRD, Item.PLAIN),
            Recipe(Item.TURKEY, Item.BIRD, Item.BLOOD),
            Recipe(Item.PEACOCK, Item.BIRD, Item.RAINBOW),
            Recipe(Item.COCK, Item.BIRD, Item.DAY),
            Recipe(Item.SWAN, Item.BIRD, Item.LAKE),
            Recipe(Item.DUCK, Item.BIRD, Item.RIVER),
            Recipe(Item.FLAMINGO, Item.BIRD, Item.BLUE_GREEN_ALGAE),
            Recipe(Item.PIGEON, Item.BIRD, Item.MOON),
            Recipe(Item.DODO, Item.BIRD, Item.TIME),
            Recipe(Item.CUCKOO, Item.BIRD, Item.BIRD),
            Recipe(Item.CRANE, Item.BIRD, Item.SWAMP),
            Recipe(Item.HUMMINGBIRD, Item.BIRD, Item.FLOWER),
            Recipe(Item.PENGUIN, Item.BIRD, Item.GLACIER),
            Recipe(Item.EAGLE, Item.BIRD, Item.CONIFER),
            Recipe(Item.OWL, Item.BIRD, Item.NIGHT),
            Recipe(Item.WOODPECKER, Item.BIRD, Item.TREE),
            Recipe(Item.FALCON, Item.BIRD, Item.SKY),
            Recipe(Item.PARROT, Item.BIRD, Item.SOUND),
            Recipe(Item.SPARROW, Item.BIRD, Item.BAMBOO),
            Recipe(Item.NIGHTINGALE, Item.BIRD, Item.CHERRY),
            Recipe(Item.SWALLOW, Item.BIRD, Item.CLOUD),
            Recipe(Item.CROW, Item.BIRD, Item.SUN),

            Recipe(Item.PLATYPUS, Item.MAMMAL, Item.RIVER),
            Recipe(Item.ECHIDNA, Item.MAMMAL, Item.NEEDLE),
            Recipe(Item.OPOSSUM, Item.MAMMAL, Item.FOREST),
            Recipe(Item.AARDVARK, Item.MAMMAL, Item.PLAIN),
            Recipe(Item.MOLE, Item.MAMMAL, Item.EARTH),
            Recipe(Item.TREE_SHREW, Item.MAMMAL, Item.JUNGLE),

            Recipe(Item.KANGAROO, Item.OPOSSUM, Item.PLAIN),
            Recipe(Item.KOALA, Item.OPOSSUM, Item.BACTERIA),
            Recipe(Item.FLYING_PHALANGER, Item.OPOSSUM, Item.WING),
            Recipe(Item.MARSUPIAL_MOLE, Item.OPOSSUM, Item.DESERT),
            Recipe(Item.QUOLL, Item.OPOSSUM, Item.JUNGLE),

            Recipe(Item.ELEPHANT, Item.AARDVARK, Item.BONE),
            Recipe(Item.ARMADILLO, Item.AARDVARK, Item.FUR),
            Recipe(Item.ANTEATER, Item.AARDVARK, Item.JUNGLE),
            Recipe(Item.SLOTH, Item.AARDVARK, Item.JUNGLE),

            Recipe(Item.DUGONG, Item.ELEPHANT, Item.SEA),

            Recipe(Item.HEDGEHOG, Item.MOLE, Item.NEEDLE),
            Recipe(Item.BAT, Item.MOLE, Item.WING),
            Recipe(Item.CAMEL, Item.MOLE, Item.DESERT),
            Recipe(Item.LLAMA, Item.MOLE, Item.MOUNTAIN),
            Recipe(Item.BOAR, Item.MOLE, Item.FOREST),
            Recipe(Item.HORSE, Item.MOLE, Item.PLAIN),
            Recipe(Item.TAPIR, Item.MOLE, Item.JUNGLE),
            Recipe(Item.RHINOCEROS, Item.MOLE, Item.HORN),
            Recipe(Item.PANGOLIN, Item.MOLE, Item.FUR),
            Recipe(Item.HYENA, Item.MOLE, Item.TREE),
            Recipe(Item.TIGER, Item.MOLE, Item.TREE),
            Recipe(Item.FOX, Item.MOLE, Item.TREE),
            Recipe(Item.BADGER, Item.MOLE, Item.TREE),

            Recipe(Item.PIG, Item.BOAR, Item.HUMAN),
            Recipe(Item.GIRAFFE, Item.BOAR, Item.BONE),
            Recipe(Item.DEER, Item.BOAR, Item.HORN),
            Recipe(Item.HIPPOPOTAMUS, Item.BOAR, Item.RIVER),
            Recipe(Item.WHALE, Item.BOAR, Item.SEA),

            Recipe(Item.BUFFALO, Item.DEER, Item.RIVER),
            Recipe(Item.BISON, Item.DEER, Item.PLAIN),
            Recipe(Item.GOAT, Item.DEER, Item.MOUNTAIN),
            Recipe(Item.SHEEP, Item.DEER, Item.FOREST),

            Recipe(Item.BULL, Item.BISON, Item.HUMAN),
            Recipe(Item.COW, Item.BISON, Item.HUMAN),

            Recipe(Item.DOLPHIN, Item.WHALE, Item.TIME),

            Recipe(Item.DONKEY, Item.HORSE, Item.MOUNTAIN),
            Recipe(Item.ZEBRA, Item.HORSE, Item.DESERT),

            Recipe(Item.LEOPARD, Item.TIGER, Item.PLAIN),
            Recipe(Item.LION, Item.TIGER, Item.PLAIN),
            Recipe(Item.CHEETAH, Item.TIGER, Item.PLAIN),
            Recipe(Item.CAT, Item.CHEETAH, Item.HUMAN),

            Recipe(Item.RACCOON_DOG, Item.FOX, Item.RIVER),
            Recipe(Item.WOLF, Item.FOX, Item.MOUNTAIN),
            Recipe(Item.DOG, Item.WOLF, Item.HUMAN),

            Recipe(Item.PANDA, Item.BADGER, Item.BAMBOO),
            Recipe(Item.POLAR_BEAR, Item.BADGER, Item.ICEBERG),
            Recipe(Item.BROWN_BEAR, Item.BADGER, Item.MOUNTAIN),
            Recipe(Item.SKUNK, Item.BADGER, Item.POISON),
            Recipe(Item.OTTER, Item.BADGER, Item.RIVER),
            Recipe(Item.SEA_OTTER, Item.BADGER, Item.SEA),
            Recipe(Item.SEAL, Item.BADGER, Item.ICEBERG),

            Recipe(Item.SEA_LION, Item.SEAL, Item.SEA),

            Recipe(Item.PORCUPINE, Item.TREE_SHREW, Item.NEEDLE),
            Recipe(Item.SQUIRREL, Item.TREE_SHREW, Item.TIME),
            Recipe(Item.BEAVER, Item.TREE_SHREW, Item.RIVER),
            Recipe(Item.RAT, Item.TREE_SHREW, Item.EARTH),
            Recipe(Item.JERBOA, Item.TREE_SHREW, Item.DESERT),
            Recipe(Item.HARE, Item.TREE_SHREW, Item.PLAIN),
            Recipe(Item.FLYING_LEMUR, Item.TREE_SHREW, Item.WING),
            Recipe(Item.LEMUR, Item.TREE_SHREW, Item.HAND),
            Recipe(Item.MONKEY, Item.TREE_SHREW, Item.HAND),

            Recipe(Item.GUINEA_PIG, Item.PORCUPINE, Item.TIME),

            Recipe(Item.FLYING_SQUIRREL, Item.SQUIRREL, Item.WING),

            Recipe(Item.HAMSTER, Item.RAT, Item.HUMAN),

            Recipe(Item.RABBIT, Item.HARE, Item.HUMAN),

            Recipe(Item.ORANGUTAN, Item.MONKEY, Item.JUNGLE),
            Recipe(Item.GORILLA, Item.MONKEY, Item.MOUNTAIN),
            Recipe(Item.CHIMPANZEE, Item.MONKEY, Item.CAVE),
            Recipe(Item.HUMAN, Item.MONKEY, Item.PLAIN),
        )

        fun getCount(): Int {
            val list = mutableListOf<Recipe>()
            for (recipe in recipes) {
                if (list.all { !isSame(it.inputs, recipe.inputs) }) {
                    list.add(recipe)
                }
            }
            return list.count()
        }

        fun canMake(item: Item): Boolean {
            return recipes.any { it.result == item }
        }

        fun getRecipeListByResult(item: Item): List<Recipe> {
            return recipes.filter { it.result == item }
        }

        fun getRecipeListByInputs(vararg inputs: Item): List<Recipe> {
            return recipes.filter { isSame(it.inputs, inputs.toList()) }
        }

        private fun isSame(list1: List<Item>, list2: List<Item>): Boolean {
            val list1Trim = list1.filter { it != Item.EMPTY }
            val list2Trim = list2.filter { it != Item.EMPTY }.toMutableList()
            for (input in list1Trim) {
                if (!list2Trim.contains(input)) {
                    return false
                }
                list2Trim.remove(input)
            }
            return list2Trim.isEmpty()
        }
    }
}