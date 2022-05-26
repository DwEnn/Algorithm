package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        // 666, 1666, 2666, .. 5666, 6660, 6661, 6662, 6663 .. 6669, 7666,
        val N = br.readLine().toInt()
        var targetNum = 665
        var cnt = 0
        while (cnt < N) {
            targetNum++

            var matchCnt = 0
            targetNum.toString().forEach {
                matchCnt = if (it == '6') matchCnt + 1 else 0
                if (matchCnt == 3) {
                    cnt++
                    return@forEach
                }
            }
        }

        println(targetNum)
    }
}

//fun main() {
//    BufferedReader(InputStreamReader(System.`in`)).use {
//        println(getMovieName(it.readLine().toInt()))
//    }
//}
//
//fun getMovieName(N: Int): Int {
//    var cnt = 0
//    var name = 665
//    while (cnt != N) {
//        name++
//
//        if (name.toString().contains("666"))
//            cnt++
//    }
//
//    return name
//}

