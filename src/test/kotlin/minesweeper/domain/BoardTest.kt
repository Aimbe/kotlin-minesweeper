package minesweeper.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class BoardTest : StringSpec({
    "올바른 값으로 보드를 생성할 수 있다" {
        shouldNotThrowAny {
            Board.create(10, 10, 10)
        }
    }

    "행이 0 이하면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Board.create(0, 10, 10)
        }
    }

    "열이 0 이하면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Board.create(10, 0, 10)
        }
    }

    "지뢰 개수가 0 이하면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Board.create(10, 10, 0)
        }
    }
})
