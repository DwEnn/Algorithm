package programmers

/**
 * N으로 표현
 * @link https://programmers.co.kr/learn/courses/30/lessons/42895
 */
fun main() {
    val N = 5
    val number = 12
    println(solution(N, number))
}

private fun solution(N: Int, number: Int): Int {
    var n = 0
    val set = Array(9) {
        if (it != 0) n = (n * 10) + N
        hashSetOf(n)
    }

    for (i in 1..8) {
        for (j in 1..i) {
            val xSet = HashSet<Int>(set[j])
            val ySet = HashSet<Int>(set[i - j])

            for (x in xSet) {
                for (y in ySet) {
                    set[i].add(x + y)
                    set[i].add(x - y)
                    set[i].add(x * y)

                    if (x != 0)
                        set[i].add(y / x)
                    if (y != 0)
                        set[i].add(x / y)
                }
            }
        }
        if (set[i].contains(number)) {
            return i
        }
    }

    return -1
}
