package generators
import HTMLString
import SlideGenerator

class TitleSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h1>A presentation</h1>" +
                "<h3>about ${keywords.joinToString()}"
    }
}