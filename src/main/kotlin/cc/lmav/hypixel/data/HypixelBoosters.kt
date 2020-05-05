package cc.lmav.hypixel.data

data class HypixelBoostersWrapper(val success: Boolean, val boosters: List<HypixelBooster>, val boosterState: HypixelBoosterState)
data class HypixelBooster(val _id: String, val purchaserUuid: String, val amount: Double, val originalLength: Long, val length: Long,
                          val gameType: Int, val dateActivated: Long)
data class HypixelBoosterState(val decrementing: Boolean)