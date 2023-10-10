package game.rule

import game.Move
import result.game.GameRuleResult
import result.game.OccupiedCoordinateResult
import result.game.ValidGameRuleResult

class OccupiedRule: GameRule {
    override fun validateRule(move: Move): GameRuleResult {
        if (move.getBoard().getPiece(move.getTo())?.team == move.getTurn()) {
            return OccupiedCoordinateResult
        }
        return ValidGameRuleResult
    }
}
