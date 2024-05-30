package cloud.keyforge.common.types.responses

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class VerifiedKeyResponse(
    val valid: Boolean,
    val keyId: String,
    val ownerId: String,
    val permissions: List<String>,
    val metadata: JsonObject
)