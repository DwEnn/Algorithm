package programmers

import java.lang.StringBuilder

/**
 * 괄호 변환
 * @link https://programmers.co.kr/learn/courses/30/lessons/60058
 */
fun main() {
    val p = "(()())()"
//    val p = ")("
//    val p = "()))((()"
//    val p = ""

    println(solution(p))
}

private fun solution(p: String): String {
    return calc(p)
}

private const val left = '('
private const val right = ')'

private fun calc(p: String): String {
    if (p.isEmpty())
        return ""

    val balanceStr = balancedStr(p)
    val u = balanceStr.first
    val v = balanceStr.second
    if (checkCorrectStr(u)) {
        return u + calc(v)
    } else {
        val genStr = StringBuilder().append(left)
        genStr.append(calc(v)).append(right)
        val temp = u.filterIndexed { index, c ->
            index != 0 && index != u.length - 1
        }.map {
            if (it == left) right
            else left
        }.toCharArray().let { String(it) }
        genStr.append(temp)
        return genStr.toString()
    }
}

private fun balancedStr(p: String): Pair<String, String> {
    var leftCnt = 0
    var rightCnt = 0
    val u = StringBuilder()
    val v = StringBuilder()
    var findBalancedStr = false

    for (i in p) {
        if (findBalancedStr)
            v.append(i)
        else {
            u.append(i)

            if (i == left) leftCnt++
            else if (i == right) rightCnt++

            findBalancedStr = leftCnt == rightCnt
        }
    }

    return kotlin.Pair(u.toString(), v.toString())
}

private fun checkCorrectStr(p: String): Boolean {
    var cnt = 0
    for (i in p) {
        if (i == left) cnt++
        else if (i == right) cnt--

        if (cnt < 0) return false
    }
    return cnt == 0
}
