
import generators.*

import org.json.JSONObject
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import providers.*
import java.io.File
import java.io.StringWriter

val slideGenerators = arrayOf(
    TitleSlideGenerator(),
        CorporateSlideGenerator(),
        HappyTeamSlideGenerator(),
        TwitterSlideGenerator(),
        JustNumbersGenerator(),
        EmojiJerkSlideGenerator(),
        MathSlideGenerator(),
        GenericFillerSlideGenerator(),
        ProductGrowthSlideGenerator(),
        GermanConceptGenerator(),
        SuggestedReadingGenerator()
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

//    var tweetsProvider = TweetsProvider("trump idiot")
//    println(tweetsProvider.provide()[0].first)

    val slideContents = slideGenerators.map { it.generate(arrayOf(getNoun(), getNoun(), getNoun())) }

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