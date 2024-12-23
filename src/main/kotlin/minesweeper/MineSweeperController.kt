package minesweeper

import minesweeper.domain.Board
import minesweeper.view.InputView
import minesweeper.view.OutputView

class MineSweeperController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun play() {
        val height = inputView.readHeight()
        val width = inputView.readWidth()
        val mineCount = inputView.readMineCount()

        val board = Board.create(height, width, mineCount)
        outputView.printBoard(board)
        outputView.flush()
    }
}
