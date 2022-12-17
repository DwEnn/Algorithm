package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        val graph = HashMap<Int, MutableList<Int>>()
        val indegree = IntArray(N) { 0 }
        repeat(M) {
            val (A, B) = br.readLine().split(" ").map { it.toInt() }

            indegree[B - 1] += 1
            val list = graph.getOrDefault(A, mutableListOf())
            list.add(B)
            graph[A] = list
        }

        val queue = LinkedList<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) queue.add(i + 1)
        }

        val result = LinkedList<Int>()
        while (queue.isNotEmpty()) {
            val p = queue.poll()
            result.add(p)

            if (graph.containsKey(p)) {
                for (node in graph[p]!!) {
                    indegree[node - 1] -= 1
                    if (indegree[node - 1] == 0)
                        queue.add(node)
                }
            }
        }

        println(result.joinToString(" "))
    }
}
