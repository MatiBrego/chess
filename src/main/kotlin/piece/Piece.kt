package piece

import board.Board
import board.Coordinate
import game.Move
import piece.rule.PieceRule


data class Piece (val name:String, val pieceRule: PieceRule, val team: Team){
    fun validateMove(board: Board, to: Coordinate, from: Coordinate): Boolean {
        return this.pieceRule.validateMove(Move(board, from, to, this)).isValid()
    }

    override fun toString(): String {
        return "$name (${team.toString()[0]})"
    }
}

