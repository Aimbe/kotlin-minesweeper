package minesweeper.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BoardDisplayFactoryTest : StringSpec({

    "디스플레이 결과를 랜덤한 보드를 생성한다." {

        val boardSize = BoardSize(3, 3)
        val mineCount = 2
        val board = Board.create(boardSize.rows, boardSize.columns, mineCount)
        val actualDisplay = BoardDisplayFactory.present(board)

        val rows = actualDisplay.split("\n")
        rows.size shouldBe boardSize.rows
        rows.forEach { row ->
            row.split(" ").size shouldBe boardSize.columns
        }

        val mineCountInDisplay = actualDisplay.count { it == '*' }
        mineCountInDisplay shouldBe mineCount
    }
})
