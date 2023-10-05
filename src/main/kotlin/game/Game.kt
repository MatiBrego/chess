package game

import board.Board
import board.Coordinate
import piece.Team
import result.move.*
import result.validation.InvalidResult
import result.validation.ValidResult

class Game(private var board: Board, private val turn: Team) {
    //TODO: Should game be mutable? Or do I need to return a new Game instance each move? Answer: Immutable

    fun move(from: Coordinate, to: Coordinate): MoveResult{
        if (this.board.getPiece(to)?.team == this.turn) {
            return OccupiedCoordinateResult
        }

        val piece = this.board.getPiece(from) ?: return NoPieceInCoordinateResult

        //TODO: Take all of the above validation into a global rules class

        return when(piece.validateMove(this.board, to, from)){
            InvalidResult -> {
                PieceRuleViolationResult
            }

            ValidResult -> {
                this.board = board.movePiece(from, to)
                SuccessfulResult
            }
        }
    }

    fun printBoard() {
        this.board.print()
    }
}
