package programmers

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=kotlin
 */
fun main() {
    val tc1 = Pair(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))
    val tc2 = Pair(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))

    var answer = solution(tc1.first, tc1.second)
    println(answer)
    answer = solution(tc2.first, tc2.second)
    println(answer)
}

private fun solution(k: Int, tangerine: IntArray): Int {
    var answer: Int = 0

    var count = 0
    tangerine
        .groupBy { it }.values
        .sortedByDescending { it.count() }
        .forEach {
            if (count >= k) {
                return@forEach
            } else {
                count += it.count()
            }

            answer++
        }

    return answer
}