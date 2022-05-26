package programmers

import java.util.PriorityQueue

/**
 * 배달
 * @link https://programmers.co.kr/learn/courses/30/lessons/12978
 */
fun main() {
//    val N = 5
//    val road = arrayOf(
//        intArrayOf(1, 2, 1),
//        intArrayOf(2, 3, 3),
//        intArrayOf(5, 2, 2),
//        intArrayOf(1, 4, 2),
//        intArrayOf(5, 3, 1),
//        intArrayOf(5, 4, 2)
//    )
//    val K = 3

    val N = 6
    val road = arrayOf(
        intArrayOf(1, 2, 1),
        intArrayOf(1, 3, 2),
        intArrayOf(2, 3, 2),
        intArrayOf(3, 4, 3),
        intArrayOf(3, 5, 2),
        intArrayOf(3, 5, 3),
        intArrayOf(5, 6, 1)
    )
    val K = 4

    println(solution(N, road, K))
}

private fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
    graph = HashMap()
    distance = Array(N + 1) { IntArray(N + 1) }

    for ((a, b, c) in road) {
        var l = graph.getOrDefault(a, mutableListOf())
        l.add(Node(a, b, c))
        graph[a] = l

        l = graph.getOrDefault(b, mutableListOf())
        l.add(Node(b, a, c))
        graph[b] = l
    }

    return search(1).count { it <= k }
}

private class Node(val from: Int, val to: Int, val weight: Int)
private lateinit var distance: Array<IntArray>
private lateinit var graph: HashMap<Int, MutableList<Node>>

private fun search(src: Int): IntArray {
    val dist = IntArray(distance.size) { Int.MAX_VALUE }
    dist[src] = 0

    val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        o1.second.compareTo(o2.second)
    }
    pq.add(Pair(src, 0))

    while (pq.isNotEmpty()) {
        val top = pq.poll()
        val vertex = top.first
        val path = top.second

        if (dist[vertex] < path) continue

        for (node in graph[vertex]!!) {
            if (dist[node.to] > dist[vertex] + node.weight) {
                dist[node.to] = dist[vertex] + node.weight
                pq.add(Pair(node.to, dist[node.to]))
            }
        }
    }
    return dist
}
