package start

import board.Coordinate
import piece.Piece
import piece.Team
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

class NormalStartingPosition: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        val map:MutableMap<Coordinate, Piece>  = mutableMapOf()

        // Pawn

        // Rook
        map[Coordinate(0, 0)] = createRook(Team.WHITE)
        map[Coordinate(0, 7)] = createRook(Team.WHITE)
        map[Coordinate(7, 0)] = createRook(Team.BLACK)
        map[Coordinate(7, 7)] = createRook(Team.BLACK)

        // Knight

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
                        EndOfRule())))
            ,
            team
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
                        EndOfRule())))
            ,
            team
        )
    }

    private fun createQueen(team: Team): Piece{
        return Piece("Queen",
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
        return Piece("King",
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
