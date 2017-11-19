package providers

import HTMLString


fun provideCorporateBulletpoint(): HTMLString {
    return listOf(getAdverb(),
            getVerb(),
            getAdjective(),
            getNoun()
    ).joinToString(" ")
}