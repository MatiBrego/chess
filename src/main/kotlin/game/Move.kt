package game

import board.Board
import board.Coordinate
import piece.Piece

data class Move(
    private val board: Board,
    private val from: Coordinate,
    private val to: Coordinate,
    private val piece: Piece
) {
    fun getBoard(): Board {
        return board
    }

    fun getFrom(): Coordinate {
        return from
    }

    fun getTo(): Coordinate {
        return to
    }

    fun getPiece(): Piece {
        return piece
    }
}