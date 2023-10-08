package piece.rule

import game.Move
import piece.rule.validator.orientation.DiagonalValidator
import piece.rule.validator.orientation.VerticalValidator
import result.validation.InvalidResult
import result.validation.ValidationResult

class PawnOrientationRule(
    private val diagonalValidator: DiagonalValidator,
    private val verticalValidator: VerticalValidator,
    private val diagonalNextRule: PieceRule,
    private val verticalNextRule: PieceRule
):PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        if(diagonalValidator.validateOrientation(move.getBoard(), move.getFrom(), move.getTo())){
            return diagonalNextRule.validateMove(move)
        }

        if(verticalValidator.validateOrientation(move.getBoard(), move.getFrom(), move.getTo())){
            return verticalNextRule.validateMove(move)
        }

        return InvalidResult
    }

}
