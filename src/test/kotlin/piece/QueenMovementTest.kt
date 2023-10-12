package piece

import board.Coordinate
import org.junit.jupiter.api.Test
import util.game.TestGameGenerator
import util.startingposition.queen.QueenInCenter

class QueenMovementTest {
    val generator = TestGameGenerator()

    @Test
    fun `test valid queen moves for queen in center without obstacle`(){
        val game = generator.generate(QueenInCenter(), listOf())
        val kingPosition = Coordinate(3, 3)
    }
}
