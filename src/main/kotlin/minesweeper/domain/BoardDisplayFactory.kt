package minesweeper.domain

object BoardDisplayFactory {
    fun present(board: Board): String {
        return buildString {
            for (row in 0 until board.size.rows) {
                for (col in 0 until board.size.columns) {
                    if (col > 0) append(" ")
                    append(cellRepresentation(board, Position(row, col)))
                }
                if (row < board.size.rows - 1) append("\n")
            }
        }
    }

    private fun cellRepresentation(
        board: Board,
        position: Position,
    ): String {
        return if (position in board.mines) "*" else "C"
    }
}
