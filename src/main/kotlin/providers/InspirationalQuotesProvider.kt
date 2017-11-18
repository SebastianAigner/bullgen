package providers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.lookup
import com.beust.klaxon.string
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpPost
import org.json.JSONObject
import java.util.*

class InspirationalQuotesProvider() {

    val path = "http://api.forismatic.com/api/1.0/"
    val params = "?method=getQuote&format=JSON&lang=en"

    fun provide() : Pair<String?, String?> {
        val (request, response, result) = (path + params).httpPost().responseString()
        val (data, error) = result
        return if (error == null) {
            val parser = Parser()
            val json = parser.parse(StringBuilder(data)) as JsonObject

            val quoteText = json.lookup<String?>("forismatic.quote.quoteText")[0]
            val quoteAuthor = json.lookup<String?>("forismatic.quote.quoteAuthor")[0]
            return Pair(quoteText, quoteAuthor)
        } else {
            println(error)
            Pair("", "")
        }
    }
}