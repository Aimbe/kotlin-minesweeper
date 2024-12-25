package minesweeper.domain

class MinePositions private constructor(
    private val values: Set<Position>,
) {
    operator fun contains(position: Position): Boolean = position in values

    val size: Int
        get() = values.size

    companion object {
        fun from(positions: Set<Position>): MinePositions {
            return MinePositions(positions)
        }
    }
}
