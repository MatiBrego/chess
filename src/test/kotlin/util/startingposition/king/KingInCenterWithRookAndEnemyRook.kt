package util.startingposition.king

import board.Coordinate
import piece.Piece
import piece.Team
import piece.enum.PieceType
import piece.rule.EndOfRule
import piece.rule.MoveQuantityRule
import piece.rule.ObstacleRule
import piece.rule.OrientationRule
import piece.rule.validator.movequantity.LimitedValidator
import piece.rule.validator.movequantity.UnlimitedValidator
import piece.rule.validator.obstacle.DiagonalObstacleValidator
import piece.rule.validator.obstacle.HorizontalObstacleValidator
import piece.rule.validator.obstacle.VerticalObstacleValidator
import piece.rule.validator.orientation.DiagonalValidator
import piece.rule.validator.orientation.HorizontalValidator
import piece.rule.validator.orientation.VerticalValidator
import start.StartingPositionGenerator

class KingInCenterWithRookAndEnemyRook: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createKing(Team.WHITE),
            Coordinate(4, 3) to createRook(Team.WHITE),
            Coordinate(5, 3) to createRook(Team.BLACK)
        )
    }

    private fun createRook(team: Team): Piece{
        return Piece(
            PieceType.ROOK,
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

    private fun createKing(team: Team): Piece{
        return Piece(PieceType.KING,
            OrientationRule(
                listOf(
                    HorizontalValidator(),
                    VerticalValidator(),
                    DiagonalValidator()
                ),
                MoveQuantityRule(
                    LimitedValidator(1),
                    ObstacleRule(
                        listOf(HorizontalObstacleValidator(), VerticalObstacleValidator(), DiagonalObstacleValidator()),
                        EndOfRule())))
            ,
            team
        )
    }
}
