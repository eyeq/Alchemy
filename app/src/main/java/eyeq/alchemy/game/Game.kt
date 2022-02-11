package eyeq.alchemy.game

import android.content.SharedPreferences

class Game {
    private val unlocked = mutableListOf<Recipe>()
    var item1 = Item.EMPTY
    var item2 = Item.EMPTY

    fun save(preferences: SharedPreferences) {
        val items = Item.values().filter { isUnlocked(it) }.joinToString(",") { it.name }

        val editor = preferences.edit()
        editor.putString("items", items)
        editor.apply()
    }

    fun load(preferences: SharedPreferences): List<Item> {
        val items = preferences.getString("items", "")!!
        val previousItems = mutableListOf<Item>()
        for (s in items.split(',')) {
            previousItems.addAll(Item.values().filter { it.name == s })
        }
        return previousItems
    }

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