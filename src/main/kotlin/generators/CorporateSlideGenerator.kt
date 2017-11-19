package generators
import HTMLString
import SlideGenerator
import org.json.JSONObject

import providers.provideCorporateBulletpoint

class CorporateSlideGenerator : SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h1>Main Corporate Strategy</h1>" +
                "<ol>" +
                "<li>${provideCorporateBulletpoint()}</li>" +
                "<li>${provideCorporateBulletpoint()}</li>" +
                "<li>${provideCorporateBulletpoint()}</li>" +
                "<li>${provideCorporateBulletpoint()}</li>" +
                "</ol>"
    }
}