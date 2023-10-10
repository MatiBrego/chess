package game.rule

import game.Move
import result.game.GameRuleResult

interface GameRule {
    fun validateRule(move: Move): GameRuleResult
}
