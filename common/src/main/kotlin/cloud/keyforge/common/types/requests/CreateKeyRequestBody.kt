package cloud.keyforge.common.types.requests

import kotlinx.serialization.json.JsonObject

data class CreateKeyRequestBody(
    val name: String? = null,
    val ownerId: String? = null,
    val permissions: List<String>? = null,
    val metadata: Any? = null,
)
