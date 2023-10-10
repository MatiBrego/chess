package start

import board.Coordinate
import piece.DirectionRule
import piece.Piece
import piece.Team
import piece.enum.PieceType
import piece.rule.*
import piece.rule.validator.direction.VerticalForwardValidator
import piece.rule.validator.movequantity.LimitedValidator
import piece.rule.validator.movequantity.UnlimitedValidator
import piece.rule.validator.obstacle.DiagonalObstacleValidator
import piece.rule.validator.obstacle.HorizontalObstacleValidator
import piece.rule.validator.obstacle.VerticalObstacleValidator
import piece.rule.validator.orientation.DiagonalValidator
import piece.rule.validator.orientation.HorizontalValidator
import piece.rule.validator.orientation.LValidator
import piece.rule.validator.orientation.VerticalValidator

class NormalStartingPosition: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        val map:MutableMap<Coordinate, Piece>  = mutableMapOf()

        // Pawn
        for(i in 0..7){
            map[Coordinate(1, i)] = createPawn(Team.WHITE)
            map[Coordinate(6, i)] = createPawn(Team.BLACK)
        }

        // Rook
        map[Coordinate(0, 0)] = createRook(Team.WHITE)
        map[Coordinate(0, 7)] = createRook(Team.WHITE)
        map[Coordinate(7, 0)] = createRook(Team.BLACK)
        map[Coordinate(7, 7)] = createRook(Team.BLACK)

        // Knight
        map[Coordinate(0, 1)] = createKnight(Team.WHITE)
        map[Coordinate(0, 6)] = createKnight(Team.WHITE)
        map[Coordinate(7, 1)] = createKnight(Team.BLACK)
        map[Coordinate(7, 6)] = createKnight(Team.BLACK)

        // Bishop
        map[Coordinate(0, 2)] = createBishop(Team.WHITE)
        map[Coordinate(0, 5)] = createBishop(Team.WHITE)
        map[Coordinate(7, 2)] = createBishop(Team.BLACK)
        map[Coordinate(7, 5)] = createBishop(Team.BLACK)

        // Queen
        map[Coordinate(0, 3)] = createQueen(Team.WHITE)
        map[Coordinate(7, 3)] = createQueen(Team.BLACK)

        // King
        map[Coordinate(0, 4)] = createKing(Team.WHITE)
        map[Coordinate(7, 4)] = createKing(Team.BLACK)

        return map
    }

    // TODO: Consider delegating this to a factory class
    private fun createRook(team: Team): Piece{
        return Piece(PieceType.ROOK,
            OrientationRule(
                listOf(
                    HorizontalValidator(),
                    VerticalValidator()
                ),
                MoveQuantityRule(
                    UnlimitedValidator(),
                    ObstacleRule(
                        listOf(HorizontalObstacleValidator(), VerticalObstacleValidator()),
                        EndOfRule())))
            ,
            team
        )
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
                        EndOfRule())))
            ,
            team
        )
    }

    private fun createQueen(team: Team): Piece{
        return Piece(PieceType.QUEEN,
            OrientationRule(
                listOf(
                    HorizontalValidator(),
                    VerticalValidator(),
                    DiagonalValidator()
                ),
                MoveQuantityRule(
                    UnlimitedValidator(),
                    ObstacleRule(
                        listOf(HorizontalObstacleValidator(), VerticalObstacleValidator(), DiagonalObstacleValidator()),
                        EndOfRule())))
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

    private fun createKnight(team: Team): Piece{
        return Piece(PieceType.KNIGHT,
            OrientationRule(
                listOf(
                    LValidator()
                ),
                    EndOfRule()
            ),
            team
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
