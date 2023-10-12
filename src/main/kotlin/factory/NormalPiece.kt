package factory

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

fun createRook(team: Team): Piece {
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

fun createBishop(team: Team): Piece{
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

fun createQueen(team: Team): Piece{
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



fun createKing(team: Team): Piece{
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

fun createKnight(team: Team): Piece{
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

fun createPawn(team: Team): Piece{
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
