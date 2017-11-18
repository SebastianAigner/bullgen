package providers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.array
import com.beust.klaxon.string
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import org.json.JSONObject
import java.util.*

class FaceImageProvider(val terms: String) {

    val subscriptionKey = "33ba3199b7c34d0d9b9a35436fcad0c3"
    val host = "https://api.cognitive.microsoft.com"
    val path = "/bing/v7.0/images/search"

    fun provide() : String? {
        return bingImageSearch(terms)
    }

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start

    private fun bingImageSearch(terms: String) : String? {

        FuelManager.instance.baseHeaders = mapOf("Ocp-Apim-Subscription-Key" to subscriptionKey)

        val (request, response, result) = (host + path + "?q=" + terms + "&imageContent=Portrait&imageType=Photo").httpGet().responseString()
        val (data, error) = result
        return if (error == null) {
            val parser = Parser()
            val json = parser.parse(StringBuilder(data)) as JsonObject
            val images = json.array<JSONObject>("value")!!
            val randomImage = (0..(images.size - 1)).random()
            (images.string("contentUrl")[randomImage])
        } else {
            println(error)
            ""
        }
    }
}