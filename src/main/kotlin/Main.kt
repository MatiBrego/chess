import board.Board
import board.Coordinate
import board.NormalBoard
import game.Game
import piece.Team
import start.NormalStartingPosition
import start.StartingPositionGenerator

fun main(args: Array<String>) {
    println("-----------------Chess-----------------")

    val startingPosition: StartingPositionGenerator = NormalStartingPosition()

    val game = Game(
        NormalBoard(startingPosition.generate()),
        Team.WHITE,
        emptyMap()
    )

    game.move(Coordinate(0, 0), Coordinate(3, 0))
    game.printBoard()
}
