package piece.rule.validator.movequantity

import board.Board
import board.Coordinate

class UnlimitedValidator: MoveQuantityValidator {
    override fun validateMoveQuantity(board: Board, from: Coordinate, to: Coordinate): Boolean {
        return true
    }
}
