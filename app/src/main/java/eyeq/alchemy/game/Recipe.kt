package eyeq.alchemy.game

class Recipe(val result: Item, vararg _inputs: Item) {
    val inputs = _inputs.toList()

    companion object {
        private val recipes = mutableListOf<Recipe>(
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
            Recipe(Item.ICE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_ICE),
            Recipe(Item.PLANT, Item.ELEMENTAL_VOID, Item.ELEMENTAL_PLANT),
            Recipe(Item.THUNDER, Item.ELEMENTAL_VOID, Item.ELEMENTAL_THUNDER),
            Recipe(Item.SPACE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_DARK),
            Recipe(Item.TIME, Item.ELEMENTAL_VOID, Item.ELEMENTAL_LIGHT),

            Recipe(Item.HOT, Item.AIR, Item.FIRE),
            Recipe(Item.WET, Item.AIR, Item.WATER),
            Recipe(Item.COLD, Item.EARTH, Item.WATER),
            Recipe(Item.DRY, Item.EARTH, Item.FIRE),

            Recipe(Item.VIBRATION, Item.HOT),

            Recipe(Item.STONE, Item.EARTH, Item.EARTH),
            Recipe(Item.STONE, Item.MAGMA, Item.COLD),
            Recipe(Item.MAGMA, Item.EARTH, Item.HOT),
            Recipe(Item.MAGMA, Item.STONE, Item.HOT),
            Recipe(Item.MUD, Item.EARTH, Item.WET),
            Recipe(Item.SAND, Item.EARTH, Item.DRY),
            Recipe(Item.GRAVEL, Item.STONE, Item.RIVER),

            Recipe(Item.ICE, Item.WATER, Item.COLD),
            Recipe(Item.STEAM, Item.WATER, Item.HOT),
            Recipe(Item.QUARTZ, Item.WATER, Item.DRY),
            Recipe(Item.BUBBLE, Item.WATER, Item.WIND),
            Recipe(Item.WAVE, Item.SEA, Item.MOON),
            Recipe(Item.LIFE, Item.SEA, Item.MOON),

            Recipe(Item.WIND, Item.AIR, Item.AIR),
            Recipe(Item.SMOKE, Item.ASH, Item.AIR),
            Recipe(Item.SOUND, Item.AIR, Item.VIBRATION),

            Recipe(Item.ELECTRICITY, Item.METAL, Item.THUNDER),
            Recipe(Item.MAGNET, Item.METAL, Item.ELECTRICITY),

            Recipe(Item.LEAF, Item.PLANT),
            Recipe(Item.ASH, Item.PLANT, Item.FIRE),
            Recipe(Item.LYE, Item.ASH, Item.WATER),
            Recipe(Item.COAL, Item.PLANT, Item.GRAVITY),
            Recipe(Item.DIAMOND, Item.COAL, Item.GRAVITY),
            Recipe(Item.STEM, Item.PLANT, Item.AIR),
            Recipe(Item.ROOT, Item.PLANT, Item.EARTH),
            Recipe(Item.FLOWER, Item.PLANT, Item.LIFE),
            Recipe(Item.SEED, Item.FLOWER),
            Recipe(Item.TREE, Item.STEM, Item.LIFE),
            Recipe(Item.LIGHTNING_STRIKE, Item.TREE, Item.THUNDER),

            Recipe(Item.GRAVITY, Item.SPACE),
            Recipe(Item.DIRECTION, Item.SPACE, Item.EARTH),
            Recipe(Item.SKY, Item.SPACE, Item.EARTH),
            Recipe(Item.STAR, Item.SPACE, Item.STONE),
            Recipe(Item.METEORITE, Item.STAR, Item.STAR),
            Recipe(Item.METEOR, Item.METEORITE, Item.FIRE),
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

            Recipe(Item.ANIMAL, Item.FOREST, Item.THUNDER),
            Recipe(Item.EGG, Item.ANIMAL, Item.LIFE),

            Recipe(Item.CLOUD, Item.STEAM, Item.COLD),
            Recipe(Item.RAIN, Item.CLOUD, Item.CLOUD),
            Recipe(Item.RAINBOW, Item.RAIN, Item.SUN),
            Recipe(Item.SNOW, Item.RAIN, Item.COLD),

            Recipe(Item.VOLCANO, Item.MAGMA, Item.MAGMA),
            Recipe(Item.MOUNTAIN, Item.STONE, Item.GRAVITY),
            Recipe(Item.DESERT, Item.SAND, Item.SAND),
            Recipe(Item.CAVE, Item.RAIN, Item.STONE),
            Recipe(Item.RIVER, Item.RAIN, Item.MOUNTAIN),
            Recipe(Item.GLACIER, Item.SNOW, Item.SNOW),
            Recipe(Item.ICEBERG, Item.GLACIER, Item.SEA),
            Recipe(Item.PLAIN, Item.RIVER),
            Recipe(Item.VALLEY, Item.RIVER, Item.MOUNTAIN),
            Recipe(Item.LAKE, Item.RIVER, Item.VOLCANO),
            Recipe(Item.LAKE, Item.RIVER, Item.RAIN),
            Recipe(Item.SEA, Item.LAKE, Item.LAKE),
            Recipe(Item.SWAMP, Item.LAKE, Item.MUD),
            Recipe(Item.ISLAND, Item.SEA, Item.VOLCANO),
            Recipe(Item.COAST, Item.SEA, Item.ISLAND),
            Recipe(Item.FOREST, Item.TREE, Item.TREE),
            Recipe(Item.JUNGLE, Item.FOREST, Item.RAIN),
            Recipe(Item.AURORA, Item.MAGNET, Item.ELECTRICITY),

            Recipe(Item.WHIRLPOOL, Item.SEA, Item.WAVE),
            Recipe(Item.FOG, Item.AIR, Item.WET),
            Recipe(Item.FROST, Item.AIR, Item.COLD),
            Recipe(Item.MIRAGE, Item.AIR, Item.HOT),
            Recipe(Item.WHIRLWIND, Item.WIND, Item.HOT),
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