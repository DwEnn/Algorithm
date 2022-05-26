package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        println(calc(br.readLine().toInt()))
    }
}

private val dp = IntArray(1000001)

private fun calc(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2

    if (dp[n] != 0) return dp[n]

    dp[n] = (calc(n - 2) + calc(n - 1)) % 15746
    return dp[n]
}