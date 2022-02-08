package eyeq.alchemy.game

class Game {
    val unlocked = mutableListOf<Recipe>()
    var selectedTab = Group.ALL
    var item1 = Item.EMPTY
    var item2 = Item.EMPTY
}