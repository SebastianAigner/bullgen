package generators
import HTMLString
import SlideGenerator
import providers.getPaper

class SuggestedReadingGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        val articles = getPaper(keywords[3])
        val sb = StringBuilder()
        sb.append("<h2>Suggested Reading</h2>")
        sb.append("<ul>")
        articles.take(4).forEach {
            sb.append("<li>${it.authors.take(2).joinToString()}: <br><i>${it.title}</i></li>")
        }
        sb.append("</ul>")
        return sb.toString()
    }
}