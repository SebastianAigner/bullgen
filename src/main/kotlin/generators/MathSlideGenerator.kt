package generators

import HTMLString
import SlideGenerator
import providers.provideFormula

class MathSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h1>The Basic Model</h1>" +
                "<small>${provideFormula()}</small>" +
                "<p>under the assumption that</p>" +
                "<small>${provideFormula()}</small>"
    }
}