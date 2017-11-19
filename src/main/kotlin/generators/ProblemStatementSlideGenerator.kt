package generators

import HTMLString
import SlideGenerator
import org.json.JSONObject
import providers.provideIndustrySector
import providers.provideIndustryTrouble

class ProblemStatementSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        val industry = provideIndustrySector()
        val trouble1 = provideIndustryTrouble()
        val trouble2 = provideIndustryTrouble()


        return "<h1>Disrupting $industry</h1>" +
                "<p>The $industry Industry is really struggling with <strong>$trouble1</strong> and <strong>$trouble2</strong> in recent years.</p>"
    }
}