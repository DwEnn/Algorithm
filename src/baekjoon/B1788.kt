package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        val graph = HashMap<Int, MutableList<Int>>()
        val indegrees = IntArray(N) { 0 }
        repeat(M) {
            val (A, B) = br.readLine().split(" ").map { it.toInt() }

            val list = graph.getOrDefault(A, mutableListOf())
            list.add(B)
            graph[A] = list

            indegrees[B - 1] += 1
        }

        val pq = PriorityQueue<Int>()
        for (i in indegrees.indices) {
            if (indegrees[i] == 0)
                pq.add(i + 1)
        }

        val result = LinkedList<Int>()
        while (pq.isNotEmpty()) {
            val p = pq.poll()
            result.add(p)

            if (graph.containsKey(p)) {
                for (node in graph[p]!!) {
                    indegrees[node - 1] -= 1
                    if (indegrees[node - 1] == 0)
                        pq.add(node)
                }
            }
        }
        println(result.joinToString(" "))
    }
}
