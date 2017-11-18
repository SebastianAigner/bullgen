package providers

import HTMLString

val businessMetricPrePrefixes = arrayOf(
    "Year-to-Year", "Cost of", "Lead-to-client", "Monthly", "Overdue"
)

val businessMetricPrefixes = arrayOf(
    "Net", "Gross", "Qualified", "Average", "Employee"
)

val businessMetrics = arrayOf(
    "User Retention",
    "Customer Acquisition",
    "Social Media Loyalty",
    "Promoter Score",
    "Conversion Rate",
    "Likes",
    "Retweets",
    "Milestones",
    "Commits",
    "Sprints",
    "Positivity"
)

val businessMetricsSuffixes = arrayOf(
    "Margin", "Growth", "Expectation", "Turnover", "Difference"
)

fun provideBusinessMetric(): HTMLString {
    var metric = ""

    if (Math.random() < 0.4) {
        metric += businessMetricPrePrefixes[(Math.random() * businessMetricPrePrefixes.size).toInt()] + " "
    }

    if (Math.random() < 0.4) {
        metric += businessMetricPrefixes[(Math.random() * businessMetricPrefixes.size).toInt()] + " "
    }

    metric += businessMetrics[(Math.random() * businessMetrics.size).toInt()]

    if (Math.random() < 0.3) {
        metric += " " + businessMetricsSuffixes[(Math.random() * businessMetricsSuffixes.size).toInt()]
    }

    return metric
}