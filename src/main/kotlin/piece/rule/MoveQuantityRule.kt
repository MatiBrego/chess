package piece.rule

import game.Move
import result.validation.InvalidResult
import result.validation.ValidationResult
import piece.rule.validator.movequantity.MoveQuantityValidator

class MoveQuantityRule (
    private val moveQuantityValidator: MoveQuantityValidator,
    private val nextRule: PieceRule
) : PieceRule {

    override fun validateMove(move: Move): ValidationResult {
        if (moveQuantityValidator.validateMoveQuantity(move.getBoard(), move.getFrom(), move.getTo())){
            return nextRule.validateMove(move)
        }
        return InvalidResult
    }
}
