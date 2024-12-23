package minesweeper.domain

class MinePositions private constructor(
    private val values: Set<Position>
) {
    fun contains(position: Position): Boolean = values.contains(position)

    fun size(): Int = values.size

    companion object {
        fun from(positions: Set<Position>): MinePositions {
            return MinePositions(positions)
        }
    }
}
