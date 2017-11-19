
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
    ProblemIntroSlideGenerator(),
    ProblemStatementSlideGenerator(),
    GenericFillerSlideGenerator(),
    GenericFillerSlideGenerator(),
    TwitterSlideGenerator(),
    CorporateSlideGenerator(),
//    JustNumbersGenerator(),
//    EmojiJerkSlideGenerator(),
    MathSlideGenerator(),
    ProductGrowthSlideGenerator(),
    ProductGrowthSlideGenerator(),
    GenericFillerSlideGenerator(),
    GermanConceptGenerator(),
    ProductGrowthSlideGenerator(),
    InspirationalSlide(),
    HappyTeamSlideGenerator(),
    SuggestedReadingGenerator(),
    QASlideGenerator()
)

fun main(args: Array<String>) {
    val resolver = ClassLoaderTemplateResolver()
    resolver.setTemplateMode("XHTML")
    resolver.suffix = ".html"
    val engine = TemplateEngine()
    engine.setTemplateResolver(resolver)
    val writer = StringWriter()
    val context = Context()

    val keywords = arrayOf(
            provideIndustrySector(),
            provideIndustryTrouble(),
            provideIndustryTrouble(),
            getNoun(),
            getNoun()
    )

    val slideContents = slideGenerators.map { it.generate(keywords) }

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