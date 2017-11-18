
import generators.EmojiJerkSlideGenerator

import generators.SuggestedReadingGenerator

import generators.TitleSlideGenerator
import generators.HappyTeamSlideGenerator
import generators.ProductGrowthSlideGenerator
import org.json.JSONObject
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import providers.GenericImageProvider
import providers.InspirationalQuotesProvider
import providers.TheValleyNameProvider
import java.io.File
import java.io.StringWriter

val slideGenerators = arrayOf(
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

//    val imageProvider = FaceImageProvider("businessman")
//    println(imageProvider.provide())

//    val quoteProvider = InspirationalQuotesProvider()
//    println(quoteProvider.provide())

//    val markovNameProvider = TheValleyNameProvider()
//    markovNameProvider.provide()

//    val markovNameProvider = TheValleyNameProvider()
//    markovNameProvider.provide()

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