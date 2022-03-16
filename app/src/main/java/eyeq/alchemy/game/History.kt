package eyeq.alchemy.game

class History(val item1: Item, val item2: Item, val item3: Item) {

    companion object {
        fun parse(str: String): History? {
            try {
                val split = str.split('|')
                if (split.count() > 2) {
                    return History(
                        Item.values().first { it.name == split[0] },
                        Item.values().first { it.name == split[1] },
                        Item.values().first { it.name == split[2] })
                }
            } catch (e: Throwable) {
                // ignored
            }
            return null
        }
    }

    override fun equals(other: Any?): Boolean {
        return toString() == other.toString()
    }

    override fun toString(): String {
        val list = listOf<Item>(item1, item2, item3).sortedBy { it.ordinal }
        return list.joinToString("|") { it.name }
    }

    override fun hashCode(): Int {
        var result = item1.hashCode()
        result = 31 * result + item2.hashCode()
        result = 31 * result + item3.hashCode()
        return result
    }
}