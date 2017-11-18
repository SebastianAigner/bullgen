import HTMLString

val jobPrePrefixes = arrayOf("Chief", "Senior", "Associate", "Junior", "Technical")
val jobPrefixes = arrayOf("Application", "Support", "Full Stack")

val jobTopics = arrayOf("Technology", "Information", "Data Center", "Data Quality", "Information Systems", "Computer",
        "IT", ".NET", "Java", "Front End", "Back End", "Help Desk", "Database", "Network", "Web", "Telecommunications")

val jobSuffixes = arrayOf("Director", "Officer", "Manager", "Specialist", "Engineer", "Architect", "Administrator",
        "Analyst", "Developer", "Coordinator")


fun provideJobTitle(): HTMLString {
    var job = ""

    if (Math.random() < 0.3) {
        job += jobPrePrefixes[(Math.random() * jobPrePrefixes.size).toInt()] + " "
    }

    if (Math.random() < 0.7) {
        job += jobPrefixes[(Math.random() * jobPrefixes.size).toInt()] + " "
    }

    job += jobTopics[(Math.random() * jobTopics.size).toInt()] + " "
    job += jobSuffixes[(Math.random() * jobSuffixes.size).toInt()] + " "

    return job
}