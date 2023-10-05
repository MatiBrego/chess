package piece.rule

import game.Move
import piece.rule.result.InvalidResult
import piece.rule.result.ValidationResult
import piece.rule.validator.movequantity.MoveQuantityValidator
import piece.rule.validator.obstacle.ObstacleValidator

class ObstacleRule (
    private val obstacleValidators: List<ObstacleValidator>,
    private val nextRule: PieceRule
) : PieceRule {

        // TODO: Check if this is the correct way to do this
        override fun validateMove(move: Move): ValidationResult {
            for (validator in obstacleValidators) {
                if (!validator.validateObstacle(move.getBoard(), move.getFrom(), move.getTo(), move.getPiece().team)) {
                    return InvalidResult("${move.getPiece().name} has an obstacle for that move")
                }
            }
            return nextRule.validateMove(move)
        }
}
