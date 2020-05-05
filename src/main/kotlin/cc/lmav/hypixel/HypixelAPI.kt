package cc.lmav.hypixel

import cc.lmav.hypixel.data.HypixelPlayerResponse
import com.google.gson.Gson
import khttp.get

fun main() {
    val api = HypixelAPI("api-key")

    api.getPlayer("trashantivirus").takeIf { it.success }?.let {
        println("Got the player - ${it.player.playername}!")
    }
}

class HypixelAPI(private val apiKey: String) {

    private val gson = Gson()

    fun getPlayer(name: String): HypixelPlayerResponse = gson.fromJson(getRawJson("player", "name=$name"),
            HypixelPlayerResponse::class.javaObjectType)

    private fun getRawJson(route: String, params: String) = get("https://api.hypixel.net/$route?$params&key=$apiKey").text


}