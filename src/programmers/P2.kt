package programmers

/**
 * JadenCase 문자열 만들기
 * @link(https://programmers.co.kr/learn/courses/30/lessons/12951)
 */
fun main() {
    val s = "3people unFollowed me"
//    val s = "3people  me"
//    val s = "for the last week"
//    val s = "    last week"
//    val s = ""
    println(solution(s))
}

private fun solution(s: String): String {
    var answer = ""

    val s = s.toLowerCase()
    answer = s.split(" ").joinToString(separator = " ") {
        if (it.isNotEmpty() && it[0].isLetter() && it[0].isLowerCase()) {
            "${it[0].toUpperCase()}${it.substring(1)}"
        } else
            it
    }

    return answer
}
