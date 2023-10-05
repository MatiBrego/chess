package piece.rule.result

data class InvalidResult(
    val reason: String
): ValidationResult {
    override fun isValid(): Boolean {
        return false
    }

    override fun isInvalid(): Boolean {
        return true
    }

    override fun getInvalidReason(): String {
        return reason
    }
}
