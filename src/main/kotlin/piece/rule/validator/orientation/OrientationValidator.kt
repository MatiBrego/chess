package piece.rule.validator.orientation

import board.Board
import board.Coordinate

interface OrientationValidator {
    fun validateOrientation(board: Board, from: Coordinate, to: Coordinate): Boolean
}
