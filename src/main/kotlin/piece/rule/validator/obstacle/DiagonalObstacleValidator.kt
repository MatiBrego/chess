package piece.rule.validator.obstacle

import board.Board
import board.Coordinate
import piece.Team
import kotlin.math.abs

class DiagonalObstacleValidator: ObstacleValidator {
    override fun validateObstacle(board: Board, from: Coordinate, to: Coordinate, team: Team): Boolean {
        // Check if move is not diagonal
        if(abs(from.row - to.row) != abs(from.column - to.column)){
            return true
        }

        var currentCoordinate = from

        while (currentCoordinate.row != to.row && currentCoordinate.column != to.column){
            currentCoordinate =
                if (currentCoordinate.row < to.row && currentCoordinate.column < to.column){
                    Coordinate(currentCoordinate.row + 1, currentCoordinate.column + 1)
                }else if (currentCoordinate.row < to.row){
                    Coordinate(currentCoordinate.row + 1, currentCoordinate.column - 1)
                }else if (currentCoordinate.column < to.column){
                    Coordinate(currentCoordinate.row - 1, currentCoordinate.column + 1)
                }else {
                    Coordinate(currentCoordinate.row - 1, currentCoordinate.column - 1)
                }
            if (board.getPiece(currentCoordinate) != null){
                return false
            }
        }

        return true
    }
}
