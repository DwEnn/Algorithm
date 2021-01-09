package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use {
        println(getMovieName(it.readLine().toInt()))
    }
}

fun getMovieName(N: Int): Int {
    var cnt = 0
    var name = 665
    while (cnt != N) {
        name++

        if (name.toString().contains("666"))
            cnt++
    }

    return name
}
