package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val seq = br.readLine().split(" ").map { it.toInt() }
        val memo = IntArray(N) { 1 }

        for (i in 0 until N) {
            for (j in 0 until i) {
                if (seq[j] < seq[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i])
                }
            }
        }

        var answer = 0
        memo.forEach {
            answer = Math.max(it, answer)
        }
        println(answer)
    }
}
