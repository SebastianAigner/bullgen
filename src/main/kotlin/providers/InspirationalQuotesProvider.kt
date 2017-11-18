package providers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.lookup
import com.beust.klaxon.string
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import org.json.JSONObject
import java.util.*

class InspirationalQuotesProvider() {

    val path = "https://favqs.com/api/quotes/?filter=solution"

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start

    fun provide() : Pair<String?, String?> {
        FuelManager.instance.baseHeaders = mapOf("Authorization" to "Token token=\"8904903f3385b1399fc7c6306eb793e1\"")

        val (request, response, result) = (path).httpGet().responseString()
        val (data, error) = result
        return if (error == null) {
            val parser = Parser()
            val json = parser.parse(StringBuilder(data)) as JsonObject

            val quotes = json.lookup<String?>("quotes.body")
            if (quotes.size == 0) {
                println("No quotes available for the keyword")
                Pair("", "")
            }
            val randomQuote = (0..(quotes.size - 1)).random()
            val quoteText = quotes[randomQuote]
            val quoteAuthor = json.lookup<String?>("quotes.author")[randomQuote]
            return Pair(quoteText, quoteAuthor)
        } else {
            println(error)
            Pair("", "")
        }
    }
}