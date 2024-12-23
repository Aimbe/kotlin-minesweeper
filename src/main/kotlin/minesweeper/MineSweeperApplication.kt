package minesweeper

import minesweeper.view.InputView
import minesweeper.view.OutputView

fun main() {
    MineSweeperController(InputView, OutputView).play()
}
