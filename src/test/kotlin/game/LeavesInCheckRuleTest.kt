package game

import board.Coordinate
import game.rule.LeavesInCheckRule
import game.rule.validator.CheckValidator
import result.move.GameRuleViolationResult
import util.game.TestGameGenerator
import util.startingposition.king.KingInCenterWithRookAndEnemyRook
import kotlin.test.Test
import kotlin.test.assertEquals

class LeavesInCheckRuleTest {
    private val gameGenerator = TestGameGenerator()

    @Test
    fun `test leaves in check after team move`(){
        val game = gameGenerator.generate(
            KingInCenterWithRookAndEnemyRook(),
            listOf(
                LeavesInCheckRule(
                    CheckValidator()
                )
            )
        )

        assertEquals(GameRuleViolationResult, game.move(Coordinate(4, 3), Coordinate(4, 4)))
    }
}
