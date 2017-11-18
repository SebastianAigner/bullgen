package providers

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet

class GenericImageProvider(val terms: Array<String>) {

    val subscriptionKey = "33ba3199b7c34d0d9b9a35436fcad0c3"
    val host = "https://api.cognitive.microsoft.com"
    val path = "/bing/v7.0/images/search"

    fun provide() {
        var term = terms[0]
        bingImageSearch(term)
    }

    private fun bingImageSearch(term: String) {

        FuelManager.instance.basePath = host + path + "?q=" + term
        FuelManager.instance.baseHeaders = mapOf("Ocp-Apim-Subscription-Key" to subscriptionKey)

        Fuel.get("/").responseString  { request, response, result ->
            val (data, error) = result
            if (error == null) {
                println(data) // TODO parse JSON
            } else {
                //error handling
            }
        }
    }
}

