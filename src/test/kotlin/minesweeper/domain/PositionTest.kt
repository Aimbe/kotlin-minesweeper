package minesweeper.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class PositionTest : StringSpec({
    "올바른 위치로 생성할 수 있다" {
        shouldNotThrowAny {
            Position(0, 0)
        }
    }

    "행이 음수면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Position(-1, 0)
        }
    }

    "열이 음수면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Position(0, -1)
        }
    }
})
