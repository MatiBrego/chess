package util.startingposition.knight

import board.Coordinate
import piece.Piece
import piece.Team
import piece.rule.EndOfRule
import piece.rule.OrientationRule
import piece.rule.validator.orientation.LValidator
import start.StartingPositionGenerator

class KnightInCenter: StartingPositionGenerator {
    override fun generate(): Map<Coordinate, Piece> {
        return mapOf(
            Coordinate(3, 3) to createKnight(Team.WHITE)
        )
    }

    private fun createKnight(team: Team): Piece{
        return Piece("Knight",
            OrientationRule(
                listOf(
                    LValidator()
                ),
                EndOfRule()
            ),
            team
        )
    }
}
