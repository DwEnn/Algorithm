package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val A = HashSet<Int>()
        for (i in 0 until N) {
            val n = br.readLine().toInt()
            A.add(n)
        }

        val result = StringBuilder()
        val M = br.readLine().toInt()
        for (i in 0 until M) {
            val m = br.readLine().toInt()

            if (A.contains(m)) result.append(1).append("\n")
            else result.append(0).append("\n")
        }
        println(result.toString())
    }
}
