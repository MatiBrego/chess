package game.rule.validator

import board.Board
import board.Coordinate
import game.Move
import piece.Team
import result.validation.ValidResult

class CheckValidator {
    fun validate(board: Board, kingPosition: Coordinate): Boolean {
        val kingsTeam: Team = board.getPiece(kingPosition)?.team ?: throw NoSuchElementException("No king found")

        board.getOccupiedPositions().forEach { coordinate ->
            if (board.getPiece(coordinate)?.team != kingsTeam) {
                val piece = board.getPiece(coordinate) ?: throw NoSuchElementException("No piece found")
                if (
                    piece.validateMove(
                        Move(board, coordinate, kingPosition, piece, kingsTeam, emptyList() // TODO: Do I need to get the history of the piece to check for checks?
                        )
                    ) is ValidResult) {
                    return true
                }
            }
        }
        return false
    }
}
