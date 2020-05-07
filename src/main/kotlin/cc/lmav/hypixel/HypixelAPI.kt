package cc.lmav.hypixel

import cc.lmav.hypixel.data.HypixelBoostersWrapper
import cc.lmav.hypixel.data.HypixelGuildWrapper
import cc.lmav.hypixel.data.HypixelKeyWrapper
import cc.lmav.hypixel.data.HypixelPlayerWrapper
import cc.lmav.hypixel.exception.BoosterParseException
import cc.lmav.hypixel.exception.GuildNotFoundException
import cc.lmav.hypixel.exception.KeyParseException
import cc.lmav.hypixel.exception.PlayerNotFoundException
import com.google.gson.Gson
import com.sun.xml.internal.bind.v2.TODO
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.util.*

suspend fun main() {
    // This is an example of how the HypixelAPI wrapper works.
    // Replace "PUT YOUR API KEY HERE!!!" with your API key and watch.

    val api = HypixelAPI("PUT YOUR API KEY HERE!!!")

    println("------------- PLAYER EXAMPLE -------------")
    api.getPlayerByName("trashantivirus")?.takeIf { it.success }?.let {
        println("trashantivirus has completed ${it.player.achievements.size + it.player.achievementsOneTime.size} achievements, for a total of ${it.player.achievementPoints}!")
    }

    println("\n\n------------- BOOSTER EXAMPLE -------------")

    api.getBoosters().takeIf { it.success }?.let {
        println(it.boosters[0])
    }

    println("\n\n------------- GUILD EXAMPLE -------------")

    api.getGuild("zerite").takeIf { it.success }?.let {wrapper ->
        wrapper.guild.members.forEach { member ->

            api.getPlayerByUuid(member.uuid).takeIf { it.success }?.let {guildMember ->
                println("${guildMember.player.displayName} has the rank: ${member.rank}")
            }
        }
    }

    api.getKey().takeIf { it.success }?.let { wrapper ->
        println("This key has been used ${wrapper.record.totalQueries} times!")
    }
}

class HypixelAPI(private val apiKey: String) {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getPlayerByName(name: String) = getRawJson<HypixelPlayerWrapper>("player") {
        parameter("name", name)
    } ?: throw PlayerNotFoundException()

    suspend fun getPlayerByUuid(uuid: String) = getRawJson<HypixelPlayerWrapper>("player") {
        parameter("uuid", uuid)
    } ?: throw PlayerNotFoundException()

    suspend fun getPlayerByUuid(uuid: UUID) = getRawJson<HypixelPlayerWrapper>("player") {
        parameter("uuid", uuid)
    } ?: throw PlayerNotFoundException()

    suspend fun getBoosters() = getRawJson<HypixelBoostersWrapper>("boosters") ?: throw BoosterParseException()

    suspend fun getKey() = getRawJson<HypixelKeyWrapper>("key") ?: throw KeyParseException()

    suspend fun getGuild(name: String) = getRawJson<HypixelGuildWrapper>("guild") {
        parameter("name", name)
    } ?: throw GuildNotFoundException()

    suspend fun getGuildByPlayer(name: String): Nothing = TODO()

    suspend fun getGuildByPlayer(uuid: UUID): Nothing = TODO()

    private suspend inline fun <reified T> getRawJson(route: String, block: HttpRequestBuilder.() -> Unit = {}): T? =
            try {
                httpClient.get("https://api.hypixel.net/$route") {
                    parameter("key", apiKey)
                    this.block()
                }
            } catch (e: Throwable) {
                null
            }


}