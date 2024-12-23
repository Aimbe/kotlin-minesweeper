package minesweeper.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MinesTest : StringSpec({
    val boardSize = BoardSize(10, 10)

    "지정된 개수만큼 지뢰를 생성한다" {
        val mineCount = MineCount(5)
        val mines = Mines.create(boardSize, mineCount)

        val positions = mines::class.java.getDeclaredField("positions").apply {
            isAccessible = true
        }.get(mines) as Set<*>

        positions.size shouldBe 5
    }

    "같은 위치에 지뢰가 중복되지 않는다" {
        val mineCount = MineCount(10)
        val mines = Mines.create(boardSize, mineCount)

        val positions = mines::class.java.getDeclaredField("positions").apply {
            isAccessible = true
        }.get(mines) as Set<*>

        positions.size shouldBe 10
    }
})
