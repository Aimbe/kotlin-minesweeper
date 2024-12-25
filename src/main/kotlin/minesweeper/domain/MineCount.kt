package minesweeper.domain


@JvmInline
value class MineCount(val count: Int) {
    init {
        require(count > 0) { "지뢰 개수는 1 이상이어야 합니다." }
    }
}
