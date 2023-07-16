const val HERO_NAME = "Madrigal"
var playerLevel = 5
fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)
    println(playerLevel)

    println("Time passes..")
    println("The hero returns from her quest.")

    playerLevel += 1
    println(playerLevel)
    readBountyBoard()
}


private fun readBountyBoard() {
    println("The hero approaches the bounty board. It reads:")
    println(obtainQuest(playerLevel, "paladin", true))
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String,
    hasAngeredBarbarians: Boolean,
    hasBefriendedBarbarians: Boolean = false
): String =
    when (playerLevel) {
        1 -> "Meet Mr.Bubbles in the land of soft things."
        in 2..5 -> {
            val canTalkToBarbarian = !hasAngeredBarbarians &&
                    (hasBefriendedBarbarians || playerClass == "barbarian")
            if (canTalkToBarbarian)
                "Convince the barbarians to call off their invasions."
            else
                "Save the town from the barbarian invasions."
        }
        6 -> "Locate the enchanted sword."
        7 -> "Recover the long-lost artifact of creation"
        8 -> "Defeat Nogartse, bringer of death and eater of worlds."
        else -> "There are no quests right now."
    }




