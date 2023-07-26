import java.lang.IllegalArgumentException

const val HERO_NAME = "Madrigal"
var playerLevel = 0
fun main() {
    println("$HERO_NAME announces her presence to the world.")
    println("What level is $HERO_NAME?")
    // Checking if input contains all the digits to be parsed into integer
    //[\d+] denotes any digit between 0 and 9 and + represents one or more instances of the character to its left.
    playerLevel = readln().toIntOrNull() ?: 0


    println("Time passes..")
    println("$HERO_NAME returns from her quest.")

    playerLevel += 1
    println(playerLevel)
    readBountyBoard()
}

private fun readBountyBoard() {
    val message: String = try {
        val quest: String? = obtainQuest(playerLevel)
        quest?.replace("Nogartse", "xxxxxxx")
            ?.let { censoredQuest ->
                """
                $HERO_NAME approaches the bounty board. It reads:
                    $censoredQuest
                """.trimIndent()
            } ?: "$HERO_NAME approaches the bounty board, but it is blank."
    } catch (e: Exception) {
        "$HERO_NAME can't read what's on the bounty board."
    }
    println(message)
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "paladin",
    hasAngeredBarbarians: Boolean = true,
    hasBefriendedBarbarians: Boolean = false
): String? {
    // Throws IllegalArgumentException, indicates that an illegal input was provided.
    require (playerLevel > 0){
        "The player's level must be at least 1."
    }

    return when (playerLevel) {
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
        else -> null
    }
}

// Custom Exception.
class InvalidPlayerLevelException() : IllegalArgumentException("Invalid player level (must be at least 1)")




