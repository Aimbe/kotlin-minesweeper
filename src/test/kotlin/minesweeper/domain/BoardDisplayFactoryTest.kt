package minesweeper.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BoardDisplayFactoryTest : StringSpec({

    "디스플레이 결과를 표출한다." {

        val boardSize = BoardSize(3, 3)
        val minePositions = setOf(Position(0, 0), Position(1, 1))
        val expectedDisplay = "* C C\nC * C\nC C C"
        val board = Board.create(boardSize.rows, boardSize.columns, minePositions.size)
        val actualDisplay = BoardDisplayFactory.present(board)
        actualDisplay shouldBe expectedDisplay
    }
})
