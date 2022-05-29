package hackerrank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var swapCnt = 0
    for (i in arr.indices) {
        if (arr[i] != i + 1) {
            for (j in i until arr.size) {
                if (arr[j] == i + 1) {
                    arr[j] = arr[i]
                    swapCnt++
                    break
                }
            }
        }
    }
    return swapCnt
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)
    println(res)
}
