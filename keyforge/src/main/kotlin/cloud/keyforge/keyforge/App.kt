package cloud.keyforge.keyforge

import com.google.gson.GsonBuilder

fun main() {
    KeyforgeAPI.accountToken = "L4klt6r4TW3zaS213OSGTCii2nCSHUlKwuSZXn8TdtFAen5NmhwYqegW3AaWFnoR"

    KeyforgeAPI.getAPIs(1, 50).results.forEach { api ->
        println(" - Deleting API '${api.name}' (${api.id})")
        KeyforgeAPI.deleteAPI(api.id)
    }

    println("Deleted all APIs\n")

    val apis = KeyforgeAPI.getAPIs().results
    val createdAPI = KeyforgeAPI.createAPI("Keyforge Test API")
    val api = KeyforgeAPI.getAPI(createdAPI.id)

    println("Created API: '${createdAPI.name}' (${createdAPI.id})")
    println("Fetched created API by ID: '${api.name}' (${api.id})")
    println("Exists in old list? ${apis.any { it.id == createdAPI.id }}")
    println("Exists in new list? ${KeyforgeAPI.getAPIs().results.any { it.id == createdAPI.id }}")

    KeyforgeAPI.apiId = createdAPI.id

    val createdKey = KeyforgeAPI.createKey(

        name = "Keyforge Test Key",
        ownerId = "test",
        permissions = listOf("read", "write"),
        metadata = mapOf("key" to "value"),
        apiId = createdAPI.id
    )

    val key = KeyforgeAPI.getKey(createdKey.keyId)
    val verifyKey = KeyforgeAPI.verifyKey(createdKey.token)

    println("\nCreated Key: '${createdKey.keyId}' (${createdKey.token})")
    println("Fetched created Key by ID: '${key.name}' (${key.id})")
    println("Verified Key:")
    println(" - Key ID: ${verifyKey.keyId}")
    println(" - Valid: ${verifyKey.valid}")
    println(" - Owner ID: ${verifyKey.ownerId}")
    println(" - Permissions: ${verifyKey.permissions}")
    println(
        " - Metadata: ${
            GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(verifyKey.metadata)
        }"
    )
}