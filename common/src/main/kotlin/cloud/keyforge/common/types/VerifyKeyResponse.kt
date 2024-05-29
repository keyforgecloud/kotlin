package cloud.keyforge.common.types

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class VerifyKeyResponse(
    val valid: Boolean,
    val keyId: String,
    val ownerId: String,
    val permissions: List<String>,
    val metadata: JsonObject?
)
