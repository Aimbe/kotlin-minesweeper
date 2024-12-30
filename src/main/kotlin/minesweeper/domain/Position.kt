package minesweeper.domain

data class Position(val row: Int, val column: Int) {
    init {
        require(row >= 0) { "행은 0 이상이어야 합니다." }
        require(column >= 0) { "열은 0 이상이어야 합니다." }
    }

    fun getAdjacentPositions(boardSize: BoardSize): List<Position> {
        return Direction.entries
            .mapNotNull {
                val adjacent = it.getAdjacentPosition(this)
                if (adjacent.isValid(boardSize)) adjacent else null
            }
    }

    private fun isValid(boardSize: BoardSize): Boolean {
        return row in 0 until boardSize.rows &&
                column in 0 until boardSize.columns
    }
}
