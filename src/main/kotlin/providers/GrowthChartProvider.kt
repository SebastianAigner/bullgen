package providers

import HTMLString
import providers.provideChart

fun provideGrowthChart(nMonths: Int, yLabel: String): HTMLString {
    val months = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

    val startMonth = (Math.random() * 12).toInt()

    val labels = (startMonth..(startMonth + nMonths)).map {months[it % 12]}

    val scaling = Math.pow(10.0, Math.random() * 10)

    val values = (0..nMonths).map {scaling * (0.3 + 0.3 * (it/nMonths) + 0.2 * Math.random())}

    return provideChart("line","""{
        "data": {
            "labels": ["${labels.joinToString("\", \"")}"],
            "datasets": [
                {
                    "data": [${values.joinToString(",")}],
                    "label": "$yLabel",
                    "backgroundColor": "hsla(${(Math.random() * 270).toInt()}, 50%, 30%, 0.7)"
                }
            ]
        },
        "options": { "responsive": "true" }
    }""")
}