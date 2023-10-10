package piece

import board.Coordinate
import result.move.PieceRuleViolationResult
import result.move.SuccessfulResult
import util.game.TestGameGenerator
import util.startingposition.bishop.BishopInCenter
import util.startingposition.bishop.BishopInCenterBlocked
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BishopMovementTest {

    private val gameGenerator = TestGameGenerator()

    @Test
    fun `test valid bishop moves for bishop in center without obstacle`() {
        val game = gameGenerator.generate(BishopInCenter(), emptyList())
        val bishopPosition = Coordinate(3, 3)

        // Valid moves along the primary diagonal (from top-left to bottom-right)

        // Up and left
        assertTrue(game.move(bishopPosition, Coordinate(2,2)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(1,1)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(0,0)) is SuccessfulResult)

        // Down and right
        assertTrue(game.move(bishopPosition, Coordinate(4,4)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(5,5)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(6,6)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(7,7)) is SuccessfulResult)

        // Valid moves along the secondary diagonal (from bottom-left to top-right)

        // Up and right
        assertTrue(game.move(bishopPosition, Coordinate(4,2)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(5,1)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(6,0)) is SuccessfulResult)

        // Down and left
        assertTrue(game.move(bishopPosition, Coordinate(2,4)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(1,5)) is SuccessfulResult)
        assertTrue(game.move(bishopPosition, Coordinate(0,6)) is SuccessfulResult)


    }

    @Test
    fun `test invalid bishop moves for bishop in center without obstacle`() {
        val game = gameGenerator.generate(BishopInCenter(), emptyList())
        val bishopPosition = Coordinate(3, 3)

        // Invalid moves for row 0
        for (col in listOf(2, 3, 4, 5, 7)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(0, col)))
        }

        // Invalid moves for row 1
        for (col in listOf(0, 2, 3, 4, 6, 7)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(1, col)))
        }

        // Invalid moves for row 2
        for (col in listOf(0, 1, 3, 6, 7)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(2, col)))
        }

        // Invalid moves for row 3 (bishop's own row)
        for (col in listOf(0, 1, 2, 4, 5, 6, 7)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(3, col)))
        }

        // Invalid moves for row 4
        for (col in listOf(0, 1, 3, 6, 7)) {  // Exclude Coordinate(4, 4)
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(4, col)))
        }

        // Invalid moves for rows 5
        for (col in listOf(0, 2, 3, 4, 6, 7)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(5, col)))
        }

        // Invalid moves for row 6
        for (col in listOf(2, 3, 4, 5, 7)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(6, col)))
        }

        // Invalid moves for row 7
        for (col in listOf(0, 1, 2, 3, 4, 5, 6)) {
            assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(7, col)))
        }


    }

    @Test
    fun `test invalid bishop moves for bishop in center with obstacles in all directions`(){
        val game = gameGenerator.generate(BishopInCenterBlocked())
        val bishopPosition = Coordinate(3, 3)

        // Invalid moves along the primary diagonal (from top-left to bottom-right)

        // Up and left
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(1,1)))
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(0,0)))

        // Down and right
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(5,5)))
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(6,6)))
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(7,7)))

        // Invalid moves along the secondary diagonal (from bottom-left to top-right)

        // Up and right
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(5,1)))
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(6,0)))

        // Down and left
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(1,5)))
        assertEquals(PieceRuleViolationResult, game.move(bishopPosition, Coordinate(0,6)))
    }
}
