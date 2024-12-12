package art.shittim

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform