package generators
import HTMLString
import SlideGenerator
import providers.provideGrowthChart
import providers.provideBusinessMetric

class ProductGrowthSlideGenerator : SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        return provideGrowthChart(3 + (Math.random() * 12).toInt(), provideBusinessMetric())
    }
}