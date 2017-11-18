import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.io.StringWriter

fun main(args: Array<String>) {
    val resolver = ClassLoaderTemplateResolver()
    resolver.setTemplateMode("XHTML")
    resolver.suffix = ".html"
    val engine = TemplateEngine()
    engine.setTemplateResolver(resolver)
    val writer = StringWriter()
    val context = Context()
    context.setVariable("name", "Sebastian Aigner")
    context.setVariable("person", Person("Anselm", "Eickhoff"))
    engine.process("home", context, writer)
    println(writer.buffer)
}

data class Person(val firstName: String, val lastName: String)