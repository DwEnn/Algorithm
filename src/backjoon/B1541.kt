package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
//    BufferedReader(InputStreamReader(System.`in`)).use { br ->
//        var result: Int? = null
//        br.readLine().split("-").forEach {
//            var sum = 0
//            it.split("+").forEach {num ->
//                sum += num.toInt()
//            }
//
//            result = if (result == null) sum else result!! - sum
//        }
//        println(result)
//    }

    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val input = br.readLine()
        var sum = 0
        val list = input.split("-")
        sum = list[0].split("+").sumBy { s -> s.toInt() }
        for (i in 1 until list.size) {
            sum -= list[i].split("+").sumBy { s -> s.toInt() }
        }
        println(sum)
    }
}
