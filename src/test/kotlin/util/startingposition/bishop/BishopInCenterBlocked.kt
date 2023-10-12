package util.startingposition.bishop

import board.Coordinate
import factory.createBishop
import piece.Piece
import piece.Team
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
}
