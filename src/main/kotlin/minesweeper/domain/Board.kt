package minesweeper.domain

class Board private constructor(
    val size: BoardSize,
    val mines: Mines,
) {
    companion object {
        fun create(
            rows: Int,
            columns: Int,
            mineCount: Int,
        ): Board {
            val boardSize = BoardSize(rows, columns)
            val mines = Mines.create(boardSize, MineCount(mineCount))
            return Board(boardSize, mines)
        }
    }
}
