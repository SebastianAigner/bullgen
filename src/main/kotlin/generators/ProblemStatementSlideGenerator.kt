package generators

import HTMLString
import SlideGenerator
import org.json.JSONObject
import providers.GenericImageProvider
import providers.provideIndustrySector
import providers.provideIndustryTrouble

class ProblemStatementSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        return "<h2>Disrupting ${keywords[0]}</h2>" +
                """<img style="height:20vh" src="${GenericImageProvider("problem").provide()}"/>""" +
                "<p>The ${keywords[0]} Industry is really struggling with <strong>${keywords[1]}</strong> and <strong>${keywords[2]}</strong> in recent years.</p>"
    }
}