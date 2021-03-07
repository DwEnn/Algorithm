package programmers

import java.lang.StringBuilder
import kotlin.math.min

/**
 * 문자열 압축
 * @link https://programmers.co.kr/learn/courses/30/lessons/60057?language=kotlin
 */
fun main() {
//    val s = "aabbaccc" // 7
//    val s = "ababcdcdababcdcd" // 9
//    val s = "abcabcdede" // 8
//    val s = "abcabcabcabcdededededede" // 14
    val s = "xababcdcdababcdcd" // 17


    println(solution(s))
}

private fun solution(s: String): Int {
    var answer = s.length

    for (i in 1..s.length / 2) {
        answer = min(compStr(s, i), answer)
    }

    return answer
}

private fun compStr(s: String, compLen: Int): Int {
    val sb = StringBuilder()
    val compressedStr = StringBuilder()
    val compareStr = StringBuilder()
    var cnt = 1
    for (i in s) {
        if (compressedStr.length == compLen) {
            compareStr.append(i)

            if (compressedStr.length == compareStr.length) {
                if (compressedStr.toString() == compareStr.toString()) {
                    // 비교 문자열 같음
                    cnt++
                    compareStr.clear()
                } else {
                    // 비교 문자열 다름
                    if (cnt > 1)
                        sb.append(cnt)
                    sb.append(compressedStr)
                    compressedStr.clear()
                    compressedStr.append(compareStr)
                    compareStr.clear()
                    cnt = 1
                }
            }
        } else {
            compressedStr.append(i)
        }
    }

    if (cnt > 1)
        sb.append(cnt)
    sb.append(compressedStr)
    if (compareStr.isNotEmpty())
        sb.append(compareStr)

    println(sb.toString())
    return sb.length
}
