package minesweeper.domain

object BoardDisplayFactory {
    fun present(board: Board): String {
        return buildString {
            for (row in 0 until board.boardSize.rows) {
                for (col in 0 until board.boardSize.columns) {
                    if (col > 0) append(" ")
                    append(cellRepresentation(board, Position(row, col)))
                }
                if (row < board.boardSize.rows - 1) append("\n")
            }
        }
    }

    private fun cellRepresentation(
        board: Board,
        position: Position,
    ): String {
        return if (board.minePositions.contains(position)) "*" else "C"
    }
}
