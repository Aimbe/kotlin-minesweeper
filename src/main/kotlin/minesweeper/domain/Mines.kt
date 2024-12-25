package minesweeper.domain

class Mines private constructor(
    private val positions: MinePositions,
) {
    operator fun contains(position: Position): Boolean = positions.contains(position)

    fun mineCount(): Int = positions.size

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
            val allPositions = generateAllPositions(boardSize)

            val selectedPositions = allPositions.shuffled().take(mineCount.count)
            return MinePositions.from(selectedPositions.toSet())
        }

        private fun generateAllPositions(boardSize: BoardSize): List<Position> {
            return (0 until boardSize.rows).flatMap { row ->
                (0 until boardSize.columns).map { col ->
                    Position(row, col)
                }
            }
        }

    }
}
