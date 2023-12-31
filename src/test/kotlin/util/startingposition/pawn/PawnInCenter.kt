package util.startingposition.pawn

import board.Coordinate
import factory.createPawn
import piece.Piece
import piece.Team
import piece.rule.*
import start.StartingPositionGenerator

class PawnInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createPawn(Team.WHITE)
        )
    }
}
