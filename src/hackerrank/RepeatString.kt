package hackerrank

import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */

fun repeatedString(s: String, n: Long): Long {

    val aCount = s.count { it == 'a' }
    return (n / s.length) * aCount +
            s.slice(0 until (n % s.length).toInt()).count { it == 'a' }
}

fun main(args: Array<String>) {
//    val s = readLine()!!
//    val n = readLine()!!.trim().toLong()

    val s = "aba"
    val n = 10.toLong()
//    val s = "abcac"
//    val n = 10.toLong()

    val result = repeatedString(s, n)

    println(result)
}
