package baekjoon

import kotlin.math.max
import kotlin.math.min

lateinit var H: Array<Int>

fun main() {
//    val backjoon.N = readLine()!!.toInt()
    val N = 7
//    backjoon.getH = Array(backjoon.N) {
//        readLine()!!.toInt()
//    }
    H = arrayOf(2, 1, 4, 5, 1, 3, 3)

    println(histogram(0, N))
}

private fun histogram(s: Int, e: Int): Int {
    // base case: 넓이 0
    if (s == e)
        return 0

    // base case: 넓이 1
    if (s + 1 == e)
        return H[s]

    val mid = (s + e) / 2
    // 각 양쪽 구간의 최댓값
    var result = max(histogram(s, mid), histogram(mid, e))

    // 양쪽 구간에 걸쳐 있는 답을 0(e-s)에 찾음
    var w = 1
    var h = H[mid]
    var l = mid
    var r = mid
    while (r - l + 1 < e - s) {
        // 왼쪽으로 확장했을 경우의 높이
        val p = if (l > s) min(h, H[l - 1]) else -1
        // 오른쪽으로 확장했을 경우의 높이
        val q = if (r < e - 1) min(h, H[r + 1]) else -1
        // 더 높은(같은) 높이를 가진 쪽으로 확장
        if (p >= q) {
            h = p
            l--
        } else {
            h = q
            r++
        }
        result = max(result, ++w * h)
    }

    return result
}