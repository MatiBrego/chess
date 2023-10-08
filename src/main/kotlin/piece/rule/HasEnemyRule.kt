package piece.rule

import game.Move
import piece.Team
import result.validation.InvalidResult
import result.validation.ValidationResult

class HasEnemyRule(
    private val nextRule: PieceRule
): PieceRule {
    override fun validateMove(move: Move): ValidationResult {
        val pieceTo: Team = move.getBoard().getPiece(move.getTo())?.team ?: return InvalidResult

        if(pieceTo != move.getPiece().team) return nextRule.validateMove(move)

        return InvalidResult
    }

}
