package basic

import java.util.LinkedList

fun main() {
    val graph = Graph(9)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 5)
    graph.addEdge(3, 5)
    graph.addEdge(4, 5)
    graph.addEdge(2, 6)
    graph.addEdge(2, 8)
    graph.addEdge(6, 7)
    graph.addEdge(6, 8)
    graph.sortList()
    graph.bfs()
}

private class Graph(
    private var N: Int // 정점의 개수
) {

    private val adj = MutableList<MutableList<Int>>(N) { mutableListOf() }

    fun addEdge(u: Int, v: Int) {
        adj[u].add(v)
        adj[v].add(u)
    }

    fun sortList() {
        adj.map {
            it.sorted()
        }
    }

    fun bfs() {
        val visited = BooleanArray(N)
        val queue = LinkedList<Int>()
        queue.push(0)
        visited[0] = true

        var level = 0
        while (!queue.isEmpty()) {
            val size = queue.size
            println("--------- level $level ---------")
            for (i in 0 until size) {
                val curr = queue.poll()
                println("node $curr visited")
                for (next in adj[curr]) {
                    if (!visited[next]) {
                        visited[next] = true
                        queue.add(next)
                    }
                }
            }
            level ++
        }
    }
}
