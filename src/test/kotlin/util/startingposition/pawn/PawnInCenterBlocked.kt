package util.startingposition.pawn

import board.Coordinate
import factory.createPawn
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class PawnInCenterBlocked: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createPawn(Team.WHITE),
            Coordinate(4, 3) to createPawn(Team.BLACK),
            Coordinate(4, 2) to createPawn(Team.BLACK),
            Coordinate(4, 4) to createPawn(Team.BLACK)
        )
    }
}
