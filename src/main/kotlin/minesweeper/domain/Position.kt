package minesweeper.domain

data class Position(val row: Int, val column: Int) {
    init {
        require(row >= 0) { "행은 0 이상이어야 합니다." }
        require(column >= 0) { "열은 0 이상이어야 합니다." }
    }
}
