package cloud.keyforge.common.types

import kotlinx.serialization.Serializable

@Serializable
data class ApiErrorResponse(
    val error: Error
)

@Serializable
data class Error(
    val statusCode: Int,
    val name: String,
    val message: String
)
