package minesweeper.view

import minesweeper.domain.Board
import minesweeper.domain.BoardDisplayFactory

object OutputView {
    private val messageBuilder = StringBuilder()

    fun printBoard(board: Board) {
        messageBuilder.appendLine("지뢰찾기 게임 시작!")
        messageBuilder.append(BoardDisplayFactory.present(board))
    }

    fun flush() {
        print(messageBuilder.toString())
        messageBuilder.clear()
    }
}
