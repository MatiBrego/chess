package piece.rule.result

data object ValidResult : ValidationResult {
    override fun isValid(): Boolean {
        return true
    }

    override fun isInvalid(): Boolean {
        return false
    }

    override fun getInvalidReason(): String {
        return ""
    }
}
