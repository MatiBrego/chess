package util.startingposition.rook

import board.Coordinate
import piece.Piece
import piece.Team
import piece.rule.EndOfRule
import piece.rule.MoveQuantityRule
import piece.rule.ObstacleRule
import piece.rule.OrientationRule
import piece.rule.validator.movequantity.UnlimitedValidator
import piece.rule.validator.obstacle.HorizontalObstacleValidator
import piece.rule.validator.obstacle.VerticalObstacleValidator
import piece.rule.validator.orientation.HorizontalValidator
import piece.rule.validator.orientation.VerticalValidator
import start.StartingPositionGenerator

class RookInCenterBlocked: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createRook(Team.WHITE),
            Coordinate(2, 3) to createRook(Team.BLACK),
            Coordinate(4, 3) to createRook(Team.BLACK),
            Coordinate(3, 2) to createRook(Team.BLACK),
            Coordinate(3, 4) to createRook(Team.BLACK)
        )

    }

    private fun createRook(team: Team): Piece{
        return Piece("Rook",
            OrientationRule(
                listOf(
                    HorizontalValidator(),
                    VerticalValidator()
                ),
                MoveQuantityRule(
                    UnlimitedValidator(),
                    ObstacleRule(
                        listOf(HorizontalObstacleValidator(), VerticalObstacleValidator()),
                        EndOfRule()
                    )
                )
            )
            ,
            team
        )
    }
}
