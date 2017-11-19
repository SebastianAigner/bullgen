package generators

import providers.TheValleyNameProvider
import HTMLString
import SlideGenerator
import org.json.JSONObject
import providers.GenericImageProvider

class QASlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h1>Q & A</h1>" +
                """<img src="${GenericImageProvider("question").provide()}" style="height: 40vh"/>"""
    }
}