package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        dp[1] = 0
        val N = br.readLine().toInt()

        for (i in 1 until N) {
            dp[i+1] = min(dp[i+1], dp[i] + 1)
            if (i*2 < MAX) dp[i*2] = min(dp[i*2], dp[i] + 1)
            if (i*3 < MAX) dp[i*3] = min(dp[i*3], dp[i] + 1)
        }

        println(dp[N])
    }
}
private const val MAX = 1000001
private val dp = IntArray(1000001) { MAX }

//private fun calc(n: Int): Int {
//    if (n == 1)
//        return 0
//    if (dp[n] != -1)
//        return dp[n]
//
//    var result = calc(n - 1) + 1
//
//    if (n % 3 == 0)
//        result = min(result, calc(n / 3) + 1)
//    if (n % 2 == 0)
//        result = min(result, calc(n / 2) + 1)
//
//    dp[n] = result
//    return dp[n]
//}
