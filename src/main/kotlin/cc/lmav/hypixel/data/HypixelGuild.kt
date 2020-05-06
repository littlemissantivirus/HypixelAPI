package cc.lmav.hypixel.data

data class HypixelGuildWrapper(val success: Boolean, val guild: HypixelGuild)

data class HypixelGuild(
        val _id: String,
        val achievements: Map<String, Int>,
        val banner: HypixelGuildBanner,
        val chatMute: Long,
        val coins: Int,
        val coinsEver: Int,
        val created: Long,
        val description: String,
        val exp: Double,
        val expByGameType: Map<String, Double>,
        val hideGmTag: Boolean,
        val joinable: Boolean,
        val legacyRanking: Int,
        val members: List<HypixelGuildMember>,
        val name: String,
        val name_lower: String,
        val preferredGames: List<String>,
        val publiclyListed: Boolean,
        val ranks: List<HypixelGuildRank>,
        val tag: String,
        val tagColor: String
)

data class HypixelGuildMember(
        val uuid: String,
        val rank: String,
        val joined: Long,
        val questParticipation: Int,
        val expHistory: Map<String, Int>
)

data class HypixelGuildBanner(val Base: Int, val Patterns: List<HypixelGuildPattern>)

data class HypixelGuildPattern(val Pattern: String, val Color: Int)

data class HypixelGuildRank(
        val name: String,
        val default: Boolean,
        val tag: String,
        val created: Long,
        val priority: Int
)