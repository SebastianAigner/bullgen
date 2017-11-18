
import generators.*

import org.json.JSONObject
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import providers.GenericImageProvider
import providers.InspirationalQuotesProvider
import java.io.File
import java.io.StringWriter

val slideGenerators = arrayOf(
    CorporateSlideGenerator(),
    HappyTeamSlideGenerator(),
    TitleSlideGenerator(),
    EmojiJerkSlideGenerator(),
    SuggestedReadingGenerator(),
    HappyTeamSlideGenerator(),
    ProductGrowthSlideGenerator(),
    TitleSlideGenerator()
)

fun main(args: Array<String>) {
    val resolver = ClassLoaderTemplateResolver()
    resolver.setTemplateMode("XHTML")
    resolver.suffix = ".html"
    val engine = TemplateEngine()
    engine.setTemplateResolver(resolver)
    val writer = StringWriter()
    val context = Context()

    val slideContents = slideGenerators.map { it.generate(arrayOf("blockchain", "scalability", "happiness")) }

    val slides = slideContents.map {
        Slide(it)
    }

    context.setVariable("slides", slides)
    engine.process("index", context, writer)
    println(writer.buffer)
    val outString = writer.buffer.toString()
    File("bullgen_presentation.html").printWriter().use { out -> out.println(outString) }
}

data class Slide(val content: String)

data class Person(val firstName: String, val lastName: String)