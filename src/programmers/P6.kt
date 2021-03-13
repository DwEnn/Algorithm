package programmers

import java.util.*
import kotlin.math.max

/**
 * 모의고사
 * @link https://programmers.co.kr/learn/courses/30/lessons/42840
 */
fun main() {

//    val answers = intArrayOf(1,2,3,4,5)
    val answers = intArrayOf(1,3,2,4,2)

    solution(answers).forEach { println(it) }
}

private fun solution(answers: IntArray): IntArray {
    val answer = LinkedList<Int>()

    val p1 = intArrayOf(1, 2, 3, 4, 5)
    val p2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val p3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    var score1 = 0
    var score2 = 0
    var score3 = 0

    for (i in answers.indices) {
        val ans = answers[i]
        if (ans == p1[i%p1.size])
            score1 ++
        if (ans == p2[i%p2.size])
            score2 ++
        if (ans == p3[i%p3.size])
            score3 ++
    }

    val max = max(max(score1, score2), score3)
    if (max == score1) answer.add(1)
    if (max == score2) answer.add(2)
    if (max == score3) answer.add(3)

    return answer.toIntArray()
}