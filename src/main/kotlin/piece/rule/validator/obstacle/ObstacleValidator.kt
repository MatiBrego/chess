package piece.rule.validator.obstacle

import board.Board
import board.Coordinate
import piece.Team

interface ObstacleValidator {
    fun validateObstacle(board: Board, from: Coordinate, to: Coordinate, team: Team): Boolean
}
