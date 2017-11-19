package providers

import generators.shuffle
import HTMLString

fun provideIndustryTrouble(): HTMLString {
    return listOf(
        "Scaling Issues",
        "State-Sponsored Monopolies",
        "Privacy Concerns",
        "Customer Disconnect",
        "Too Many Middle-Men",
        "Strict Regulations",
        "Organically Grown Complexity",
        "Tunnel Vision",
        "Lack of Specialized Employees",
        "Macroeconomic Factors",
        "Upcoming Diesel Restrictions",
        "Global Warming",
        "Political Issues",
        "Widening Gap Between Rich and Poor"
    ).shuffle()[0]
}