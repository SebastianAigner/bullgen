package generators
import SlideGenerator
import HTMLString
import choice
import providers.InspirationalQuotesProvider

class InspirationalSlide: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        val (quote, author) = InspirationalQuotesProvider("solution").provide()
        val headline = "".choice("Those who know", "Inspiring words", "Food for thought")
        return """
            <h2>$headline</h2>
            <blockquote>
            $quote
            </blockquote>
            <p>~ $author</p>
            """
    }
}