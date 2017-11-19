package generators
import HTMLString
import SlideGenerator
import provideJobTitle
import providers.FaceImageProvider

class HappyTeamSlideGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {

        return "<h2>Our Happy Team </h2>" + (1..5).map{
                """
                    |<div class=left><div style="width: 150px; height: 150px; background: url('${FaceImageProvider("businessman").provide()}'); background-size: cover"></div></div>
                    |<div class=right>${provideJobTitle()}</div></br>""".trimMargin()}.joinToString("")
//                "<li>${provideJobTitle()}</li>" +
//                "<li>${provideJobTitle()}</li>" +
//                "<li>${provideJobTitle()}</li>" +
//                "<li>${provideJobTitle()}</li></ul>"
    }
}