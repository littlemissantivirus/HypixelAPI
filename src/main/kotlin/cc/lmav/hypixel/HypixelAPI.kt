package cc.lmav.hypixel

import cc.lmav.hypixel.data.HypixelBoostersWrapper
import cc.lmav.hypixel.data.HypixelGuildWrapper
import cc.lmav.hypixel.data.HypixelPlayerResponse
import com.google.gson.Gson
import khttp.get

fun main() {
    // This is an example of how the HypixelAPI wrapper works.
    // Replace "PUT YOUR API KEY HERE!!!" with your API key and watch.

    val api = HypixelAPI("PUT YOUR API KEY HERE!!!")

    println("------------- PLAYER EXAMPLE -------------")
    api.getPlayerByName("trashantivirus").takeIf { it.success }?.let {
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
                println("${guildMember.player.displayname} has the rank: ${member.rank}")
            }
        }
    }
}

class HypixelAPI(private val apiKey: String) {

    private val gson = Gson()

    fun getPlayerByName(name: String): HypixelPlayerResponse = gson.fromJson(getRawJson("player", "&name=$name"),
            HypixelPlayerResponse::class.java)

    fun getPlayerByUuid(uuid: String): HypixelPlayerResponse = gson.fromJson(getRawJson("player", "&uuid=$uuid"),
            HypixelPlayerResponse::class.java)

    fun getBoosters(): HypixelBoostersWrapper = gson.fromJson(getRawJson("boosters", ""),
            HypixelBoostersWrapper::class.java)

    fun getGuild(name: String): HypixelGuildWrapper = gson.fromJson(getRawJson("guild", "&name=$name"),
            HypixelGuildWrapper::class.java)

    private fun getRawJson(route: String, params: String) = get("https://api.hypixel.net/$route?key=$apiKey$params").text


}