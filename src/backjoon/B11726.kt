package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        n = br.readLine().toInt()
        dp = IntArray(n + 1) { -1 }
        println(calc(0))
//        println(fibo(n))
    }
}

private var n = 0
private lateinit var dp: IntArray

private fun calc(i: Int): Int {
    if (i == n)
        return 1
    if (dp[i] != -1)
        return dp[i]

    var result = 0
    if (i + 1 <= n)
        result = (result + calc(i + 1)) % 10007
    if (i + 2 <= n)
        result = (result + calc(i + 2)) % 10007

    dp[i] = result
    return result
}
