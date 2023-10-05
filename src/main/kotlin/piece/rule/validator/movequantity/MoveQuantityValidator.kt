package piece.rule.validator.movequantity

import board.Board
import board.Coordinate

interface MoveQuantityValidator {
    fun validateMoveQuantity(board: Board, from: Coordinate, to: Coordinate): Boolean
}
