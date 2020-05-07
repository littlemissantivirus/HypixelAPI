package cc.lmav.hypixel.data

import java.util.*

data class HypixelKeyWrapper(val success: Boolean, val record: HypixelKeyRecord)
data class HypixelKeyRecord(
        val ownerUuid: String,
        val key: UUID,
        val totalQueries: Int,
        val queriesInPastMin: Int = 0
)