package util.startingposition.pawn

import board.Coordinate
import piece.DirectionRule
import piece.Piece
import piece.Team
import piece.enum.PieceType
import piece.rule.*
import piece.rule.validator.direction.VerticalForwardValidator
import piece.rule.validator.movequantity.LimitedValidator
import piece.rule.validator.obstacle.VerticalObstacleValidator
import piece.rule.validator.orientation.DiagonalValidator
import piece.rule.validator.orientation.VerticalValidator
import start.StartingPositionGenerator

class PawnInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createPawn(Team.WHITE)
        )
    }

    private fun createPawn(team: Team): Piece{
        return Piece(PieceType.PAWN,
            PawnOrientationRule(
                DiagonalValidator(),
                VerticalValidator(),
                HasEnemyRule(           // Rule chain to be checked if move is diagonal
                    MoveQuantityRule(
                        LimitedValidator(1),
                        EndOfRule()
                    )
                ),
                ObstacleRule(          // Rule chain to be checked if move is vertical
                    listOf(VerticalObstacleValidator(true)),
                    DirectionRule(
                        VerticalForwardValidator(),
                        IsFirstMoveRule(
                            MoveQuantityRule(
                                LimitedValidator(2),
                                EndOfRule()
                            ),
                            MoveQuantityRule(
                                LimitedValidator(1),
                                EndOfRule()
                            )
                        )
                    )
                )
            ),
            team
        )
    }
}
