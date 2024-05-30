package cloud.keyforge.common.types

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class CreateKeyResponse(
    val keyId: String,
    val token: String
)

@Serializable
data class CreateKeyRequestBody(
    val ownerId: String?,
    val name: String?,
    val permissions: List<String>?,
    val metadata: JsonObject?
)
