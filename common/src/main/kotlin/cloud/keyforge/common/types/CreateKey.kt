package cloud.keyforge.common.types

data class CreateKeyResponse(
    val keyId: String,
    val token: String
)

data class CreateKeyRequestBody(
    val ownerId: String?,
    val name: String?,
    val permissions: List<String>?,
    val metadata: Map<String, Any>?
)
