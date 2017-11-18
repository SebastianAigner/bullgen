package generators
import SlideGenerator
import HTMLString
import java.util.*

/* extension version */
fun <T> Iterable<T>.shuffle(): List<T> {
    val list = this.toMutableList().apply {  }
    Collections.shuffle(list)
    return list
}

class JustNumbersGenerator: SlideGenerator {



    override fun generate(keywords: Array<String>): HTMLString {
        var things = points.shuffle()
        val listItems = mutableListOf<Int>()
        for(i in 0..5) {
            listItems.add((Math.random() * 100).toInt())
        }

        val listyItems = listItems.map {
            val prefix = things.last()
            things = things.dropLast(1)
            val unit = units[(units.size * Math.random()).toInt()]
            var postfix = ""
            if(Math.random() > 0.8) {
                postfix = " (Peak)"
            }
            if(Math.random() < 0.3) {
                postfix = " (At high load)"
            }
            "<li><b>$prefix</b>: $it $unit $postfix</li>"
        }.joinToString(" ")

        // peak at high loads
        val list = """
            <ul>
            $listyItems
            </ul>
            """
        return """
            <h2>Numbers & Specs</h2>
            $list
            """
    }

    val points = listOf("Throughput", "Referrals", "Direct Contact", "Average Rate", "Suggested Emission", "Yield", "Off Shore", "Indirect", "Buffer", "Clearance")

    val units = arrayOf("KHz", "dB", "hPa", "km", "V", "FPS", "N", "ft/s", "W", "K", "mol", "cd", "S")
}