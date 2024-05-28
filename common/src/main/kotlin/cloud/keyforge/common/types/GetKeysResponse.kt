package cloud.keyforge.common.types

data class GetKeysResponse(
    val pagination: Pagination,
    val results: List<Key>
)

data class Key(
    val id: String,
    val name: String,
    val enabled: Boolean,
    val ownerId: String,
    val apiOwnerId: String,
    val apiId: String,
    val permissions: List<String>,
    val meta: Map<String, Any>,
    val lastUsed: String,
    val createdAt: String
)
