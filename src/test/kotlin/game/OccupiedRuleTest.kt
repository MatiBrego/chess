package game

import board.Coordinate
import game.rule.OccupiedRule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import result.move.GameRuleViolationResult
import util.game.TestGameGenerator
import util.startingposition.rook.RookInCenterBlockedByTeam

class OccupiedRuleTest {
    private val gameGenerator = TestGameGenerator()
    @Test
    fun `test occupied coordinate`(){
        val game = gameGenerator.generate(RookInCenterBlockedByTeam(), listOf(OccupiedRule()))

        val rookPosition = Coordinate(3,3)

        assertEquals(GameRuleViolationResult, game.move(rookPosition, Coordinate(3,4)))
        assertEquals(GameRuleViolationResult, game.move(rookPosition, Coordinate(3,2)))
        assertEquals(GameRuleViolationResult, game.move(rookPosition, Coordinate(4,3)))
        assertEquals(GameRuleViolationResult, game.move(rookPosition, Coordinate(2,3)))
    }
}
