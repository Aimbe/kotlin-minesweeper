package minesweeper.domain

enum class Direction(val rowOffset: Int, val columnOffset: Int) {
    NORTH_WEST(-1, -1),
    NORTH(-1, 0),
    NORTH_EAST(-1, 1),
    WEST(0, -1),
    EAST(0, 1),
    SOUTH_WEST(1, -1),
    SOUTH(1, 0),
    SOUTH_EAST(1, 1);

    fun getAdjacentPosition(position: Position): Position {
        return Position(
            row = position.row + rowOffset,
            column = position.column + columnOffset
        )
    }
}
