package model

/**
 * Cell is the main node of the grid.
 *
 * It consists of the (x,y) position in the grid.
 *
 * Useful data:
 * - heuristicCost: Heuristic cost of the current cell
 * - finalCost: The calculated final cost
 */

data class Cell(val x: Int, val y: Int) {

    var parent: Cell? = null
    var heuristicCost = 0
    var finalCost = 0
    var solution = false

    override fun toString(): String = "[$x,$y]"
}