package eyeq.alchemy.game

class Recipe(val result: Item, vararg _inputs: Item) {
    private val inputs = _inputs

    companion object {
        val recipes = mutableListOf<Recipe>(
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
            Recipe(Item.WATER, Item.ELEMENTAL_VOID, Item.ELEMENTAL_WATER),
            Recipe(Item.AIR, Item.ELEMENTAL_VOID, Item.ELEMENTAL_AIR),
            Recipe(Item.FIRE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_FIRE),
            Recipe(Item.METAL, Item.ELEMENTAL_VOID, Item.ELEMENTAL_METAL),
            Recipe(Item.ICE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_ICE),
            Recipe(Item.PLANT, Item.ELEMENTAL_VOID, Item.ELEMENTAL_PLANT),
            Recipe(Item.THUNDER, Item.ELEMENTAL_VOID, Item.ELEMENTAL_THUNDER),
            Recipe(Item.SPACE, Item.ELEMENTAL_VOID, Item.ELEMENTAL_DARK),
            Recipe(Item.TIME, Item.ELEMENTAL_VOID, Item.ELEMENTAL_LIGHT),
        )

        fun alchemise(vararg inputs: Item): List<Recipe> {
            val inputsTrim = inputs.filter { it != Item.EMPTY }
            return recipes.filter {
                val temp = inputsTrim.toMutableList()
                for (input in it.inputs) {
                    if (!temp.contains(input)) {
                        return@filter false
                    }
                    temp.remove(input)
                }
                return@filter temp.isEmpty()
            }
        }
    }
}