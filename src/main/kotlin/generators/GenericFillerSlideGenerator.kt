package generators
import HTMLString
import SlideGenerator
import choice
import plusAssign
import providers.getAdverb
import providers.getApproach

class GenericFillerSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        val sb = StringBuilder()
        sb += "<h2>".choice("How we attempt to solve this", "What our approach will be", "Possible solutions?", "Attempting to solve the issue", "Selected methods") + "</h2>"

        val listItems = Array(5) { "<li>" + getApproach() + if(Math.random() > 0.9) { " (${getAdverb()})" } else { "" } + "</li>" }.joinToString(" ")

        sb += """
            <ul>
            $listItems
            </ul>
            """
        return sb.toString()
    }
}

