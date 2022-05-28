package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, P, Q) = br.readLine().split(" ").map { it.toLong() }

        dp = HashMap()
        dp[0] = 1

        println(calc(P, Q, N))
    }
}

private lateinit var dp: HashMap<Long, Long>

private fun calc(P: Long, Q: Long, num: Long): Long {
    if (num == 0L) return 1L
    if (dp[num] != null) return dp[num]!!

    dp[num] = calc(P, Q, num / P) + calc(P, Q, num / Q)
    return dp[num]!!
}
