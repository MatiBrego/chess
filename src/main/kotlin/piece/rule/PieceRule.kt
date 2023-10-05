package piece.rule

import game.Move
import piece.rule.result.ValidationResult

interface PieceRule {
    fun validateMove(move: Move): ValidationResult
}
