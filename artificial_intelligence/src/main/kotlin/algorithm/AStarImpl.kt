package algorithm

import model.Cell
import java.util.*
import kotlin.math.abs

class AStarImpl(
    private val width: Int,
    private val height: Int,
    private val si: Int,
    private val sj: Int,
    private val ei: Int,
    private val ej: Int,
    private val blocks: Array<IntArray>
) : AStarAlgorithm {

    companion object {
        const val DIAGONAL_COST = 14
        const val V_H_COST = 10
    }

    /*
     * Defines the grid of our a* algorithm.
     */

    private lateinit var grid: Array<Array<Cell?>>

    /*
     * A Priority Queue is defined for open cells.
     * Open Cells : the set of nodes to be evaluated (we put cells with lowest cost in first)
     */

    private var openCells: PriorityQueue<Cell?>? = null

    /*
     * Closed Cells : the set of nodes already evaluated
     */

    private lateinit var closedCells: Array<BooleanArray>

    /*
     * Helper variables
     */

    private var startI = 0
    private var startJ = 0
    private var endI = 0
    private var endJ = 0

    override fun init() {
        grid = Array(width) { arrayOfNulls(height) }
        closedCells = Array(width) { BooleanArray(height) }
        openCells = PriorityQueue { c1: Cell?, c2: Cell? ->
            when {
                c1!!.finalCost < c2!!.finalCost -> -1
                c1.finalCost > c2.finalCost -> 1
                else -> 0
            }
        }

        setStartCell(si, sj)
        setEndCell(ei, ej)

        //init heuristic
        grid.indices.forEach { i ->
            grid[i].indices.forEach { j ->
                grid[i][j] = Cell(i, j)
                grid[i][j]!!.heuristicCost = abs(i - endI)
                grid[i][j]!!.solution = false
            }
        }

        grid[startI][startJ]!!.finalCost = 0

        blocks.indices.forEach { addBlockOnCell(blocks[it][0], blocks[it][1]) }
    }

    private fun setStartCell(si: Int, sj: Int) {
        startI = si
        startJ = sj
    }

    private fun setEndCell(ei: Int, ej: Int) {
        endI = ei
        endJ = ej
    }

    private fun addBlockOnCell(i: Int, j: Int) = apply { grid[i][j] = null }

    private fun updateCostIfNeeded(current: Cell?, t: Cell?, cost: Int) {
        if (t == null || closedCells[t.x][t.y]) return

        val finalCost = t.heuristicCost + cost
        val isOpen = openCells!!.contains(t)

        if (!isOpen || finalCost < t.finalCost) {
            t.finalCost = finalCost
            t.parent = current
            if (!isOpen) {
                openCells!!.add(t)
            }
        }
    }

    override fun process() {
        openCells!!.add(grid[startI][startJ])
        var current: Cell?

        while (true) {
            current = openCells!!.poll()

            if (current == null) break

            closedCells[current.x][current.y] = true

            if (current == grid[endI][endJ]) return

            var t: Cell?

            if (current.x - 1 >= 0) {
                t = grid[current.x - 1][current.y]
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST)
                if (current.y - 1 >= 0) {
                    t = grid[current.x - 1][current.y - 1]
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST)
                }
                if (current.y + 1 < grid[0].size) {
                    t = grid[current.x - 1][current.y + 1]
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST)
                }
            }

            if (current.y - 1 >= 0) {
                t = grid[current.x][current.y - 1]
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST)
            }
            if (current.y + 1 < grid[0].size) {
                t = grid[current.x][current.y + 1]
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST)
            }

            if (current.x + 1 < grid.size) {
                t = grid[current.x + 1][current.y]
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST)
                if (current.y - 1 >= 0) {
                    t = grid[current.x + 1][current.y - 1]
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST)
                }
                if (current.y + 1 < grid[0].size) {
                    t = grid[current.x + 1][current.y + 1]
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST)
                }
            }
        }
    }

    override fun display() {
        println("Grid: ")

        grid.indices.forEach { i ->
            grid[i].indices.forEach { j ->
                when {
                    i == startI && j == startJ -> print("S0  ") // source cell
                    i == endI && j == endJ -> print("DE  ") //destination cell
                    grid[i][j] != null -> System.out.printf("%-3d ", 0)
                    else -> print("BL  ") // block cell
                }
            }
            println()
        }
        println()
    }

    override fun displayScores() {
        println("\nScores for cells: \n")
        grid.indices.forEach { i ->
            grid[i].indices.forEach { j ->
                grid[i][j]?.let {
                    System.out.printf("%-3d ", grid[i][j]!!.finalCost)
                } ?: kotlin.run {
                    print("BL  ")
                }
            }
            println()
        }
        println()
    }

    override fun displaySolution() {
        if (closedCells[endI][endJ]) {
            //track back the path
            displayPath()

            grid.indices.forEach { i ->
                grid[i].indices.forEach { j ->
                    when {
                        i == startI && j == startJ -> print("S0  ") // source cell
                        i == endI && j == endJ -> print("DE  ") //destination cell
                        grid[i][j] != null -> System.out.printf("%-3s ", if (grid[i][j]!!.solution) "X" else 0)
                        else -> print("BL  ") // block cell
                    }
                }
                println()
            }
            println()
        } else {
            println("No possible path")
        }
    }

    private fun displayPath() {
        val path = mutableListOf<Cell?>()

        var current = grid[endI][endJ]
        path.add(current)
        grid[current!!.x][current.y]!!.solution = true

        while (current!!.parent != null) {
            path.add(current.parent)
            grid[current.parent!!.x][current.parent!!.y]!!.solution = true
            current = current.parent
        }

        println("In order to go from $startI,$startJ to $endI,$endJ, this is the shortest path:")
        println(path.reversed().joinToString(" -> "))
        println("Total path cost: ${path.firstOrNull()?.finalCost}")
        print("\n")
    }
}