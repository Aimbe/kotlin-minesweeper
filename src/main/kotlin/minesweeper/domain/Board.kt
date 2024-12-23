package minesweeper.domain

class Board private constructor(
    private val size: BoardSize,
    private val mines: Mines,
) {
    val boardSize: BoardSize
        get() = size
    val minePositions: Mines
        get() = mines

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
