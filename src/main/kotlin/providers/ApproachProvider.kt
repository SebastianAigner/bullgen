package providers

import generators.shuffle

fun getApproach(): String {
    val approaches = mutableListOf(
            "Forecasting",
            "Business Process Facilitation",
            "Formal Verification",
            "Low Latency Systems",
            "Ensured Chain of Responsibility",
            "Flat Hierarchies",
            "Chained Processes",
            "Competence Centers",
            "Taskforces",
            "IT Value Innovations",
            "Service Cockpits",
            "Sleep Deprivation™",
            "Coworking",
            "Data Mining",
            "Diversity Outreach Programs",
            "Kernel Extensions",
            "Low Level Virtual Machines",
            "Hand-Optimized Assembler",
            "Continous Cloud",
            "Fog Computing",
            "Parametrised Reachability",
            "Microtransactions",
            "Full-Stack-Full-Time-Approach",
            "You-Driven-Development",
            "Need Driven Solutions",
            "Weekend Projects",
            "Solved Problems",
            "Workflow Recovery",
            "Context Prediction",
            "Privacy-Aware Smart Grids",
            "Flow Data Collection",
            "Nonsmooth Optimzation",
            "Quality Assurance Measures",
            "Convex Relaxation Methods",
            "Symbolic Execution",
            "Copy Protection and DRM",
            "Space Age Technology",
            "Recommender Systems",
            "Blockchain Technologies",
            "Digital Transformation",
            "Chatbots",
            "Unconditional Basic Income",
            "Venture Capital",
            "Design Thinking",
            "Ideation Phases",
            "Disrupting the Industry"
    )


    val greekLetters = listOf(
            "Alphas",
            "Betas",
            "Gammas",
            "Deltas",
            "Epsilons",
            "Zetas",
            "Etas",
            "Iotas",
            "Phis",
            "Rhos",
            "Psis"
    )

    approaches.add(greekLetters.shuffle().get(0))
    return approaches.shuffle().get(0)
}