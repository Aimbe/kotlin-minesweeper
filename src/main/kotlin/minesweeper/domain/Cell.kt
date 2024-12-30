package minesweeper.domain

sealed class Cell(val position: Position) {
    class Mine(position: Position) : Cell(position)
    class Empty(position: Position, val adjacentMines: Int) : Cell(position)
}
