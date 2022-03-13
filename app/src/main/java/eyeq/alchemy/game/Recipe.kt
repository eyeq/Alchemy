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
            Recipe(Item.COLOR, Item.LIFE, Item.LIGHT),
            Recipe(Item.MIND, Item.LIFE, Item.TIME),
            Recipe(Item.HEART, Item.MIND, Item.ELECTRICITY),
            Recipe(Item.SICKNESS, Item.LIFE, Item.ECLIPSE),
            Recipe(Item.INJURY, Item.SICKNESS, Item.EARTH),
            Recipe(Item.SENESCENCE, Item.SICKNESS, Item.WATER),
            Recipe(Item.DISEASE, Item.SICKNESS, Item.AIR),
            Recipe(Item.POISON, Item.SICKNESS, Item.FIRE),
            Recipe(Item.DNA, Item.LIFE, Item.LIFE),
            Recipe(Item.CELL, Item.DNA),

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