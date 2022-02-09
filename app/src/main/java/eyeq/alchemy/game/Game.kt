package eyeq.alchemy.game

class Game {
    private val unlocked = mutableListOf<Recipe>()
    var item1 = Item.EMPTY
    var item2 = Item.EMPTY

    fun isUnlocked(group: Group): Boolean {
        return unlocked.any { it.result.group == group }
    }

    fun isUnlocked(item: Item): Boolean {
        return unlocked.any { it.result == item }
    }

    fun isUnlocked(recipe: Recipe): Boolean {
        return unlocked.contains(recipe)
    }

    fun unlock(recipe: Recipe): Boolean {
        if (isUnlocked(recipe)) {
            return false
        }

        unlocked.add(recipe)
        return true
    }
}