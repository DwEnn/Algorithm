package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private lateinit var dp: Array<LongArray>

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        N = br.readLine().toInt()
        dp = Array(N + 1) { LongArray(2) { -1 } }
//        println(calc(2, true, "1") + 1)
        println(calc(2, 1) + 1)
    }
}

private fun calc(n: Int, isFilledBefore: Int): Long {
    if (n > N) {
        return 0
    }
    if (dp[n][isFilledBefore] != (-1).toLong())
        return dp[n][isFilledBefore]

    var result = calc(n + 1, 0)
    if (isFilledBefore != 1)
        result += calc(n + 1, 1) + 1

    dp[n][isFilledBefore] = result
    return result
}

private fun calc(n: Int, isFilledBefore: Boolean, text: String): Int {
    if (n > N) {
        println(text)
        return 0
    }

    var result = calc(n + 1, false, text + "0")
    if (!isFilledBefore)
        result += calc(n + 1, true, text + "1") + 1

    return result
}