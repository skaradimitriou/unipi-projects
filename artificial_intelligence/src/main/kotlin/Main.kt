import algorithm.AStarImpl

fun main(args: Array<String>) {
    println("\n")
    println("A* algorithm implementation in Kotlin")
    println("Stathis Karadimitriou - MPPL21024")
    println("\n")

    val array = arrayOf(
        intArrayOf(0, 4),
        intArrayOf(2, 2),
        intArrayOf(3, 1),
        intArrayOf(3, 3),
        intArrayOf(2, 1)
    )

    AStarImpl(5, 5, 0, 0, 4, 4, array).apply {
        init()
        display()
        process()
        displayScores()
        displaySolution()
    }
}