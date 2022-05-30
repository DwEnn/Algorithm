package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val array = Array(N) { Pair(0, 0) }
        repeat(N) {
            val (W, V) = br.readLine().split(" ").map { it.toInt() }
            array[it] = Pair(W, V)
        }

        val dp = Array(N + 1) { IntArray(K + 1) { 0 } }
        for (i in 1..N) {
            val item = array[i - 1]
            for (j in 1..K) {
                dp[i][j] = dp[i - 1][j]
                if (j - item.first >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.first] + item.second)
                }
            }
        }
        println(dp[N][K])
    }
}
