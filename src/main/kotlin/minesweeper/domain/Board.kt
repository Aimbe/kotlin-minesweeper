package minesweeper.domain

import com.sun.rowset.internal.Row

class Board private constructor(
    private val size: BoardSize,
    private val mines: Mines
) {

    fun display() {

    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
    companion object {
        fun create(rows: Int, columns: Int, mineCount: Int): Board {
            val boardSize = BoardSize(rows, columns)
            val mines = Mines.create(boardSize, MineCount(mineCount))
            return Board(boardSize, mines)
        }
    }
}
