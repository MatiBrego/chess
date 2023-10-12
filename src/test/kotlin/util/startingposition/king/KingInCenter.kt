package util.startingposition.king

import board.Coordinate
import factory.createKing
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class KingInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createKing(Team.WHITE)
        )
    }
}
