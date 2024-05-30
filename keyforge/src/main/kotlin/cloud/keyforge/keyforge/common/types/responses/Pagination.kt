package cloud.keyforge.common.types.responses

import kotlinx.serialization.Serializable

@Serializable
data class PaginatedResult<T>(
    val pagination: Pagination,
    val results: List<T>
)

@Serializable
data class Pagination(
    val page: Int,
    val pageSize: Int
)