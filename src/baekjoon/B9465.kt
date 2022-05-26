package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()
        repeat(T) {
            n = br.readLine().toInt()
            sticker = Array(2) { IntArray(n) }
            dp = Array(n) { IntArray(3) { -1 } }
            for (i in sticker.indices) {
                val st = StringTokenizer(br.readLine())
                for (j in sticker[i].indices) {
                    sticker[i][j] = st.nextToken().toInt()
                }
            }
            println(collect(0, 0))
        }
    }
}

private var n = 0
private lateinit var sticker: Array<IntArray>
private lateinit var dp: Array<IntArray>

private fun collect(i: Int, status: Int): Int {
    if (i == n)
        return 0
    if (dp[i][status] != -1)
        return dp[i][status]

    var result = collect(i + 1, 2)
    if (status != 0)
        result = max(result, collect(i + 1, 0) + sticker[0][i])
    if (status != 1)
        result = max(result, collect(i + 1, 1) + sticker[1][i])

    dp[i][status] = result
    return result
}
