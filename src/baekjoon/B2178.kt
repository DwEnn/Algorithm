package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        board = MutableList(N) { mutableListOf() }
        repeat(N) { index ->
            board[index] = br.readLine().map { Character.getNumericValue(it) }.toMutableList()
        }

        println(search())
    }
}

private lateinit var board: MutableList<MutableList<Int>>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private class Point(val x: Int, val y: Int)

private fun Point.isReachedGoal(x: Int, y: Int): Boolean {
    return this.x == x && this.y == y
}

private fun search(): Int {
    val visited = Array(board.size) { BooleanArray(board[0].size) }
    val queue = LinkedList<Point>()

    visited[0][0] = true
    queue.add(Point(0, 0))

    var level = 0
    var isReachedGoal = false
    while (!queue.isEmpty() && !isReachedGoal) {
        val size = queue.size
        repeat(size) {
            val curr = queue.poll()
            if (curr.isReachedGoal(visited.size - 1, visited[0].size - 1)) {
                isReachedGoal = true
                return@repeat
            }

            repeat(4) {
                val x = dx[it] + curr.x
                val y = dy[it] + curr.y
                if (x in 0 until board.size && y in 0 until board[0].size) {
                    if (board[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true
                        queue.add(Point(x, y))
                    }
                }
            }
        }
        level ++
    }

    return level
}