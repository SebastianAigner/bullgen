package generators
import HTMLString
import SlideGenerator
import org.json.JSONObject
import providers.TheValleyNameProvider

class TitleSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h1>${TheValleyNameProvider().provide()}</h1>" +
                "<h3>about ${keywords[0]}, ${keywords[3]} and ${keywords[4]}</h3>"
    }
}