package util.game

import board.NormalBoard
import game.Game
import piece.Team
import start.StartingPositionGenerator

class TestGameGenerator {
    fun generate(startingPositionGenerator: StartingPositionGenerator): Game {
        return Game(NormalBoard(startingPositionGenerator.generate()), Team.WHITE)
    }
}
