package cc.lmav.hypixel.data

data class HypixelPlayerResponse(val success: Boolean, val player: HypixelPlayer)

data class HypixelPlayer(
        val _id: String,
        val achievementPoints: Int,
        val achievementRewardsNew: Map<String, Long>,
        val achievements: Map<String, Int>,
        val achievementsOneTime: List<Any>,
        val achievementSync: Map<String, Int>,
        val achievementTracking: List<String>,
        val adsense_tokens: Int,
        val battlePassGlowStatus: Boolean,
        val buildTeam: Boolean,
        val challenges: HypixelPlayerChallenges,
        val channel: String,
        val chatAlerts: Boolean,
        val compassStats: HypixelPlayerCompass,
        val disguise: String,
        val displayname: String,
        val eugene: HypixelPlayerEugene,
        val eulaCoins: Boolean,
        val fireworkStorage: List<HypixelPlayerFirework>,
        val firstLogin: Long,
        val fortuneBuff: Int,
        val friendRequests: List<String>,
        val friendRequestsUuid: List<String>,
        val gadget: String,
        val giftingMeta: HypixelPlayerGifting,
        val karma: Int,
        val knownAliases: List<String>,
        val knownAliasesLower: List<String>,
        val levelUp_MVP_PLUS: Long,
        val mcVersionRp: String,
        val monthlyPackageRank: String,
        val mostRecentMinecraftVersion: Int,
        val mostRecentMonthlyPackageRank: String,
        val networkExp: Long,
        val newPackageRank: Rank,
        val packageRank: Rank,
        val playername: String,
        val prefix: String,
        val quests: Map<String, HypixelPlayerQuest>,
        val rank: String,
        val rankPlusColor: String,
        val totalDailyRewards: Int,
        val totalRewards: Int,
        val tournamentTokens: Int,
        val transformation: String,
        val userLanguage: String,
        val uuid: String,
        val vanityTokens: Int
) {

}

data class HypixelPlayerChallenges(
        val all_time: Map<String, Int>,
        val day_f: Map<String, Int>,
        val day_g: Map<String, Int>,
        val day_h: Map<String, Int>,
        val day_i: Map<String, Int>,
        val day_j: Map<String, Int>,
        val day_k: Map<String, Int>,
        val day_l: Map<String, Int>,
        val day_a: Map<String, Int>
)
data class HypixelPlayerCompass(val compass: Map<String, Int>)
data class HypixelPlayerEugene(val dailyTwoKExp: Long, val weekly_booster: Long)

data class HypixelPlayerFirework(
        val colors: String,
        val fade_colors: String,
        val flight_duration: Int,
        val selected: Boolean,
        val shape: String,
        val trail: Boolean,
        val twinkle: Boolean
)

data class HypixelPlayerGifting(
        val bundlesGiven: Int,
        val bundlesReceived: Int,
        val giftsGiven: Int,
        val milestones: List<String>,
        val realBundlesGiven: Int,
        val realBundlesReceived: Int,
        val realBundlesReceivedInc: Int
)

data class HypixelPlayerQuest(val completions: List<HypixelPlayerQuestCompletion>, val active: HypixelPlayerQuestActive)
data class HypixelPlayerQuestActive(val started: Long, val objectives: Map<String, Int>)
data class HypixelPlayerQuestCompletion(val time: Long)

enum class Rank {
    VIP, VIP_PLUS, MVP, MVP_PLUS, SUPERSTAR, YOUTUBE, HELPER, MOD, ADMIN
}