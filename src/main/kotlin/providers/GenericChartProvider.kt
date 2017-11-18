package providers

import HTMLString

fun provideChart(chartType: String, chartConfig: HTMLString): HTMLString {
    return """<canvas data-chart="$chartType"><!-- $chartConfig --></canvas>"""
}