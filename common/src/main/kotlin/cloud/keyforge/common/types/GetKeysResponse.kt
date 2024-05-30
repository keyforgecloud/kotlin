package cloud.keyforge.common.types

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class Key(
    val id: String,
    val name: String,
    val enabled: Boolean,
    val ownerId: String,
    val apiOwnerId: String,
    val apiId: String,
    val permissions: List<String>,
    val metadata: JsonObject,
    val lastUsed: String?,
    val createdAt: String
)
