package backjoon

import java.lang.StringBuilder

fun main() {
    val N = readLine()!!.toInt()
    val sb = StringBuilder()

    for (i in 1..N) {
        if (i != N) {
            repeat(N - i) {
                sb.append(" ")
            }

            val n = (2 * i) - 1
            repeat(n) {
                if (it == 0 || it == n - 1)
                    sb.append("*")
                else
                    sb.append(" ")
            }

            sb.append("\n")
        } else {
            repeat((2 * N) - 1) {
                sb.append("*")
            }
        }
    }
    println(sb.toString())
}