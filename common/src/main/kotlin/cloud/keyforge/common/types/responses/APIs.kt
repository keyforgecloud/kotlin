package cloud.keyforge.common.types.responses

import kotlinx.serialization.Serializable

@Serializable
data class API(
    val id: String,
    val ownerId: String,
    val name: String,
    val createdAt: String
)

@Serializable
data class MessageResponse(
    val message: String
)
