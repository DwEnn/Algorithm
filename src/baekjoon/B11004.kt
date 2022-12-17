package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val pq = PriorityQueue<Int>()
        val st = StringTokenizer(br.readLine())
        while (st.hasMoreTokens()) {
            pq.add(st.nextToken().toInt())
        }
        var answer = 0
        repeat(K) {
            answer = pq.poll()
        }
        println(answer)
    }
}
