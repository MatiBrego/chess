package piece.rule.validator.movequantity

import board.Board
import board.Coordinate

class LimitedValidator(
    private val maxMoveQuantity: Int
): MoveQuantityValidator {
    // TODO: Check if this is right
    override fun validateMoveQuantity(board: Board, from: Coordinate, to: Coordinate): Boolean {
        // Orthogonal Check
        val horizontalDistance = kotlin.math.abs(from.row - to.row)
        val verticalDistance = kotlin.math.abs(from.column - to.column)

        if (horizontalDistance < maxMoveQuantity || verticalDistance < maxMoveQuantity) {
            return true
        }

        // Diagonal Check
        if (horizontalDistance == verticalDistance) {
            return true
        }

        return false
    }

}
