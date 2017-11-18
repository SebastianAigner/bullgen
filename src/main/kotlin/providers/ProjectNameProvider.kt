package providers

import plusAssign

fun Char.isVowel(): Boolean = "aeiou".contains(this)

var nameForProject = ""
fun getNameForProject(keywords: Array<String>): String {
    if(nameForProject == "") {
        nameForProject = getProjectName(keywords)
    }
    return nameForProject
}

private fun getProjectName(keywords: Array<String>): String {
    val sb = StringBuilder()
    keywords[0].toCharArray().forEach {
        if(Math.random() > 0.1) {
            sb.append(it)
        }

        if(it.isVowel()) {
            if(Math.random() > 0.75) {
                sb.append(it)
            }
        }
    }


    var out = sb.toString()
    if(Math.random() > 0.1) {
        out = sb.toString().replace("ck", "cc")
    }

    var cleanup = StringBuilder()

    for(l in out) {
        if(cleanup.length > 2) {
            val lastTwo = cleanup.takeLast(2)
            if (lastTwo[0] == lastTwo[1]) {
                if (l == lastTwo[0]) {
                    continue
                }
            }
        }
        cleanup += l.toString()
    }

    if(cleanup.length > 8) {
        if(Math.random() > 0.5)
        return edition(cleanup.toString().dropLast((Math.random() * 4).toInt()), keywords[1])
    }

    return edition(cleanup.toString(), keywords[1])
}


fun edition(inn: String, argument: String): String {
    if(Math.random() > 0.7) {
        return "$inn ($argument edition)"
    }
    return inn
}