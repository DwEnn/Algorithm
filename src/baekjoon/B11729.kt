package baekjoon

import java.lang.StringBuilder

private var cnt: Int = 0
private val sb = StringBuilder()

fun main() {
//    val backjoon.N = readLine()!!.toInt()
    val N = 3
    hanoi(N, 1, 2, 3)
    println(cnt)
    println(sb.toString())
}

fun hanoi(n: Int, from: Int, by: Int, to: Int) {
    cnt++
    if (n == 1) {
        sb.append("$from $to\n")
        return
    } else {
        hanoi(n-1, from, to, by)
        sb.append("$from $to\n")
        hanoi(n-1, by, from, to)
    }
}