package piece.rule

import game.Move
import piece.rule.result.InvalidResult
import piece.rule.result.ValidationResult
import piece.rule.validator.movequantity.MoveQuantityValidator

class MoveQuantityRule (
    private val moveQuantityValidator: MoveQuantityValidator,
    private val nextRule: PieceRule
) : PieceRule {

    override fun validateMove(move: Move): ValidationResult {
        if (moveQuantityValidator.validateMoveQuantity(move.getBoard(), move.getFrom(), move.getTo())){
            return nextRule.validateMove(move)
        }
        return InvalidResult("Invalid move quantity for ${move.getPiece().name}")
    }
}
