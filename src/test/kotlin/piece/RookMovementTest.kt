package piece

import board.Coordinate
import result.move.PieceRuleViolationResult
import result.move.SuccessfulResult
import util.game.TestGameGenerator
import util.startingposition.rook.RookInCenter
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RookMovementTest {
    private val gameGenerator = TestGameGenerator()
    @Test
    fun `test valid rook moves for rook in center without obstacle`() {
        val game = gameGenerator.generate(RookInCenter())
        val rookPosition = Coordinate(3, 3)

        // Valid moves along the column (vertical movement)
        assertTrue(game.move(rookPosition, Coordinate(0,3)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(1,3)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(2,3)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(4,3)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(5,3)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(6,3)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(7,3)) is SuccessfulResult)

        // Valid moves along the row (horizontal movement)
        assertTrue(game.move(rookPosition, Coordinate(3,0)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(3,1)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(3,2)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(3,4)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(3,5)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(3,6)) is SuccessfulResult)
        assertTrue(game.move(rookPosition, Coordinate(3,7)) is SuccessfulResult)

    }

    @Test
    fun `test invalid rook moves for rook in center without obstacle`() {
        val game = gameGenerator.generate(RookInCenter())
        val rookPosition = Coordinate(3, 3)

        // Invalid moves in the first row (You've covered this row, but just for completeness)
        assertEquals(game.move(rookPosition, Coordinate(0, 1)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(1, 1)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(2, 1)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(4, 1)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(5, 1)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(6, 1)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(7, 1)), PieceRuleViolationResult)

        // Invalid moves in the second row
        assertEquals(game.move(rookPosition, Coordinate(0, 2)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(1, 2)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(2, 2)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(4, 2)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(5, 2)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(6, 2)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(7, 2)), PieceRuleViolationResult)


        // Invalid moves in the fourth row
        assertEquals(game.move(rookPosition, Coordinate(0, 4)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(1, 4)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(2, 4)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(4, 4)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(5, 4)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(6, 4)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(7, 4)), PieceRuleViolationResult)

        // Invalid moves in the fifth row
        assertEquals(game.move(rookPosition, Coordinate(0, 5)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(1, 5)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(2, 5)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(4, 5)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(5, 5)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(6, 5)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(7, 5)), PieceRuleViolationResult)

        // Invalid moves in the sixth row
        assertEquals(game.move(rookPosition, Coordinate(0, 6)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(1, 6)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(2, 6)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(4, 6)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(5, 6)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(6, 6)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(7, 6)), PieceRuleViolationResult)

        // Invalid moves in the seventh row
        assertEquals(game.move(rookPosition, Coordinate(0, 7)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(1, 7)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(2, 7)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(4, 7)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(5, 7)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(6, 7)), PieceRuleViolationResult)
        assertEquals(game.move(rookPosition, Coordinate(7, 7)), PieceRuleViolationResult)
    }


}
