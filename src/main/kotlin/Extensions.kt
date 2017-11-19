import generators.shuffle

operator fun StringBuilder.plusAssign(increment: String) {
    this.append(increment)
}

fun String.choice(vararg choices: String): String = this + choices.toList().shuffle()[0]