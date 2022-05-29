package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val timeTable = Array(N) { Pair(0, 0) }
        for (i in 0 until N) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            timeTable[i] = Pair(a, b)
        }
        timeTable.sortWith { o1, o2 ->
            if (o1.first == o2.first)
                o1.second - o2.second
            else
                o1.first - o2.first
        }

        val pq = PriorityQueue<Int>()
        pq.add(timeTable[0].second)

        for (i in 1 until timeTable.size) {
            if (timeTable[i].first < pq.peek()) {
                pq.add(timeTable[i].second)
            } else {
                pq.poll()
                pq.add(timeTable[i].second)
            }
        }

        println(pq.size)
    }
}
