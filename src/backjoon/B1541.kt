package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        br.readLine().split("-")
            .map { list ->
                list.split("+").map { it.toInt() }.sum()
            }.reduce { acc, i ->
                acc - i
            }.let { println(it) }
    }
}
