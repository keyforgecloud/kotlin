package cloud.keyforge.core

import cloud.keyforge.common.types.API
import cloud.keyforge.common.Constants.KEYFORGE_API_URL
import cloud.keyforge.common.KeyforgeClient
import cloud.keyforge.common.types.PaginatedResult
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object KeyforgeAPI : KeyforgeClient() {

    private fun getRequest(
        requestMethod: String,
        url: String,
        bearerToken: String? = null,
        body: Any? = null,
        params: Map<String, String>? = null
    ): HttpRequest? {
        val request = HttpRequest.newBuilder()
            .uri(URI("$KEYFORGE_API_URL$url"))
            .header("Content-Type", "application/json")

        if (bearerToken != null) request.header("Authorization", "Bearer $bearerToken")
        if (params != null) request.uri(
            URI(
                "$KEYFORGE_API_URL$url?${
                    params.map { "${it.key}=${it.value}" }.joinToString("&")
                }"
            )
        )

        when (requestMethod.lowercase()) {
            "get" -> request.GET()
            "post" -> request.POST(
                HttpRequest.BodyPublishers.ofString(
                    Gson().toJson(body)
                )
            )
            "delete" -> request.DELETE()
            else -> throw NullPointerException("Invalid request method")
        }

        return request.build()
    }

    private inline fun <reified T> request(
        method: String,
        endpoint: String,
        body: Any? = null,
        params: Map<String, String>? = null,
        accountToken: String? = null,
    ): T {
        val client = HttpClient.newHttpClient()
        val bearerToken = accountToken ?: this.accountToken
        ?: throw NullPointerException("No account cloud.keyforge.common.types.API key provided")

        val request = getRequest(
            method,
            endpoint,
            bearerToken,
            body,
            params
        )

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        if (response.statusCode() != 200) {
            throw NullPointerException("Request failed with status code ${response.statusCode()} and body ${response.body()}")
        }

        return Gson().fromJson(response.body(), T::class.java)
    }

    fun getAPIs(page: Int = 1, pageSize: Int = 10, accountToken: String? = null): PaginatedResult<API> {
        val params = mapOf(
            "page" to page.toString(),
            "pageSize" to pageSize.toString()
        )

        return request("GET", "apis", params = params, accountToken = accountToken)
    }

    fun getAPI(apiId: String? = null, accountToken: String? = null): API {
        val finalId = apiId ?: this.apiId ?: NullPointerException("No API ID provided")

        return request("GET", "apis/$finalId", accountToken = accountToken)
    }

    fun createAPI(name: String): API {
        val body = mapOf(
            "name" to name
        )

        return request<API>("POST", "apis", body)
    }
}