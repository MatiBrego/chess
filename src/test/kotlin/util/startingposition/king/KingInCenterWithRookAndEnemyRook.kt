package util.startingposition.king

import board.Coordinate
import factory.createKing
import factory.createRook
import piece.Piece
import piece.Team
import start.StartingPositionGenerator

class KingInCenterWithRookAndEnemyRook: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createKing(Team.WHITE),
            Coordinate(4, 3) to createRook(Team.WHITE),
            Coordinate(5, 3) to createRook(Team.BLACK)
        )
    }
}
