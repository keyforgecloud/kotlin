package cloud.keyforge.common.types

data class VerifyKeyResponse(
    val valid: Boolean,
    val keyId: String,
    val ownerId: String,
    val permissions: List<String>,
    val metadata: Map<String, Any>
)
