/**
* Nekos API
* An open source anime artworks API.
*
* OpenAPI spec version: v3
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package news.apis

import news.models.CharacterSchema
import news.models.PagedCharacterSchema
import news.models.PagedImageSchema

import dev.icerock.moko.network.NetworkResponse
import io.ktor.client.call.body
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer
import io.ktor.client.call.ReceivePipelineException
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.http.ContentDisposition
import io.ktor.http.HttpHeaders
import io.ktor.http.content.TextContent
import io.ktor.http.Headers
import io.ktor.utils.io.core.Input
import io.ktor.http.encodedPath
import io.ktor.http.path

internal interface CharactersApi {

    /**
    * Get a character by ID
    * Returns a character by it&#39;s ID. You&#39;ll get a 404 if the character doesn&#39;t exist.
    * @param id  
    * @return CharacterSchema
    */
    suspend fun nekosapiCharactersApiCharacter(id: kotlin.Int) : CharacterSchema

    /**
    * Get a character by ID
    * Returns a character by it&#39;s ID. You&#39;ll get a 404 if the character doesn&#39;t exist.
    * @param id  
    * @return HttpResponse
    */
    suspend fun nekosapiCharactersApiCharacterResponse(id: kotlin.Int) : NetworkResponse<CharacterSchema>

    /**
    * Get a character&#39;s images
    * Returns a paginated list of a character&#39;s images.
    * @param id  
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return PagedImageSchema
    */
    suspend fun nekosapiCharactersApiCharacterImages(id: kotlin.Int, limit: kotlin.Int? = null, offset: kotlin.Int? = null) : PagedImageSchema

    /**
    * Get a character&#39;s images
    * Returns a paginated list of a character&#39;s images.
    * @param id  
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return HttpResponse
    */
    suspend fun nekosapiCharactersApiCharacterImagesResponse(id: kotlin.Int, limit: kotlin.Int? = null, offset: kotlin.Int? = null) : NetworkResponse<PagedImageSchema>

    /**
    * Get all characters
    * Returns a paginated list of all characters in the API.
    * @param search  (optional)
    * @param age One or more of the character&#39;s (official) ages. (optional)
    * @param gender The character&#39;s gender. (optional)
    * @param species The character&#39;s species. (optional)
    * @param nationality The character&#39;s nationality. (optional)
    * @param occupation Occupations the character officially has/has officially had. (optional)
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return PagedCharacterSchema
    */
    suspend fun nekosapiCharactersApiCharacters(search: kotlin.String? = null, age: kotlin.collections.List<kotlin.Int>? = null, gender: kotlin.String? = null, species: kotlin.String? = null, nationality: kotlin.String? = null, occupation: kotlin.collections.List<kotlin.String>? = null, limit: kotlin.Int? = null, offset: kotlin.Int? = null) : PagedCharacterSchema

    /**
    * Get all characters
    * Returns a paginated list of all characters in the API.
    * @param search  (optional)
    * @param age One or more of the character&#39;s (official) ages. (optional)
    * @param gender The character&#39;s gender. (optional)
    * @param species The character&#39;s species. (optional)
    * @param nationality The character&#39;s nationality. (optional)
    * @param occupation Occupations the character officially has/has officially had. (optional)
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return HttpResponse
    */
    suspend fun nekosapiCharactersApiCharactersResponse(search: kotlin.String? = null, age: kotlin.collections.List<kotlin.Int>? = null, gender: kotlin.String? = null, species: kotlin.String? = null, nationality: kotlin.String? = null, occupation: kotlin.collections.List<kotlin.String>? = null, limit: kotlin.Int? = null, offset: kotlin.Int? = null) : NetworkResponse<PagedCharacterSchema>


    companion object {
        operator fun invoke(basePath: String = "https://api.nekosapi.com", httpClient: HttpClient, json: Json): CharactersApi = CharactersApiImpl(basePath, httpClient, json)
    }
}

internal class CharactersApiImpl(basePath: kotlin.String, httpClient: HttpClient, json: Json): CharactersApi {
    private val _basePath = basePath
    private val _httpClient = httpClient
    private val _json = json

    /**
    * Get a character by ID
    * Returns a character by it&#39;s ID. You&#39;ll get a 404 if the character doesn&#39;t exist.
    * @param id  
    * @return CharacterSchema
    */
    @Suppress("UNCHECKED_CAST")
    override suspend fun nekosapiCharactersApiCharacter(id: kotlin.Int) : CharacterSchema {
        try {
            return nekosapiCharactersApiCharacterResponse(id).body()
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }

    /**
    * Get a character by ID
    * Returns a character by it&#39;s ID. You&#39;ll get a 404 if the character doesn&#39;t exist.
    * @param id  
    * @return HttpResponse
    */
    @Suppress("UNCHECKED_CAST")
    override suspend fun nekosapiCharactersApiCharacterResponse(id: kotlin.Int) : NetworkResponse<CharacterSchema> {
        val builder = HttpRequestBuilder()

        builder.method = HttpMethod.Get
        builder.url {
            takeFrom(_basePath)
            encodedPath = encodedPath.let { startingPath ->
                path("v3/characters/$id")
                return@let startingPath + encodedPath
            }
        }

        with(builder.headers) {
            append("Accept", "application/json")
        }

        val response = _httpClient.request(builder)

        val serializer = CharacterSchema.serializer()

        return NetworkResponse(
            httpResponse = response,
            bodyReader = { _json.decodeFromString(serializer, it.body()) }
        )
    }

    /**
    * Get a character&#39;s images
    * Returns a paginated list of a character&#39;s images.
    * @param id  
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return PagedImageSchema
    */
    @Suppress("UNCHECKED_CAST")
    override suspend fun nekosapiCharactersApiCharacterImages(id: kotlin.Int, limit: kotlin.Int?, offset: kotlin.Int?) : PagedImageSchema {
        try {
            return nekosapiCharactersApiCharacterImagesResponse(id, limit, offset).body()
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }

    /**
    * Get a character&#39;s images
    * Returns a paginated list of a character&#39;s images.
    * @param id  
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return HttpResponse
    */
    @Suppress("UNCHECKED_CAST")
    override suspend fun nekosapiCharactersApiCharacterImagesResponse(id: kotlin.Int, limit: kotlin.Int?, offset: kotlin.Int?) : NetworkResponse<PagedImageSchema> {
        val builder = HttpRequestBuilder()

        builder.method = HttpMethod.Get
        builder.url {
            takeFrom(_basePath)
            encodedPath = encodedPath.let { startingPath ->
                path("v3/characters/$id/images")
                return@let startingPath + encodedPath
            }
            @Suppress("UNNECESSARY_SAFE_CALL")
            with(parameters) {
                limit?.let { append("limit", it.toString()) }
                offset?.let { append("offset", it.toString()) }
            }
        }

        with(builder.headers) {
            append("Accept", "application/json")
        }

        val response = _httpClient.request(builder)

        val serializer = PagedImageSchema.serializer()

        return NetworkResponse(
            httpResponse = response,
            bodyReader = { _json.decodeFromString(serializer, it.body()) }
        )
    }

    /**
    * Get all characters
    * Returns a paginated list of all characters in the API.
    * @param search  (optional)
    * @param age One or more of the character&#39;s (official) ages. (optional)
    * @param gender The character&#39;s gender. (optional)
    * @param species The character&#39;s species. (optional)
    * @param nationality The character&#39;s nationality. (optional)
    * @param occupation Occupations the character officially has/has officially had. (optional)
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return PagedCharacterSchema
    */
    @Suppress("UNCHECKED_CAST")
    override suspend fun nekosapiCharactersApiCharacters(search: kotlin.String?, age: kotlin.collections.List<kotlin.Int>?, gender: kotlin.String?, species: kotlin.String?, nationality: kotlin.String?, occupation: kotlin.collections.List<kotlin.String>?, limit: kotlin.Int?, offset: kotlin.Int?) : PagedCharacterSchema {
        try {
            return nekosapiCharactersApiCharactersResponse(search, age, gender, species, nationality, occupation, limit, offset).body()
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }

    /**
    * Get all characters
    * Returns a paginated list of all characters in the API.
    * @param search  (optional)
    * @param age One or more of the character&#39;s (official) ages. (optional)
    * @param gender The character&#39;s gender. (optional)
    * @param species The character&#39;s species. (optional)
    * @param nationality The character&#39;s nationality. (optional)
    * @param occupation Occupations the character officially has/has officially had. (optional)
    * @param limit  (optional, default to 100)
    * @param offset  (optional, default to 0)
    * @return HttpResponse
    */
    @Suppress("UNCHECKED_CAST")
    override suspend fun nekosapiCharactersApiCharactersResponse(search: kotlin.String?, age: kotlin.collections.List<kotlin.Int>?, gender: kotlin.String?, species: kotlin.String?, nationality: kotlin.String?, occupation: kotlin.collections.List<kotlin.String>?, limit: kotlin.Int?, offset: kotlin.Int?) : NetworkResponse<PagedCharacterSchema> {
        val builder = HttpRequestBuilder()

        builder.method = HttpMethod.Get
        builder.url {
            takeFrom(_basePath)
            encodedPath = encodedPath.let { startingPath ->
                path("v3/characters")
                return@let startingPath + encodedPath
            }
            @Suppress("UNNECESSARY_SAFE_CALL")
            with(parameters) {
                search?.let { append("search", it.toString()) }
                age?.let { appendAll("age", it.map { it.toString() }) }
                gender?.let { append("gender", it.toString()) }
                species?.let { append("species", it.toString()) }
                nationality?.let { append("nationality", it.toString()) }
                occupation?.let { appendAll("occupation", it.map { it.toString() }) }
                limit?.let { append("limit", it.toString()) }
                offset?.let { append("offset", it.toString()) }
            }
        }

        with(builder.headers) {
            append("Accept", "application/json")
        }

        val response = _httpClient.request(builder)

        val serializer = PagedCharacterSchema.serializer()

        return NetworkResponse(
            httpResponse = response,
            bodyReader = { _json.decodeFromString(serializer, it.body()) }
        )
    }

}