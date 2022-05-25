package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        // index -> 과목번호 (0, 과목번호 1)
        // value -> 선수 과목의 개수
        val indegree = IntArray(N) { -1 }
        // <from, List<to>>
        val graph = HashMap<Int, MutableList<Int>>()
        repeat(M) {
            val (A, B) = br.readLine().split(" ").map { it.toInt() }

            indegree[B - 1] += 1
            val l = graph.getOrDefault(A, mutableListOf())
            l.add(B)
            graph[A] = l
        }

        // <과목번호, 학기>
        val queue = LinkedList<Pair<Int, Int>>()
        for (i in 1..indegree.size) {
            if (indegree[i - 1] == 0)
                queue.add(Pair(i, 1))
        }

        val result = IntArray(N)
        while (queue.isNotEmpty()) {
            val p = queue.poll()
            result[p.first - 1] = p.second

            if (graph.containsKey(p.second)) {
                for (node in graph[p.second]!!) {
                    indegree[node - 1] -= 1
                    if (indegree[node - 1] == 0) {
                        queue.add(Pair(node, p.second + 1))
                    }
                }
            }
        }

        println(result.joinToString { " " })
    }
}
