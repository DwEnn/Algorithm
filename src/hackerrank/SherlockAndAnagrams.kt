package hackerrank

import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.collections.HashMap

/*
 * Complete the 'sherlockAndAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun sherlockAndAnagrams(s: String): Int {
    val map = HashMap<String, Int>()
    for (i in s.indices) {
        for (j in i + 1..s.length) {
            val key = s.substring(i, j).toCharArray()
                .sorted()
                .map { it.toString() }
                .reduce(String::plus)
            val count = map.getOrDefault(key, 0)
            map[key] = count + 1
        }
    }
    return map.values.sumBy { it * (it - 1) / 2 }
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
