package minesweeper.domain

import Mines

class Board private constructor(
    val size: BoardSize,
    val mines: Mines,
    private val cells: Map<Position, Cell>
) {
    fun getCell(position: Position): Cell? = cells[position]

    companion object {

        fun create(
            rows: Int,
            columns: Int,
            mineCount: Int,
        ): Board {
            val boardSize = BoardSize(rows, columns)
            require(mineCount < rows * columns) { "지뢰 개수는 보드 크기보다 작아야 합니다." }

            val mines = Mines.create(boardSize, MineCount(mineCount))
            val cells = createCells(boardSize, mines)
            return Board(boardSize, mines, cells)
        }

        private fun createCells(boardSize: BoardSize, mines: Mines): Map<Position, Cell> {
            val adjacentMineCounts = mutableMapOf<Position, Int>()

            for (minePosition in mines.positions.values) {
                minePosition.getAdjacentPositions(boardSize).forEach { position ->
                    adjacentMineCounts[position] = adjacentMineCounts.getOrDefault(position, 0) + 1
                }
            }

            return buildMap {
                for (row in 0 until boardSize.rows) {
                    for (col in 0 until boardSize.columns) {
                        val position = Position(row, col)
                        if (position in mines) {
                            put(position, Cell.Mine(position))
                        } else {
                            put(position, Cell.Empty(position, adjacentMineCounts.getOrDefault(position, 0)))
                        }
                    }
                }
            }
        }
    }
}
