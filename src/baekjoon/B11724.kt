package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use {br ->
        var st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        Graph(N).run {
            repeat(M) {
                st = StringTokenizer(br.readLine())
                put(st.nextToken().toInt(), st.nextToken().toInt())
            }
            println(dfsAll())
        }
    }
}

private class Graph(val N: Int) {

    private val graph = Array(N+1) {
        IntArray(N+1)
    }

    private val visited = BooleanArray(N+1)

    fun put(u: Int, v: Int) {
        graph[u][v] = 1
        graph[v][u] = 1
    }

    fun dfs(idx: Int) {
        visited[idx] = true

        for (i in 1..N) {
            if (graph[idx][i] == 1 && !visited[i])
                dfs(i)
        }
    }

    fun dfsAll(): Int {
        var components = 0
        for (i in 1..N) {
            if (!visited[i]) {
                dfs(i)
                components++
            }
        }
        return components
    }

}