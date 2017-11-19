package generators

import HTMLString
import SlideGenerator
import org.json.JSONObject
import providers.GenericImageProvider
import providers.provideIndustrySector
import providers.provideIndustryTrouble

class ProblemIntroSlideGenerator : SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        return "<h2>Disrupting ${keywords[0]}</h2>" +
                """<img style="height:40vh" src="${GenericImageProvider(keywords[0]).provide()}">"""
    }
}