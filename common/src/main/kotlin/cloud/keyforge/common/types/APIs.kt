package cloud.keyforge.common.types

data class API(
    val id: String,
    val ownerId: String,
    val name: String,
    val createdAt: String
)

data class PaginatedResult<T>(
    val pagination: Pagination,
    val results: List<T>
)