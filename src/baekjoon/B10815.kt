package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val map = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .groupBy { it }
        val result = StringBuilder()
        br.readLine()
        br.readLine()
            .split(" ")
            .map { it.toInt() }
            .forEach {
                val found = if (map.containsKey(it)) 1 else 0
                result.append(found).append(" ")
            }
        println(result.toString())
    }
}
