package util.startingposition.bishop

import board.Coordinate
import piece.Piece
import piece.Team
import piece.rule.EndOfRule
import piece.rule.MoveQuantityRule
import piece.rule.ObstacleRule
import piece.rule.OrientationRule
import piece.rule.validator.movequantity.UnlimitedValidator
import piece.rule.validator.obstacle.DiagonalObstacleValidator
import piece.rule.validator.orientation.DiagonalValidator
import start.StartingPositionGenerator

class BishopInCenterBlocked: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createBishop(Team.BLACK),
            Coordinate(2, 2) to createBishop(Team.WHITE),
            Coordinate(4, 2) to createBishop(Team.WHITE),
            Coordinate(2, 4) to createBishop(Team.WHITE),
            Coordinate(4, 4) to createBishop(Team.WHITE)
        )
    }

    private fun createBishop(team: Team): Piece{
        return Piece("Bishop",
            OrientationRule(
                listOf(
                    DiagonalValidator()
                ),
                MoveQuantityRule(
                    UnlimitedValidator(),
                    ObstacleRule(
                        listOf(DiagonalObstacleValidator()),
                        EndOfRule()
                    )
                )
            )
            ,
            team
        )
    }
}
