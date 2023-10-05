package game

import board.Board
import board.Coordinate
import piece.Team

class Game(private var board: Board, private val turn: Team) {
    // TODO: Should game be mutable? Or do I need to return a new Game instance each move? Answer: Immutable

    fun move(from: Coordinate, to: Coordinate) {
        if (this.board.hasCoordinate(to)) { throw IllegalArgumentException("Coordinate $to is occupied") } //TODO depend if the position is occupied by the same team or not

        val piece = this.board.getPiece(from) ?: throw NoSuchElementException("No piece at $from")

        if (!piece.validateMove(this.board, to, from)) {
            throw IllegalArgumentException("Invalid move") // TODO: Not sure if throwing is the right decision here
        }

        this.board = board.movePiece(from, to)
    }

    fun printBoard() {
        this.board.print()
    }
}
