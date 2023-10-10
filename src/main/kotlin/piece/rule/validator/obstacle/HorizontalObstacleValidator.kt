package piece.rule.validator.obstacle

import board.Board
import board.Coordinate
import piece.Team

class HorizontalObstacleValidator: ObstacleValidator {

    override fun validateObstacle(board: Board, from: Coordinate, to: Coordinate, team: Team): Boolean {
        // Check if move is not horizontal
        if(from.row != to.row){
            return true
        }

        var currentCoordinate =
            if (from.column < to.column){
                Coordinate(from.row, from.column + 1)
            }else {
                Coordinate(from.row, from.column - 1)
            }

        while (currentCoordinate.column != to.column){
            if (board.getPiece(currentCoordinate) != null){
                return false
            }

            currentCoordinate =
                if (currentCoordinate.column < to.column){
                    Coordinate(currentCoordinate.row, currentCoordinate.column + 1)
                }else {
                    Coordinate(currentCoordinate.row, currentCoordinate.column - 1)
                }
        }

        return true
    }
}
