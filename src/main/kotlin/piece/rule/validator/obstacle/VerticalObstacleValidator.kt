package piece.rule.validator.obstacle

import board.Board
import board.Coordinate
import piece.Team

class VerticalObstacleValidator(
    private val isInclusive: Boolean = false
): ObstacleValidator {

    override fun validateObstacle(board: Board, from: Coordinate, to: Coordinate, team: Team): Boolean {
        // Check if move is not vertical
        if(from.column != to.column){
            return true
        }

        var currentCoordinate = from

        while (currentCoordinate.row != to.row){
            currentCoordinate =
                if (currentCoordinate.row < to.row){
                    Coordinate(currentCoordinate.row + 1, currentCoordinate.column)
                }else {
                    Coordinate(currentCoordinate.row - 1, currentCoordinate.column)
                }
            if (board.getPiece(currentCoordinate) != null){
                return false
            }
        }

        return !(isInclusive && board.getPiece(to) != null) // If is inclusive is set to true, check if the "to" coordinate is occupied
    }
}
