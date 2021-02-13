import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()
        val sb = StringBuilder()

        repeat(T) {
            var lines = br.readLine().split(" ")
            val M = lines[0].toInt()
            val N = lines[1].toInt()
            val K = lines[2].toInt()
            val graph = Graph(M, N)

            for (i in 0 until K) {
                lines = br.readLine().split(" ")
                graph.put(lines[0].toInt(), lines[1].toInt())
            }

            sb.append(graph.dfsAll()).append("\n")
        }

        println(sb.toString())
    }
}

private class Graph private constructor(){

    lateinit var graph: Array<IntArray>
    lateinit var visited: BooleanArray

    constructor(M: Int, N: Int) : this() {
        graph = Array(M) {
            IntArray(N)
        }
        visited = BooleanArray(M)
    }

    fun put(x: Int, y: Int) {
        graph[x][y] = 1
    }

    fun dfs(idx: Int) {
        print("visit : $idx")
        visited[idx] = true
        for (i in graph[idx].indices) {
            if (graph[idx][i] == 1 && !visited[i])
                dfs(i)
        }
    }

    fun dfsAll(): Int {
        var count = 0
        repeat(graph.size) {
            if (!visited[it]) {
                dfs(it)
                count++
            }
        }
        return count
    }

}
