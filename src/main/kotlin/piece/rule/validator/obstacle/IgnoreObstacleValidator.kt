package piece.rule.validator.obstacle

import board.Board
import board.Coordinate
import piece.Team

class IgnoreObstacleValidator : ObstacleValidator{
    override fun validateObstacle(board: Board, from: Coordinate, to: Coordinate, team: Team): Boolean {
        return true
    }
}
