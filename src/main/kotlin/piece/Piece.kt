package piece

import board.Board
import board.Coordinate
import game.Move
import piece.rule.PieceRule
import result.validation.ValidationResult


data class Piece (val name:String, val pieceRule: PieceRule, val team: Team){
    fun validateMove(board: Board, to: Coordinate, from: Coordinate): ValidationResult {
        return this.pieceRule.validateMove(Move(board, from, to, this))
    }

    override fun toString(): String {
        return "$name (${team.toString()[0]})"
    }
}

