package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {

    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val inp = br.readLine().split(" ")
        val N = inp[0].toInt()
        val M = inp[1].toInt()

        val arr = arrayOfNulls<CharArray>(N)
        repeat(N) {
            arr[it] = br.readLine().toCharArray()
        }

        var result = 64
        for (i in arr.indices) for (j in arr[i]!!.indices) {
            if (i + 7 < arr.size && j + 7 < arr[i]!!.size)
                result = min(calc(arr, i, j), result)
        }
        println(result)
    }

}

private fun calc(arr: Array<CharArray?>, a: Int, b: Int): Int {
    val bw = arrayOf(arrayOf('B', 'W'), arrayOf('W', 'B'))
    val wb = arrayOf(arrayOf('W', 'B'), arrayOf('B', 'W'))

    var result = 64
    repeat(2) {
        val colors = if (it%2 == 0) bw else wb

        var cnt = 0
        for (i in a..a+7) {
            val chars = arr[i]
            for (j in b..b+7) {
                val c = chars!![j]
                if (colors[i%2][j%2] != c)
                    cnt++
            }
        }
        result = min(cnt, result)
    }
    return result
}
