package eyeq.alchemy.game

import eyeq.alchemy.R

enum class Group(val textId: Int) {
    ALL(R.string.group_all),
    ELEMENTAL(R.string.group_elemental),
    MATERIAL(R.string.group_material),
    NATURE(R.string.group_nature),
    ARTIFACT(R.string.group_artifact),
    TOOL(R.string.group_tool),
    TECHNOLOGY(R.string.group_technology),
    FOOD(R.string.group_food),
    ;
}