package cloud.keyforge.common.types

data class GetAPIsResponse(
    val pagination: Pagination,
    val results: List<API>
)

data class Pagination(
    val page: Int,
    val pageSize: Int
)
