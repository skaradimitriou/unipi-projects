package algorithm

/**
 * [AStarAlgorithm] contains the necessary logic for the A* Algorithm.
 */

interface AStarAlgorithm {

    /**
     * Method that inits the grid and any necessary actions that should be taken.
     */
    fun init()

    /**
     * Method that displays the grid
     */

    fun display()

    /**
     * Method that processes the user's input
     */

    fun process()

    /**
     * This method displays the scores in the grid
     */

    fun displayScores()

    /**
     * This method displays the solution from the grid
     */

    fun displaySolution()
}