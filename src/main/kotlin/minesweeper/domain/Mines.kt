package minesweeper.domain

class Mines private constructor(
    private val positions: Set<Position>
) {
    fun contains(position: Position): Boolean = positions.contains(position)

    companion object {
        fun create(boardSize: BoardSize, mineCount: MineCount): Mines {
            val positions = generateMinePositions(boardSize, mineCount)
            return Mines(positions)
        }

        private fun generateMinePositions(
            boardSize: BoardSize,
            mineCount: MineCount
        ): Set<Position> {
            val positions = mutableSetOf<Position>()
            while (positions.size < mineCount.value()) {
                positions.add(Position.random(boardSize))
            }
            return positions
        }
    }
}
