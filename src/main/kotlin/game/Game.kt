package game

import board.Board
import board.Coordinate
import piece.Piece
import piece.Team
import result.move.*
import result.validation.InvalidResult
import result.validation.ValidResult

class Game(
    private var board: Board,
    private val turn: Team,
    private val histories: Map<Piece, List<Move>>
) {
    //TODO: Should game be mutable? Or do I need to return a new Game instance each move? Answer: Immutable

    fun move(from: Coordinate, to: Coordinate): MoveResult{
        if (this.board.getPiece(to)?.team == this.turn) {
            return OccupiedCoordinateResult
        }

        val piece = this.board.getPiece(from) ?: return NoPieceInCoordinateResult

        //TODO: Take all of the above validation into a global rules class

        val move = Move(this.board, from, to, piece, histories[piece] ?: listOf())

        return when(piece.validateMove(move)){
            InvalidResult -> {
                PieceRuleViolationResult
            }

            ValidResult -> {
                val newHistory = histories[piece]?: listOf()
                SuccessfulResult(
                    Game(
                        board.movePiece(from, to),
                        Team.WHITE,
                        histories + Pair(piece, newHistory + move)))
            }
        }
    }

    fun printBoard() {
        this.board.print()
    }
}
