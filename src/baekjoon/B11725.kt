package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val graph = HashMap<Int, MutableList<Int>>()
        repeat(N - 1) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }

            var list = graph.getOrDefault(a, mutableListOf())
            list.add(b)
            graph[a] = list

            list = graph.getOrDefault(b, mutableListOf())
            list.add(a)
            graph[b] = list
        }

        val queue = LinkedList<Int>()
        val visited = BooleanArray(N)
        queue.add(1)
        val parents = IntArray(N) { 0 }

        while (queue.isNotEmpty()) {
            val p = queue.poll()

            if (graph.contains(p)) {
                for (node in graph[p]!!) {
                    if (!visited[node - 1]) {
                        visited[node - 1] = true
                        queue.add(node)
                        parents[node - 1] = p
                    }
                }
            }
        }

        println(parents.drop(1).joinToString("\n"))
    }
}
