package generators
import HTMLString
import SlideGenerator
import providers.provideGrowthChart
import providers.provideBusinessMetric

class ProductGrowthSlideGenerator : SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        return "<h1>Looking into Data</h1>"+provideGrowthChart(3 + (Math.random() * 12).toInt(), provideBusinessMetric())
    }
}