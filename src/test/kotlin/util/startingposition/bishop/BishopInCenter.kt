package util.startingposition.bishop

import board.Coordinate
import piece.Piece
import piece.Team
import piece.enum.PieceType
import piece.rule.EndOfRule
import piece.rule.MoveQuantityRule
import piece.rule.ObstacleRule
import piece.rule.OrientationRule
import piece.rule.validator.movequantity.UnlimitedValidator
import piece.rule.validator.obstacle.DiagonalObstacleValidator
import piece.rule.validator.orientation.DiagonalValidator
import start.StartingPositionGenerator

class BishopInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(Coordinate(3, 3) to createBishop(Team.WHITE))
    }

    private fun createBishop(team: Team): Piece{
        return Piece(PieceType.BISHOP,
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
