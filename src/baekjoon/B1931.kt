package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val timeTable = Array(N) { Pair(0, 0) }
        for (i in 0 until N) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            timeTable[i] = Pair(a, b)
        }

        timeTable.sortWith { o1, o2 ->
            if (o1.second == o2.second) o1.first - o2.first
            else o1.second - o2.second
        }

        var currentTime = 0
        var result = 0
        for (time in timeTable) {
            if (time.first >= currentTime) {
                result++
                currentTime = time.second
            }
        }
        println(result)
    }
}
