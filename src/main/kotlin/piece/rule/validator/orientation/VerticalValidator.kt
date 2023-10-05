package piece.rule.validator.orientation

import board.Board
import board.Coordinate
import piece.rule.validator.orientation.OrientationValidator

class VerticalValidator: OrientationValidator {
    override fun validateOrientation(board: Board, from: Coordinate, to: Coordinate): Boolean {
        return from.column == to.column
    }
}
