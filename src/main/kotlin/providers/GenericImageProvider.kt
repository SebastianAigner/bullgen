package providers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.array
import com.beust.klaxon.string
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import org.json.JSONObject

class GenericImageProvider(val terms: Array<String>) {

    val subscriptionKey = "33ba3199b7c34d0d9b9a35436fcad0c3"
    val host = "https://api.cognitive.microsoft.com"
    val path = "/bing/v7.0/images/search"

    fun provide() {
        var term = terms[0]
        bingImageSearch(term)
    }

    private fun bingImageSearch(term: String) {

        FuelManager.instance.basePath = host + path
        FuelManager.instance.baseHeaders = mapOf("Ocp-Apim-Subscription-Key" to subscriptionKey)

        Fuel.get("?q=" + term).responseString  { request, response, result ->
            val (data, error) = result
            if (error == null) {
                val parser = Parser()
                val json = parser.parse(StringBuilder(data)) as JsonObject
                println(json.array<JSONObject>("value")!!.string("contentUrl")[0])
            } else {
                println(error)
            }
        }
    }
}

