package piece.rule.validator.movequantity

import board.Board
import board.Coordinate

class LimitedValidator(
    private val maxMoveQuantity: Int
): MoveQuantityValidator {
    // TODO: Check if this is right
    override fun validateMoveQuantity(board: Board, from: Coordinate, to: Coordinate): Boolean {
        // Orthogonal Check
        val horizontalDistance = kotlin.math.abs(from.column - to.column)
        val verticalDistance = kotlin.math.abs(from.row - to.row)

        return horizontalDistance <= maxMoveQuantity && verticalDistance <= maxMoveQuantity
    }

}
