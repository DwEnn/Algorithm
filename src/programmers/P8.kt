package programmers

/**
 * 3진법 뒤집기
 * @link(https://programmers.co.kr/learn/courses/30/lessons/68935)
 */
fun main() {
    val n = 45
//    val n = 125
    println(solution(n))
}

private fun solution(n: Int): Int {
    var answer: Int = 0

    var n = n
    var str = ""
    while (n > 0) {
        str += n % 3
        n /= 3
    }

    str.forEachIndexed { index, c ->
        if (c != '0') {
            var multiply = 1
            repeat(str.length - index - 1) {
                multiply *= 3
            }

            answer += Character.getNumericValue(c) * multiply
        }
    }

    return answer
}
