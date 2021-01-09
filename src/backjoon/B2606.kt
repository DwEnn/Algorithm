package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        MyGraph(br.readLine().toInt()).run {
            repeat(br.readLine().toInt()) {
                br.readLine().split(" ").let {
                    put(it[0].toInt(), it[1].toInt())
                }
            }
            println(dfs(1))
        }
    }
}

private class MyGraph(val N: Int) {

    private val graph = Array(N + 1) {
        IntArray(N + 1)
    }

    private val visited: BooleanArray = BooleanArray(N + 1)

    fun put(x: Int, y: Int) {
        graph[x][y] = 1
        graph[y][x] = 1
    }

    fun dfs(node: Int): Int {
        visited[node] = true

        var visitedNodes = 0

        for (i in 1..N) {
            if (graph[node][i] == 1 && !visited[i]) {
                visitedNodes++
                visitedNodes += dfs(i)
            }
        }

        return visitedNodes
    }

}
