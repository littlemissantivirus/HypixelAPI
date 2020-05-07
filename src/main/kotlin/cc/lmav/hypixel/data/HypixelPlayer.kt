package cc.lmav.hypixel.data

import com.google.gson.annotations.SerializedName
import java.lang.Math.sqrt

data class HypixelPlayerWrapper(val success: Boolean, val player: HypixelPlayer)

data class HypixelPlayer(
        val _id: String,
        val achievementPoints: Int,
        val achievementRewardsNew: Map<String, Long>,
        val achievements: Map<String, Int>,
        val achievementsOneTime: List<Any>,
        val achievementSync: Map<String, Int>,
        val achievementTracking: List<String>,
        @SerializedName("adsense_tokens")
        val adsenseTokens: Int,
        val battlePassGlowStatus: Boolean,
        val buildTeam: Boolean,
        val challenges: HypixelPlayerChallenges,
        val channel: String,
        val chatAlerts: Boolean,
        val compassStats: HypixelPlayerCompass,
        val disguise: String,
        @SerializedName("displayname")
        val displayName: String,
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
        val monthlyPackageRank: Rank,
        val mostRecentMinecraftVersion: Int,
        val mostRecentMonthlyPackageRank: String,
        val networkExp: Long,
        val newPackageRank: Rank,
        val packageRank: Rank,
        @SerializedName("playername")
        val playerName: String,
        val prefix: String,
        val quests: Map<String, HypixelPlayerQuest>,
        val rank: Rank,
        val rankPlusColor: String,
        val totalDailyRewards: Int,
        val totalRewards: Int,
        val tournamentTokens: Int,
        val transformation: String,
        val userLanguage: String,
        val uuid: String,
        val vanityTokens: Int
) {

    fun getPlayerRank() = rank ?: monthlyPackageRank ?: newPackageRank ?: packageRank ?: Rank.DEFAULT
    fun playerLevel() = (sqrt(networkExp + 15312.5) - 125/sqrt(2.toDouble())) / (25 * sqrt(2.toDouble()));

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

enum class Rank(val prefix: String, val chatColor: ChatColor) {
    VIP("[VIP]", ChatColor.GREEN),
    @SerializedName("VIP_PLUS")
    VIPPLUS("[VIP+]", ChatColor.GREEN),
    MVP("[MVP]", ChatColor.AQUA),
    @SerializedName("MVP_PLUS")
    MVPPLUS("[MVP+]", ChatColor.AQUA),
    SUPERSTAR("[MVP++]", ChatColor.GOLD),
    YOUTUBER("[YOUTUBE]", ChatColor.RED),
    HELPER("[HELPER]", ChatColor.BLUE),
    MOD("[MOD]", ChatColor.DARK_GREEN),
    ADMIN("[ADMIN]", ChatColor.RED),

    DEFAULT("", ChatColor.GRAY)
}