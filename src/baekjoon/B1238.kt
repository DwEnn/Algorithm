package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M, X) = br.readLine().split(" ").map { it.toInt() }

        val graph = HashMap<Int, MutableList<Pair<Int, Int>>>()
        val reverseGraph = HashMap<Int, MutableList<Pair<Int, Int>>>()

        repeat(M) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            var list = graph.getOrDefault(a, mutableListOf())
            list.add(Pair(b, c))
            graph[a] = list

            list = reverseGraph.getOrDefault(b, mutableListOf())
            list.add(Pair(a, c))
            reverseGraph[b] = list
        }

        val timeTable = IntArray(M + 1) { Int.MAX_VALUE }
        val reverseTimeTable = IntArray(M + 1) { Int.MAX_VALUE }

        search(graph, timeTable, X)
        search(reverseGraph, reverseTimeTable, X)

        var answer = 0
        timeTable.zip(reverseTimeTable) { a, b ->
            a + b
        }.onEach {
            answer = Math.max(answer, it)
        }
        println(answer)
    }
}

private fun search(graph: HashMap<Int, MutableList<Pair<Int, Int>>>, timeTable: IntArray, src: Int) {
    val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        o1.second - o2.second
    }

    timeTable[src] = 0
    pq.add(Pair(src, 0))

    while (pq.isNotEmpty()) {
        val p = pq.poll()
        val vertex = p.first
        val distance = p.second

        if (timeTable[vertex] < distance) continue

        for (node in graph[vertex]!!) {
            if (timeTable[node.first] > timeTable[vertex] + node.second) {
                timeTable[node.first] = timeTable[vertex] + node.second
                pq.add(Pair(node.first, timeTable[node.first]))
            }
        }
    }
}
