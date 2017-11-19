package generators
import HTMLString
import SlideGenerator
import plusAssign

class EmojiJerkSlideGenerator: SlideGenerator {
    val emojis = listOf("😎", "🤡", "😏", "😡", "🤓", "🤠", "🌶", "💯", "👀")
    val tableSize = 3
    override fun generate(keywords: Array<String>): HTMLString {
        val sb = StringBuilder()
        val technologies = keywords.take(3)
        val criteria = listOf("Usability", "Performance", "Sustainability", "Awareness")
        sb += "<table>"
        sb += "<tr>"
        sb += "<th></th>"
        sb += technologies.map { "<th>$it</th>" }.joinToString(" ")
        sb += "<tr>"
        for(heightIndex in 0..tableSize) {
            sb += "<tr>"
            for(widthIndex in 0..tableSize) {
                if(widthIndex == 0) {
                    sb += "<td>"
                    sb += criteria[heightIndex]
                    sb += "</td>"
                    continue
                }
                val moj = emojis[(emojis.size * Math.random()).toInt()]
                println(moj)
                println(emojis)
                sb += "<td>${moj}</td>"
            }
            sb += "</tr>"
        }
        sb += "</table>"
        return sb.toString()
    }


    fun techProviderMock(): List<String> {
        return listOf("Blockchain", "E-Governance", "Fog Computing")
    }
}



