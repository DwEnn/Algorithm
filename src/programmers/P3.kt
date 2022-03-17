package programmers

import java.util.LinkedList
import kotlin.collections.HashMap

/**
 * 메뉴 리뉴얼
 * @link https://programmers.co.kr/learn/courses/30/lessons/72411?language=java
 */
fun main() {
//    val orders = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
//    val course = intArrayOf(2,3,4)

//    val orders = arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD")
//    val course = intArrayOf(2,3,5)

    val orders = arrayOf("XYZ", "XWY", "WXA")
    val course = intArrayOf(2, 3, 4)

    solution(orders, course).forEach {
        println(it)
    }
}

private var courseMap = HashMap<String, Int>()

private fun solution(orders: Array<String>, course: IntArray): Array<String> {
    val answer = LinkedList<String>()

    for (c in course) {
        for (i in orders.indices) {
            comb(orders, i, c, 0, "")
        }
        answer.addAll(decideCourse(courseMap))
        courseMap.clear()
    }

    return answer.sorted().toTypedArray()
}

private fun decideCourse(courseMap: HashMap<String, Int>): LinkedList<String> {

    val entries = LinkedList(courseMap.entries)
    entries.sortWith(
        Comparator { o1, o2 ->
            o2.value.compareTo(o1.value)
        }
    )

    val course = LinkedList<String>()
    var max = 0
    entries.forEach {
        when {
            max == 0 -> {
                if (it.value < 2) return@forEach

                course.add(it.key)
                max = it.value
            }
            it.value == max -> {
                course.add(it.key)
            }
            else -> return@forEach
        }
    }

    return course
}

private fun findCourse(orders: Array<String>, idx: Int, course: String) {
    val course = String(course.toCharArray().sorted().toCharArray())
    if (courseMap[course] != null) return

    var cnt = 1
    for (i in orders.indices) {
        if (i == idx) continue
        val order = orders[i]
        if (order.length < course.length) continue
        var itHasCourse = true
        for (c in course) {
            if (!order.contains(c)) {
                itHasCourse = false
                break
            }
        }
        if (itHasCourse) cnt++
    }
    courseMap[course] = cnt
}

private fun comb(orders: Array<String>, orderIdx: Int, n: Int, idx: Int, str: String) {
    when {
        str.length == n -> {
            findCourse(orders, orderIdx, str)
        }
        idx == orders[orderIdx].length -> return
        else -> {
            comb(orders, orderIdx, n, idx + 1, str)
            comb(orders, orderIdx, n, idx + 1, str + orders[orderIdx][idx])
        }
    }
}
