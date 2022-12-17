package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val min = PriorityQueue<Int>()
        val max = PriorityQueue<Int>(Comparator.reverseOrder())

        val sb = StringBuilder()
        repeat(N) {
            val x = br.readLine().toInt()

            if (max.size == min.size) {
                max.add(x)
            } else {
                min.add(x)
            }

            if (min.isNotEmpty() && max.peek() > min.peek()) {
                min.add(max.poll())
                max.add(min.poll())
            }

            sb.append("${max.peek()}\n")
        }
        println(sb.toString())
    }
}
