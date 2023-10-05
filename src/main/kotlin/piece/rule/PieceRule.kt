package piece.rule

import game.Move
import result.validation.ValidationResult

interface PieceRule {
    fun validateMove(move: Move): ValidationResult
}
