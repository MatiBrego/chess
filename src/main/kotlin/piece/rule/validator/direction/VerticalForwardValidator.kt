package piece.rule.validator.direction

import board.Coordinate
import piece.Team

class VerticalForwardValidator: DirectionValidator {
    override fun validateDirection(from: Coordinate, to: Coordinate, team: Team): Boolean {
        return if (team == Team.WHITE) {
            validateWhiteDirection(from, to)
        } else {
            validateBlackDirection(from, to)
        }
    }

    private fun validateWhiteDirection(from: Coordinate, to: Coordinate): Boolean {
        return from.row < to.row
    }

    private fun validateBlackDirection(from: Coordinate, to: Coordinate): Boolean {
        return from.row > to.row
    }

}
