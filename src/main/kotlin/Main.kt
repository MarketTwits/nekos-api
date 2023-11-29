import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import news.apis.ImagesApi

fun main(args: Array<String>) {
    runBlocking {
        val result = async { onRandomJokePressed() }
        val neko = result.await()
        println(neko)
    }

}
suspend fun onRandomJokePressed() {
    println("start")
    val httpClient: HttpClient = HttpClient {
        install(Logging) {
            logger = CustomHttpLogger()
            level = LogLevel.INFO
        }
    }
    val nekoApi: ImagesApi = ImagesApi(
        json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        },
        httpClient = httpClient
    )
    val joke: Result<Unit> = runCatching { nekoApi.nekosapiImagesApiRandomImages(limit = 1) }
    joke.onSuccess { println("joke: $it") }
        .onSuccess { println("joke: $it") }
        .onFailure { println("error: ${it.message}") }
}

class CustomHttpLogger : Logger {
    override fun log(message: String) {
       println(message)
    }
}

