import minesweeper.domain.BoardSize
import minesweeper.domain.MineCount
import minesweeper.domain.MinePositions
import minesweeper.domain.Position

class Mines private constructor(
    val positions: MinePositions,
) {
    operator fun contains(position: Position): Boolean = positions.contains(position)

    fun mineCount(): Int = positions.size

    companion object {
        fun create(
            boardSize: BoardSize,
            mineCount: MineCount,
        ): Mines {
            val positions = generateMinePositions(boardSize, mineCount)
            return Mines(MinePositions.from(positions))
        }

        private fun generateMinePositions(
            boardSize: BoardSize,
            mineCount: MineCount,
        ): Set<Position> {
            val allPositions = generateAllPositions(boardSize)
            return allPositions.shuffled().take(mineCount.count).toSet()
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
