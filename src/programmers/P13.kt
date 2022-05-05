@file:OptIn(ExperimentalStdlibApi::class)

package programmers

/**
 * @link https://programmers.co.kr/learn/courses/30/lessons/81301
 * 숫자 문자열과 영단어
 */
fun main() {
    val s = "one4seveneight"
    println(solution(s))
}

private val WORD_ZERO = "zero"
private val WORD_ONE = "one"
private val WORD_TWO = "two"
private val WORD_THREE = "three"
private val WORD_FOUR = "four"
private val WORD_FIVE = "five"
private val WORD_SIX = "six"
private val WORD_SEVEN = "seven"
private val WORD_EIGHT = "eight"
private val WORD_NINE = "nine"

private fun solution(s: String): Int {
    val sb = StringBuilder()
    val temp = StringBuilder()
    for (c in s) {
        if (c.isDigit()) {
            sb.append(c)
        } else {
            temp.append(c)
            val num = when (temp.toString()) {
                WORD_ZERO -> "0"
                WORD_ONE -> "1"
                WORD_TWO -> "2"
                WORD_THREE -> "3"
                WORD_FOUR -> "4"
                WORD_FIVE -> "5"
                WORD_SIX -> "6"
                WORD_SEVEN -> "7"
                WORD_EIGHT -> "8"
                WORD_NINE -> "9"
                else -> null
            }
            num?.let {
                sb.append(it)
                temp.clear()
            }
        }
    }

    return sb.toString().toInt()
}
