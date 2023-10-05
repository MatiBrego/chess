package piece.rule

import game.Move
import piece.rule.result.ValidResult
import piece.rule.result.ValidationResult

class EndOfRule : PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        return ValidResult
    }
}
