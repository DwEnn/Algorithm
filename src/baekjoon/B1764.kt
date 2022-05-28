package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val map = HashMap<String, Int>()
        repeat(N + M) {
            val key = br.readLine()
            val count = map.getOrDefault(key, 0)
            map[key] = count + 1
        }
        val result = map.filter { (key, value) ->
            value > 1
        }.keys.sorted()

        val sb = StringBuilder()
        sb.append(result.size).append("\n")
        result.forEach { sb.append(it).append("\n") }
        println(sb.toString())
    }
}
