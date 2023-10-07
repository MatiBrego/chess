package piece.rule.validator.orientation

import board.Board
import board.Coordinate

class LValidator: OrientationValidator {
    override fun validateOrientation(board: Board, from: Coordinate, to: Coordinate): Boolean {
        return  (from.row == to.row + 1 && from.column == to.column + 2) ||
                (from.row == to.row + 2 && from.column == to.column + 1) ||
                (from.row == to.row + 1 && from.column == to.column - 2) ||
                (from.row == to.row + 2 && from.column == to.column - 1) ||
                (from.row == to.row - 1 && from.column == to.column + 2) ||
                (from.row == to.row - 2 && from.column == to.column + 1) ||
                (from.row == to.row - 1 && from.column == to.column - 2) ||
                (from.row == to.row - 2 && from.column == to.column - 1)
    }
}
