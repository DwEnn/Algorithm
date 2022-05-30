package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var N = 1
        var playCount = 1
        val result = StringBuilder()
        while (true) {
            N = br.readLine().toInt()
            if (N == 0) break

            val board = Array(N) { IntArray(N) }
            val scoreTable = Array(N) { IntArray(N) { Int.MAX_VALUE } }

            repeat(N) { i ->
                br.readLine().split(" ").forEachIndexed { j, s ->
                    board[i][j] = s.toInt()
                }
            }

            result.append("Problem ")
                .append(playCount++)
                .append(": ${search(board, scoreTable)}")
                .append("\n")
        }
        println(result.toString())
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun search(board: Array<IntArray>, scoreTable: Array<IntArray>): Int {
    val pq = PriorityQueue<Triple<Int, Int, Int>> { o1, o2 ->
        o1.third - o2.third
    }
    pq.add(Triple(0, 0, 0))
    scoreTable[0][0] = board[0][0]

    while (pq.isNotEmpty()) {
        val top = pq.poll()
        val pX = top.first
        val pY = top.second
        val distance = top.third

        if (scoreTable[pX][pY] < distance) continue

        repeat(4) {
            val x = pX + dx[it]
            val y = pY + dy[it]
            if (x in board.indices && y in board.indices) {
                if (scoreTable[x][y] > scoreTable[pX][pY] + board[x][y]) {
                    scoreTable[x][y] = scoreTable[pX][pY] + board[x][y]
                    pq.add(Triple(x, y, scoreTable[x][y]))
                }
            }
        }
    }

    return scoreTable.last().last()
}
