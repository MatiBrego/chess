package piece

import board.Coordinate
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import result.move.PieceRuleViolationResult
import result.move.SuccessfulResult
import util.game.TestGameGenerator
import util.startingposition.knight.KnightInCenter
import kotlin.test.assertEquals

class KnightMovementTest {

    private val gameGenerator = TestGameGenerator()

    @Test
    fun `test valid knight moves for knight in center without obstacle`(){
        val game = gameGenerator.generate(KnightInCenter())
        val knightPosition = Coordinate(3, 3)

        // Valid moves along the L shape
        assertTrue(game.move(knightPosition, Coordinate(1, 2)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(2, 1)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(4, 1)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(5, 2)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(5, 4)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(4, 5)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(2, 5)) is SuccessfulResult)
        assertTrue(game.move(knightPosition, Coordinate(1, 4)) is SuccessfulResult)
    }

    @Test
    fun `test invalid knight moves for knight in center without obstacle`(){
        val game = gameGenerator.generate(KnightInCenter())
        val knightPosition = Coordinate(3, 3)

        // Invalid moves row 0
        for (col in listOf(0, 1, 2, 3, 4, 5, 6, 7)){
            assertEquals(game.move(knightPosition, Coordinate(0, col)), PieceRuleViolationResult)
        }

        // Invalid moves row 1
        for (col in listOf(0, 1, 3, 5, 6, 7)){
            assertEquals(game.move(knightPosition, Coordinate(1, col)), PieceRuleViolationResult)
        }

        // Invalid moves row 2
        for (col in listOf(0, 2, 3, 4, 6, 7)){
            assertEquals(game.move(knightPosition, Coordinate(2, col)), PieceRuleViolationResult)
        }

        // Invalid moves for row 3 (knight's own row)
        for (col in listOf(0, 1, 2, 4, 5, 6, 7)) {
            assertEquals(game.move(knightPosition, Coordinate(3, col)), PieceRuleViolationResult)
        }

        // Invalid moves row 4
        for (col in listOf(0, 2, 3, 4, 6, 7)){
            assertEquals(game.move(knightPosition, Coordinate(4, col)), PieceRuleViolationResult)
        }

        // Invalid moves for row 5
        for (col in listOf(0, 1, 3, 5, 6, 7)) {
            assertEquals(game.move(knightPosition, Coordinate(5, col)), PieceRuleViolationResult)
        }

        // Invalid moves for row 6
        for (col in listOf(0, 2, 3, 4, 6, 7)) {
            assertEquals(game.move(knightPosition, Coordinate(6, col)), PieceRuleViolationResult)
        }

        // Invalid moves for row 7
        for (col in listOf(0, 1, 2, 3, 4, 5, 6, 7)) {
            assertEquals(game.move(knightPosition, Coordinate(7, col)), PieceRuleViolationResult)
        }

    }
}
