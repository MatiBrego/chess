package piece.rule.validator.orientation

import board.Board
import board.Coordinate
import piece.rule.validator.orientation.OrientationValidator

class HorizontalValidator: OrientationValidator {
    override fun validateOrientation(board: Board, from: Coordinate, to: Coordinate): Boolean {
        return from.row == to.row
    }
}
