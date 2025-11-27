package mostafagad.learncmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform