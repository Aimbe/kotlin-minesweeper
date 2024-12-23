package minesweeper.domain

class Mines private constructor(
    private val positions: MinePositions,
) {
    fun contains(position: Position): Boolean = positions.contains(position)

    fun mineCount(): Int = positions.size()

    companion object {
        fun create(
            boardSize: BoardSize,
            mineCount: MineCount,
        ): Mines {
            val positions = generateMinePositions(boardSize, mineCount)
            return Mines(positions)
        }

        private fun generateMinePositions(
            boardSize: BoardSize,
            mineCount: MineCount,
        ): MinePositions {
            val positions = mutableSetOf<Position>()
            while (positions.size < mineCount.count()) {
                positions.add(Position.random(boardSize))
            }
            return MinePositions.from(positions)
        }
    }
}
