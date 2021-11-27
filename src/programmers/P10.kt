package programmers

/**
 * 빛의 경로 사이클
 * @link https://programmers.co.kr/learn/courses/30/lessons/86052?language=kotlin
 */
fun main() {
//    val grid = arrayOf("SL", "LR")
    val grid = arrayOf("R", "R")
//    val grid = arrayOf("S")
    solution(grid).forEach { println(it) }
}

private lateinit var visit: Array<Array<BooleanArray>>
private lateinit var board: Array<String>
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private var startPoint = ""

private var X = 0
private var Y = 0

private fun solution(grid: Array<String>): IntArray {
    val answer = mutableListOf<Int>()

    board = grid
    X = grid.size
    Y = grid[0].length
    visit = Array(X) { Array(Y) { BooleanArray(4) } }

    for (i in board.indices) {
        for (j in board[i].indices) {
            repeat(4) {
                startPoint = "$i$j$it"
                val result = cycle(i, j, it) + 1
                if (result > 0)
                    answer.add(result)
            }
        }
    }

    return answer.sorted().toIntArray()
}

private fun cycle(x: Int, y: Int, dir: Int): Int {

    var x = x + dx[dir]
    var y = y + dy[dir]

    val result: Int
    if (x !in 0 until X) {
        x = if (x < 0) X
        else -1
        result = cycle(x, y, dir)
    } else if (y !in 0 until Y) {
        y = if (y < 0) Y
        else -1
        result = cycle(x, y, dir)
    } else {

        if (visit[x][y][dir])
            return Int.MAX_VALUE

        visit[x][y][dir] = true
        val dir = when (board[x][y]) {
            'L' -> {
                if (dir != 3) dir + 1
                else 0
            }
            'R' -> {
                if (dir != 0) dir - 1
                else 3
            }
            else -> dir
        }
        if ("$x$y$dir" == startPoint)
            return 0
        result = cycle(x, y, dir) + 1
    }

    return result
}