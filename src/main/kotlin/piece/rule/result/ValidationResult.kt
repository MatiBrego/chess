package piece.rule.result

sealed interface ValidationResult {
    fun isValid(): Boolean
    fun isInvalid(): Boolean
    fun getInvalidReason(): String
}
