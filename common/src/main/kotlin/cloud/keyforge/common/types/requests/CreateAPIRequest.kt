package cloud.keyforge.common.types.requests

import kotlinx.serialization.Serializable

@Serializable
data class CreateAPIRequest(
    val name: String
)
