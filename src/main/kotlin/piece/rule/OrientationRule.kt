package piece.rule

import game.Move
import piece.rule.result.InvalidResult
import piece.rule.result.ValidationResult
import piece.rule.validator.orientation.OrientationValidator

class OrientationRule(
    private val orientationValidators: List<OrientationValidator>,
    private val nextRule: PieceRule
) : PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        for (validator in orientationValidators) {
            // Check if the move is valid for the given orientation
            if (validator.validateOrientation(move.getBoard(), move.getFrom(), move.getTo())) {
                // If it is, check if the next rule is valid
                return nextRule.validateMove(move)
            }
        }
        // If none of the orientations are valid, return invalid result
        return InvalidResult("Invalid move orientation for ${move.getPiece().name}")
    }
}
