package cc.lmav.hypixel.data

data class HypixelGuildWrapper(val success: Boolean, val guild: HypixelGuild)
data class HypixelGuild(val _id: String, val name: String, val coins: Int, val coinsEver: Int, val created: Long,
                        val members: List<HypixelGuildMember>, val banner: HypixelGuildBanner, val tag: String,
                        val legacyRanking: Int, val exp: Long, val achievements: Map<String, Int>, val ranks: List<HypixelGuildRank>,
                        val publiclyListed: Boolean, val preferredGames: List<String>, val name_lower: String, val tagColor: String,
                        val hideGmTag: Boolean, val guildExpByGameType: Map<String, Int>)

data class HypixelGuildMember(val uuid: String, val rank: String, val joined: Long, val questParticipation: Int,
                              val expHistory: Map<String, Int>)
data class HypixelGuildBanner(val Base: Int, val Patterns: List<HypixelGuildPattern>)
data class HypixelGuildPattern(val Pattern: String, val Color: Int)
data class HypixelGuildRank(val name: String, val default: Boolean, val tag: String, val created: Long, val priority: Int)