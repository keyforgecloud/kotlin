package cloud.keyforge.common.types.requests

import kotlinx.serialization.Serializable

@Serializable
data class CreateAPIRequestBody(
    val name: String
)
