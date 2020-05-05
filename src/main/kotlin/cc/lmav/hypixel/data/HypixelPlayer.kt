package cc.lmav.hypixel.data

data class HypixelPlayerResponse(val success: Boolean, val player: HypixelPlayer)
data class HypixelPlayer(val achievements: Map<String, Int>, val achievementsOneTime: List<String>,
val displayname: String, val playername: String, val achievementPoints: Int)