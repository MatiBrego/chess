package util.startingposition.queen

import board.Coordinate
import factory.createQueen
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class QueenInCenter: StartingPositionGenerator {

    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(Coordinate(3, 3) to createQueen(Team.WHITE))
    }
}
