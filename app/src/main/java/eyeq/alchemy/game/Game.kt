package eyeq.alchemy.game

import android.content.SharedPreferences

class Game {
    private val unlockedRecipeList = mutableListOf<Recipe>()
    private val historyList = mutableListOf<History>()
    var item1 = Item.EMPTY
    var item2 = Item.EMPTY
    var item3 = Item.EMPTY

    fun save(preferences: SharedPreferences) {
        val histories = historyList.joinToString(",") { it.toString() }
        val items = Item.values().filter { isUnlocked(it) }.joinToString(",") { it.name }

        val editor = preferences.edit()
        editor.putString("histories", histories)
        editor.putString("items", items)
        editor.apply()
    }

    fun load(preferences: SharedPreferences): List<Item> {
        val histories = preferences.getString("histories", "")!!
        for (s in histories.split(',')) {
            val history = History.parse(s)
            if (history != null) {
                unlock(history)
            }
        }

        val previousItems = mutableListOf<Item>()
        val items = preferences.getString("items", "")!!
        for (s in items.split(',')) {
            previousItems.addAll(Item.values().filter { it.name == s })
        }
        return previousItems
    }

    fun isUnlocked(group: Group): Boolean {
        return unlockedRecipeList.any { it.result.group == group }
    }

    fun isUnlocked(item: Item): Boolean {
        return unlockedRecipeList.any { it.result == item }
    }

    fun isUnlocked(recipe: Recipe): Boolean {
        return unlockedRecipeList.contains(recipe)
    }

    fun unlock(): List<Recipe> {
        return unlock(History(item1, item2, item3))
    }

    private fun unlock(history: History): List<Recipe> {
        if (historyList.contains(history)) {
            return listOf()
        }
        historyList.add(history)

        val result = Recipe.alchemise(history.item1, history.item2, history.item3)
        unlockedRecipeList.addAll(result)
        return result
    }
}