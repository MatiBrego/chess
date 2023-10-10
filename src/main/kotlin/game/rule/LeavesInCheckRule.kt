package game.rule

import board.Board
import board.Coordinate
import game.Move
import game.rule.validator.CheckValidator
import piece.Piece
import piece.enum.PieceType
import result.game.GameRuleResult
import result.game.LeavesInCheckResult
import result.game.ValidGameRuleResult

class LeavesInCheckRule(
    private val checkValidator: CheckValidator
): GameRule {
    override fun validateRule(move: Move): GameRuleResult {
        if(checkValidator.validate(
                move.getBoard().movePiece(move.getFrom(), move.getTo()),
                getKingCoords(move.getBoard())
            )
        ){
            return LeavesInCheckResult
        }
        return ValidGameRuleResult
    }

    private fun getKingCoords(board: Board): Coordinate {
        board.getOccupiedPositions().forEach { coordinate ->
            if (board.getPiece(coordinate)?.name == PieceType.KING) {
                return coordinate
            }
        }
        throw NoSuchElementException("No king in board found")
    }
}
