package generators
import HTMLString
import SlideGenerator
import choice
import providers.TweetsProvider


class TwitterSlideGenerator: SlideGenerator {

    override fun generate(keywords: Array<String>): HTMLString {
        val (text, username, hashtags) = TweetsProvider(keywords.first()).provide().first()
        val headline = "".choice("What does Twitter think about this?", "The public opinion", "Online thoughts on the topic")

        return """
            <h2>$headline</h2>
            <blockquote>
            $text
            </blockquote>
            <p>~ $username</p>
            """
    }
}