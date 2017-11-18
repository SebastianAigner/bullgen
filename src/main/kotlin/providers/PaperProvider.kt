package providers

import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs

fun getPaper(keyword: String): List<Article> {

    var data = ""
    val (request, response, result) = "http://export.arxiv.org/api/query?search_query=all:$keyword&start=0&max_results=10".httpGet().responseString() // result is Result<String, FuelError>
    when(result) {
        is Result.Failure -> {
            println("Something went to shit, please check your network connection")
            throw RuntimeException("Can't get paper, like, at all")
        }
        is Result.Success -> {
            data = result.get()
        }
    }
    assert(result is Result.Success)

    val articles = data.split("</entry>")

    return articles.map {
        var title: String = ""
        var abstract = ""

        val titleRegex = """<title>(.*)<\/title>""".toRegex()
        val foundTitle = titleRegex.find(it, 0)
        title = foundTitle?.groups?.get(1)?.value ?: "(Unnamed paper)"

        val authorsRegex = """(?s)<author>[^<]*<name>([^<]*)<\/name>[^<]*<\/author>""".toRegex()

        val foundAuthors = authorsRegex.findAll(it, 0)
        //println("=======")
        val foundAuthorNames = foundAuthors.map {
            it.groups.get(1)?.value
        }

        //println(foundAuthorNames.joinToString())

        val authors = foundAuthorNames.mapNotNull { it }.toList()

        val retval = Article(title, authors)
        //println(retval)
        retval
    }
}

data class Article(val title: String, val authors: List<String>)