package eyeq.alchemy

class Recipe(val result: Item, vararg inputs: Item) {
    private val inputss = inputs

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
            Recipe(Item.ELEMENTAL_LIGHT, Item.ELEMENTAL_WATER, Item.ELEMENTAL_FIRE),
            Recipe(Item.ELEMENTAL_DARK, Item.ELEMENTAL_EARTH, Item.ELEMENTAL_AIR),
        )

        fun alchemise(vararg inputs: Item): List<Recipe> {
            val inputsTrim = inputs.filter { it != Item.EMPTY }
            return recipes.filter {
                val temp = inputsTrim.toMutableList()
                for (input in it.inputss) {
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