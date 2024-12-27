package minesweeper.domain

data class BoardSize(val rows: Int, val columns: Int) {
    init {
        require(rows > 0) { "행은 1 이상이어야 합니다." }
        require(columns > 0) { "열은 1 이상이어야 합니다." }
    }
}
