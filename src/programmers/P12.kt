package programmers

/**
 * @link https://programmers.co.kr/learn/courses/30/lessons/43162
 * 네트워크
 */
fun main() {
    val n = 3
    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
//    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))
    println(solution(n, computers))
}

private var networksCnt = 0

private fun solution(n: Int, computers: Array<IntArray>): Int {
    visited = BooleanArray(n)

    for (i in computers.indices) {
        if (!visited[i]) {
            networksCnt++
            dfs(computers, i)
        }
    }

    return networksCnt
}

private lateinit var visited: BooleanArray

private fun dfs(computers: Array<IntArray>, index: Int) {
    if (visited[index]) {
        return
    } else {
        visited[index] = true
        for (i in computers[index].indices) {
            if (computers[index][i] == 1 && i != index) {
                dfs(computers, i)
            }
        }
    }
}
