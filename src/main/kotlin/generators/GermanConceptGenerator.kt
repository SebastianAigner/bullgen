package generators
import SlideGenerator
import HTMLString
import plusAssign

class GermanConceptGenerator: SlideGenerator {
    override fun generate(keywords: Array<String>): HTMLString {
        val concepts = listOf<Pair<String, String>>(
                Pair("Weltschmerz", "mental depression or apathy caused by comparison of the actual state of the world with an ideal state"),
                Pair("Ansatz", "an initial estimate of the solution to a mathematical or technical problem that is used to guide work to a more precise answer"),
                Pair("Bildungsroman", "a novel about the moral and psychological growth of the main character"),
                Pair("Gedankenexperiment", "A Gedankenexperiment considers some hypothesis, theory, or principle for the purpose of thinking through its consequences. Given the structure of the experiment, it may not be possible to perform it, and even if it could be performed, there need not be an intention to perform it."),
                Pair("Kitsch", "Kitsch is art or other objects that appeal to popular rather than high art tastes. Such objects are sometimes appreciated in a knowingly ironic or humorous way."),
                Pair("Verboten","A loanword with connotations of strictness or authoritarianism, derived from perceptions of Germany: Prohibited by dictate"),
                Pair("Kaffeeklatsch", "afternoon meeting where people chitchat while drinking coffee or tea and having cake."),
                Pair("Spiel", "an attempt to present and explain a point in a way that the presenter has done often before, usually to sell something. A voluble line of often extravagant talk, \"pitch\""),
                Pair("Realpolitik", "usually implies the way politics really works, i.e. via the influence of power and money, rather than a principled approach that the public might expect to be aligned with a party's or nation's values, or rather than a political party's given interpretation."),
                Pair("Fingerspitzengefühl", "The ability of certain military commanders to understand and master a situation in detail thanks to intuition and a capability that allows having all relevant tactical information available in the mind, presumably in the form of a mental map."),
                Pair("Weltanschauung", "a comprehensive view or personal philosophy of human life and the universe")
        )
        val (concept, conceptDefinition) = concepts.shuffle()[0]
        return """
            <h2>The German concept of $concept</h2>
            <blockquote>$conceptDefinition</blockquote>
            """
    }
}