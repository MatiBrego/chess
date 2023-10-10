package util.game

import board.NormalBoard
import game.Game
import game.rule.GameRule
import piece.Team
import start.StartingPositionGenerator

class TestGameGenerator {
    fun generate(
        startingPositionGenerator: StartingPositionGenerator,
        rules: List<GameRule> = emptyList()
        ): Game {
        return Game(NormalBoard(startingPositionGenerator.generate()), Team.WHITE, emptyMap(), rules)
    }
}
