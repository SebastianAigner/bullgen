package generators
import HTMLString
import SlideGenerator
import provideJobTitle

class HappyTeamSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h1>Our Happy Team: </h1>" +
                "<h3>We have:</h3> <ul>" +
                "<li>${provideJobTitle()}</li>" +
                "<li>${provideJobTitle()}</li>" +
                "<li>${provideJobTitle()}</li>" +
                "<li>${provideJobTitle()}</li>" +
                "<li>${provideJobTitle()}</li></ul>"
    }
}