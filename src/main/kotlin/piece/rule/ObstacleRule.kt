package piece.rule

import game.Move
import result.validation.InvalidResult
import result.validation.ValidationResult
import piece.rule.validator.obstacle.ObstacleValidator

class ObstacleRule (
    private val obstacleValidators: List<ObstacleValidator>,
    private val nextRule: PieceRule
) : PieceRule {

        // TODO: Check if this is the correct way to do this
        override fun validateMove(move: Move): ValidationResult {
            for (validator in obstacleValidators) {
                if (!validator.validateObstacle(move.getBoard(), move.getFrom(), move.getTo(), move.getPiece().team)) {
                    return InvalidResult
                }
            }
            return nextRule.validateMove(move)
        }
}
