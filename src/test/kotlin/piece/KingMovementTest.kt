package piece

import board.Coordinate
import result.move.PieceRuleViolationResult
import result.move.SuccessfulResult
import util.game.TestGameGenerator
import util.startingposition.king.KingInCenter
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KingMovementTest {
    private val gameGenerator = TestGameGenerator()

    @Test
    fun `test valid king moves for king in center without obstacle`(){
        val game = gameGenerator.generate(KingInCenter(), emptyList())
        val kingPosition = Coordinate(3, 3)

        assertTrue(game.move(kingPosition, Coordinate(2, 3)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(4, 3)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(3, 2)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(3, 4)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(2, 2)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(4, 4)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(2, 4)) is SuccessfulResult)
        assertTrue(game.move(kingPosition, Coordinate(4, 2)) is SuccessfulResult)
    }

    @Test
    fun `test invalid king moves for king in center without obstacle`(){
        val game = gameGenerator.generate(KingInCenter(), emptyList())
        val kingPosition = Coordinate(3, 3)

        assertEquals(game.move(kingPosition, Coordinate(3, 1)), PieceRuleViolationResult)
        assertEquals(game.move(kingPosition, Coordinate(3, 5)), PieceRuleViolationResult)
        assertEquals(game.move(kingPosition, Coordinate(5, 3)), PieceRuleViolationResult)
        assertEquals(game.move(kingPosition, Coordinate(1, 3)), PieceRuleViolationResult)

        assertEquals(game.move(kingPosition, Coordinate(1, 1)), PieceRuleViolationResult)
    }
}
