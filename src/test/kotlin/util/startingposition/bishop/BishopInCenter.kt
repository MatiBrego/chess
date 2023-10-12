package util.startingposition.bishop

import board.Coordinate
import factory.createBishop
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class BishopInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(Coordinate(3, 3) to createBishop(Team.WHITE))
    }
}
