package util.startingposition.rook

import board.Coordinate
import factory.createRook
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class RookInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(Coordinate(3, 3) to createRook(Team.WHITE))
    }
}
