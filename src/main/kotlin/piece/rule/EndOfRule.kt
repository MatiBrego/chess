package piece.rule

import game.Move
import result.validation.ValidResult
import result.validation.ValidationResult

class EndOfRule : PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        return ValidResult
    }
}
