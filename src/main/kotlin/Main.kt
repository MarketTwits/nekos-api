import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import news.apis.ImagesApi
import news.models.ImageSchema
import news.models.PagedCharacterSchema
import news.models.PagedImageSchema
import news.models.PagedTagSchema

fun main(args: Array<String>) {
    runBlocking {
        val result = async { onRandomJokePressed() }
        // Do other work if needed

        // Wait for the result of the network request
        val joke = result.await()

        // Process the result
        println(joke)
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
    val jokesApi: ImagesApi = ImagesApi(
        json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        },
        httpClient = httpClient
    )
    val joke: Result<Unit> = runCatching { jokesApi.nekosapiImagesApiImageReport(2) }
    joke.onSuccess { println("joke: $it") }
        .onSuccess { println("joke: $it") }
        .onFailure { println("error: ${it.message}") }
}
class CustomHttpLogger : Logger {
    override fun log(message: String) {
       println(message)
    }
}

