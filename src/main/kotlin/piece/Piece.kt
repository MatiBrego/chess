package piece

import board.Board
import board.Coordinate
import game.Move
import piece.rule.PieceRule
import result.validation.ValidationResult


data class Piece (val name:String, val pieceRule: PieceRule, val team: Team){
    fun validateMove(move: Move): ValidationResult {
        return this.pieceRule.validateMove(move) // TODO: Should piece create the Move object?
    }

    override fun toString(): String {
        return "$name (${team.toString()[0]})"
    }
}

