package start

import board.Coordinate
import factory.*
import piece.Piece
import piece.Team

class NormalStartingPosition: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        val map: MutableMap<Coordinate, Piece> = mutableMapOf()

        // Pawn
        for (i in 0..7) {
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
}
