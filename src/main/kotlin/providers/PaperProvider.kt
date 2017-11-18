package providers

import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs

fun getPaper(): String {
    var data = ""
    val (request, response, result) = "http://export.arxiv.org/api/query?search_query=all:blockchain&start=0&max_results=10".httpGet().responseString() // result is Result<String, FuelError>
    when(result) {
        is Result.Failure -> {
            println("Something went to shit, please check your network connection")
            return "Bruegge et. al: How fog computing is going to revolutionise a blockchain driven smart city"
        }
        is Result.Success -> {
            data = result.get()
        }
    }
    assert(result is Result.Success)

    val articles = data.split("</entry>")

    articles.map {
        var title: String? = ""
        var authors = emptyList<String>()
        var abstract = ""

        val titleRegex = """<title>(.*)<\/title>""".toRegex()
        val foundTitle = titleRegex.find(it, 0)
        title = foundTitle?.groups?.get(1)?.value

        val authorsRegex = """(?s)<author>[^<]*<name>([^<]*)<\/name>[^<]*<\/author>""".toRegex()

        val foundAuthors = authorsRegex.find(it, 0)
        println(foundAuthors?.groups)
        //Article(title, authors, abstract)
    }

    return "wank"
}

data class Article(val title: String, val authors: List<String>, val abstract: String)