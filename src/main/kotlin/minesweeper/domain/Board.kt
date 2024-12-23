package minesweeper.domain

class Board private constructor(
    private val size: BoardSize,
    private val mines: Mines,
) {
    fun display(): String {
        return buildString {
            for (row in 0 until size.rows) {
                for (col in 0 until size.columns) {
                    if (col > 0) append(" ")
                    append(if (mines.contains(Position(row, col))) "*" else "C")
                }
                if (row < size.rows - 1) append("\n")
            }
        }
    }

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
