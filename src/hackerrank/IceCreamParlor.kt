package hackerrank

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'whatFlavors' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY cost
 *  2. INTEGER money
 */

fun whatFlavors(cost: Array<Int>, money: Int) {
    val map = HashMap<Int, Int>()
    for ((i, value) in cost.withIndex()) {
        val index = map.getOrDefault(value, -1)
        if (index != -1) {
            println("${index + 1} ${i + 1}")
            return
        } else {
            val exchange = money - value
            map[exchange] = i
        }
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val money = readLine()!!.trim().toInt()

        val n = readLine()!!.trim().toInt()

        val cost = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        whatFlavors(cost, money)
    }
}
