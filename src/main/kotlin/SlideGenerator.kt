typealias HTMLString = String

interface SlideGenerator {
    fun generate(keywords: Array<String>): HTMLString
}