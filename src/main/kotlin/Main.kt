import io.ktor.client.*
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import okhttp3.internal.wait

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
        // install(Logging)
    }
    val jokesApi: ArtistsApi = ArtistsApi(
        json = Json.Default,
        httpClient = httpClient
    )
    val joke: Result<ArtistSchema> = runCatching { jokesApi.nekosapiArtistsApiArtist(12) }
    joke.onSuccess { println("joke: $it") }
        .onSuccess { println("joke: $it") }
        .onFailure { println("error: $it") }
}

