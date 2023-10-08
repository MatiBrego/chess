package piece.rule

import game.Move
import result.validation.ValidationResult

class IsFirstMoveRule(
    private val isFirstNextRule: PieceRule,
    private val isNotFirstNextRule: PieceRule
):PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        if (move.getHistory().isEmpty()) {
            return isFirstNextRule.validateMove(move)
        }
        else {
            return isNotFirstNextRule.validateMove(move)
        }
    }

}
