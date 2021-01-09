package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private lateinit var visited: Array<Boolean>
private lateinit var graph: Array<IntArray>

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        N = br.readLine().toInt()
        val find = br.readLine().split(" ").map { it.toInt() }

        visited = Array(N +1) { false }
        graph = Array(N +1) { IntArray(N +1) }

        repeat(br.readLine().toInt()) {
            val nums = br.readLine().split(" ").map { it.toInt() }

            graph[nums[0]][nums[1]] = 1
            graph[nums[1]][nums[0]] = 1
        }

        dfs(find[0], find[1], 0)

        if (isFound)
            println(level)
        else
            println(-1)
    }
}

private var isFound = false
private var level = 0

private fun dfs(node: Int, find: Int, l: Int) {
    if (node == find) {
        isFound = true
        level = l
        return
    }

    visited[node] = true

    for (i in 1..N) {
        if (isFound)
            return

        if (!visited[i] && graph[node][i] == 1)
            dfs(i, find, l+1)

    }
}