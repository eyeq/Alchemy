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
            Recipe(Item.WATER, Item.STEAM, Item.COLD),
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
            Recipe(Item.MAGMA, Item.EARTH, Item.HOT),
            Recipe(Item.MAGMA, Item.STONE, Item.HOT),
            Recipe(Item.MUD, Item.EARTH, Item.WET),
            Recipe(Item.SAND, Item.EARTH, Item.DRY),

            Recipe(Item.STEAM, Item.WATER, Item.HOT),
            Recipe(Item.ICE, Item.WATER, Item.COLD),
            Recipe(Item.QUARTZ, Item.WATER, Item.DRY),

            Recipe(Item.WIND, Item.AIR, Item.AIR),
            Recipe(Item.SOUND, Item.AIR, Item.VIBRATION),

            Recipe(Item.ELECTRICITY, Item.METAL, Item.THUNDER),
            Recipe(Item.MAGNET, Item.METAL, Item.ELECTRICITY),

            Recipe(Item.LEAF, Item.PLANT),
            Recipe(Item.ASH, Item.PLANT, Item.FIRE),
            Recipe(Item.LYE, Item.ASH, Item.WATER),

            Recipe(Item.GRAVITY, Item.SPACE),
            Recipe(Item.DIRECTION, Item.SPACE, Item.EARTH),
            Recipe(Item.SKY, Item.SPACE, Item.EARTH),
            Recipe(Item.STAR, Item.SPACE, Item.STONE),
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