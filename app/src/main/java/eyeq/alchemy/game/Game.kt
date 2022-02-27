package eyeq.alchemy.game

import android.content.SharedPreferences

class Game {
    private val unlockedRecipeList = mutableListOf<Recipe>()
    private val historyList = mutableListOf<History>()
    private val hintList = mutableListOf<Item>()
    var item1 = Item.EMPTY
    var item2 = Item.EMPTY
    var item3 = Item.EMPTY

    fun getHistoryList(): List<History> {
        return historyList.toList()
    }

    fun getHintList(): List<Item> {
        return hintList.filter { item -> !unlockedRecipeList.any { it.result == item } }
    }

    fun getUnlockedGroupList(): List<Group> {
        return Group.values().filter { isUnlocked(it) }
    }

    fun getUnlockedItemList(): List<Item> {
        return Item.values().filter { isUnlocked(it) }
    }

    fun clear() {
        unlockedRecipeList.clear()
        historyList.clear()
        item1 = Item.EMPTY
        item2 = Item.EMPTY
        item3 = Item.EMPTY
    }

    fun save(preferences: SharedPreferences) {
        val histories = historyList.joinToString(",") { it.toString() }
        val items = getUnlockedItemList().joinToString(",") { it.name }
        val hintItemss = hintList.joinToString(",") { it.name }

        val editor = preferences.edit()
        editor.putString("histories", histories)
        editor.putString("items", items)
        editor.putString("hintItemss", hintItemss)
        editor.apply()
    }

    fun load(preferences: SharedPreferences): List<Item> {
        unlockedRecipeList.clear()
        historyList.clear()
        hintList.clear()

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

        val hintItemss = preferences.getString("hintItemss", "")!!
        for (s in hintItemss.split(',')) {
            hintList.addAll(Item.values().filter { it.name == s })
        }
        hintList.sortBy { Item.values().indexOf(it) }

        return getUnlockedItemList().filter { !previousItems.contains(it) }
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

    fun unlock(history: History): List<Recipe> {
        if (historyList.contains(history)) {
            return listOf()
        }
        historyList.add(history)

        val result = Recipe.getRecipeListByInputs(history.item1, history.item2, history.item3)
        unlockedRecipeList.addAll(result)
        return result
    }

    fun getHints(preferences: SharedPreferences): Int {
        return preferences.getInt("hints", 0)
    }

    fun addHints(preferences: SharedPreferences, amount: Int): Boolean {
        val hints = getHints(preferences) + amount
        if (hints < 0) {
            return false
        }

        preferences.edit().putInt("hints", hints).apply()
        return true
    }

    fun isHintable(): Boolean {
        val unlocked = getUnlockedItemList()
        return Item.values()
            .filter { Recipe.canMake(it) }
            .any { !unlocked.contains(it) && !hintList.contains(it) }
    }

    fun hint() {
        val unlocked = getUnlockedItemList()
        val target = Item.values()
            .filter { Recipe.canMake(it) }
            .filter { !unlocked.contains(it) && !hintList.contains(it) }
        if (target.any()) {
            val recipes = Recipe.getRecipeListByResult(target.first())
            for (recipe in recipes) {
                if (!hintList.contains(recipe.result)) {
                    hintList.add(recipe.result)
                }
            }
        }
    }
}