package programmers

/**
 * @link https://programmers.co.kr/learn/courses/30/lessons/43165?language=kotlin
 * 타겟 넘버
 */
fun main() {
    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3
    println(solution(numbers, target))
}

private fun solution(numbers: IntArray, target: Int): Int {
    calc(numbers, 0, target, 0)
    return count
}

private var count = 0

private fun calc(numbers: IntArray, position: Int, target: Int, sum: Int) {
    if (numbers.size - 1 == position) {
        if (sum == target) {
            count++
        }
        return
    }

    calc(numbers, position + 1, target, sum + numbers[position])
    calc(numbers, position + 1, target, sum - numbers[position])
}
