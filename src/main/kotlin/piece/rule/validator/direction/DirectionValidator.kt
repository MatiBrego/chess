package piece.rule.validator.direction

import board.Coordinate
import piece.Team
import result.validation.ValidationResult

interface DirectionValidator {
    fun validateDirection(from: Coordinate, to: Coordinate, team: Team): Boolean
}
