package cloud.keyforge.common.types.requests

data class VerifyKeyRequestBody(
    val apiId: String,
    val token: String
)
