package piece

import board.Coordinate
import game.Game
import result.move.PieceRuleViolationResult
import result.move.SuccessfulResult
import util.game.TestGameGenerator
import util.startingposition.pawn.PawnInCenter
import util.startingposition.pawn.PawnInCenterBlocked
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PawnMovementTest {
    private val gameGenerator = TestGameGenerator()

    @Test
    fun `test valid pawn moves for pawn in center without obstacle`() {
        val game = gameGenerator.generate(PawnInCenter())
        val pawnPosition = Coordinate(3, 3)

        // Valid moves for white pawn
        assertTrue(game.move(pawnPosition, Coordinate(4, 3)) is SuccessfulResult)
    }

    @Test
    fun `test invalid pawn moves for pawn in center without obstacle`(){
        val game = gameGenerator.generate(PawnInCenter())
        val pawnPosition = Coordinate(3, 3)

        // invalid moves for white pawn (Some)
        assertEquals(game.move(pawnPosition, Coordinate(4, 4)), PieceRuleViolationResult)
        assertEquals(game.move(pawnPosition, Coordinate(3, 4)), PieceRuleViolationResult)
        assertEquals(game.move(pawnPosition, Coordinate(2, 4)), PieceRuleViolationResult)
        assertEquals(game.move(pawnPosition, Coordinate(2, 3)), PieceRuleViolationResult)
        assertEquals(game.move(pawnPosition, Coordinate(2, 2)), PieceRuleViolationResult)
        assertEquals(game.move(pawnPosition, Coordinate(3, 2)), PieceRuleViolationResult)
        assertEquals(game.move(pawnPosition, Coordinate(4, 2)), PieceRuleViolationResult)
    }

    @Test
    fun `test first move pawn rule`(){
        val game = gameGenerator.generate(PawnInCenter())
        val startingPawnPosition = Coordinate(3, 3)
        val afterMovePawnPosition = Coordinate(4, 3)

        val resultAfterPawnMove = game.move(startingPawnPosition, afterMovePawnPosition)
        val gameAfterPawnMove: Game;
        when (resultAfterPawnMove){
            is SuccessfulResult -> gameAfterPawnMove = resultAfterPawnMove.game
            else -> throw RuntimeException("Valid move was unsuccessful")
        }

        assertTrue(game.move(startingPawnPosition, Coordinate(5, 3)) is SuccessfulResult)
        assertEquals(PieceRuleViolationResult, game.move(startingPawnPosition, Coordinate(6, 3)))
        assertEquals(PieceRuleViolationResult, gameAfterPawnMove.move(afterMovePawnPosition, Coordinate(6, 3)))
    }

    @Test
    fun `test pawn diagonal move rule`(){
        val game = gameGenerator.generate(PawnInCenterBlocked())
        val pawnPosition = Coordinate(3, 3)

        assertEquals(PieceRuleViolationResult, game.move(pawnPosition, Coordinate(4, 3)))
        assertEquals(PieceRuleViolationResult, game.move(pawnPosition, Coordinate(5, 3)))

        assertTrue(game.move(pawnPosition, Coordinate(4, 4)) is SuccessfulResult)
        assertTrue(game.move(pawnPosition, Coordinate(4, 2)) is SuccessfulResult)
    }
}
