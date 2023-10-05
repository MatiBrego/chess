package board

import piece.Piece

class NormalBoard(
    private val positions: Map<Coordinate, Piece>
) : Board{
    override fun movePiece(from: Coordinate, to: Coordinate): Board {
        val piece: Piece = positions[from]?: throw NoSuchElementException("No piece at $from")


        return NormalBoard(positions + Pair(to, piece) - from)
    }

    override fun getPiece(coordinate: Coordinate): Piece? {
        return positions[coordinate]
    }

    override fun hasCoordinate(coordinate: Coordinate): Boolean {
        return positions.containsKey(coordinate)
    }

    override fun print() {
        val board = Array(8) { Array(8) { "---------" } }

        positions.forEach { (coordinate, piece) ->
            board[coordinate.row][coordinate.column] = piece.toString()
        }

        board.forEach { row ->
            row.forEach { print("$it ") }
            println()
        }
    }
}
