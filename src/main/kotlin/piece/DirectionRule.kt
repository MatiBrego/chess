package piece

import game.Move
import piece.rule.PieceRule
import piece.rule.validator.direction.DirectionValidator
import result.validation.InvalidResult
import result.validation.ValidationResult

class DirectionRule(
    private val directionValidator: DirectionValidator,
    private val nextRule: PieceRule
): PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        if (directionValidator.validateDirection(move.getFrom(), move.getTo(), move.getPiece().team)) {
            return nextRule.validateMove(move)
        }

        return InvalidResult
    }
}
