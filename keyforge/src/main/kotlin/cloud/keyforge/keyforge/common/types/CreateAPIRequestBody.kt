package cloud.keyforge.common.types

import kotlinx.serialization.Serializable

@Serializable
data class CreateAPIRequestBody(
    val name: String
)
