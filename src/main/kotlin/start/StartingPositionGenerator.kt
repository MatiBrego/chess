package start

import board.Coordinate
import piece.Piece

interface StartingPositionGenerator {
    fun generate(): Map<Coordinate, Piece>
}
