package piece.rule.validator.orientation

import board.Board
import board.Coordinate
import kotlin.math.abs

class DiagonalValidator: OrientationValidator {

    override fun validateOrientation(board: Board, from: Coordinate, to: Coordinate): Boolean {
        return abs(from.row - to.row) == abs(from.column - to.column)
    }
}
