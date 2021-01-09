package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var result: Int? = null
        br.readLine().split("-").forEach {
            var sum = 0
            it.split("+").forEach {num ->
                sum += num.toInt()
            }

            result = if (result == null) sum else result!! - sum
        }
        println(result)
    }

}
