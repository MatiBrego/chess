package game

import board.Board
import board.Coordinate
import game.rule.GameRule
import piece.Piece
import piece.Team
import result.game.*
import result.move.*
import result.validation.InvalidResult
import result.validation.ValidResult

class Game(
    private var board: Board,
    private val turn: Team = Team.WHITE,
    private val histories: Map<Piece, List<Move>>,
    private val rules: List<GameRule>
) {

    fun move(from: Coordinate, to: Coordinate): MoveResult{
//        if (this.board.getPiece(to)?.team == this.turn) {
//            return OccupiedCoordinateResult
//        }
//
        val piece = this.board.getPiece(from) ?: return NoPieceInCoordinateResult

        val move = Move(this.board, from, to, piece, turn,histories[piece] ?: listOf())

        for(rule in rules){
            return when(rule.validateRule(move)){
                ValidGameRuleResult -> {
                    continue
                }

                is ValidWithNewBoardGameResult -> {
                    continue
                }

                InvalidGameRuleResult -> {
                    GameRuleViolationResult
                }

                OccupiedCoordinateResult -> {
                    GameRuleViolationResult
                }

                LeavesInCheckResult -> {
                    GameRuleViolationResult
                }
            }
        }

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
                        histories + Pair(piece, newHistory + move),
                        rules
                    ),
                )
            }
        }
    }

    fun printBoard() {
        this.board.print()
    }
}
