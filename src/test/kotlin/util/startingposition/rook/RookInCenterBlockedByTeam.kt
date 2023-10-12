package util.startingposition.rook

import board.Coordinate
import factory.createRook
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class RookInCenterBlockedByTeam: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createRook(Team.WHITE),
            Coordinate(2, 3) to createRook(Team.WHITE),
            Coordinate(4, 3) to createRook(Team.WHITE),
            Coordinate(3, 2) to createRook(Team.WHITE),
            Coordinate(3, 4) to createRook(Team.WHITE)
        )

    }
}
