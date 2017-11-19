package generators
import HTMLString
import SlideGenerator
import org.json.JSONObject

import providers.provideCorporateBulletpoint

class CorporateSlideGenerator : SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        val listElements = Array(4) { provideCorporateBulletpoint() }.map { "<li>$it</li>" }.joinToString(" ")
        return """<h1>Main Corporate Strategy</h1>
            <ol>
            $listElements
            </ol>"""
    }
}