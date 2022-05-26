package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private lateinit var visited: Array<Boolean>
private lateinit var graph: Array<IntArray>

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        N = br.readLine().toInt()
        val find = br.readLine().split(" ").map { it.toInt() }

        visited = Array(N + 1) { false }
        graph = Array(N + 1) { IntArray(N + 1) }

        repeat(br.readLine().toInt()) {
            val nums = br.readLine().split(" ").map { it.toInt() }

            graph[nums[0]][nums[1]] = 1
            graph[nums[1]][nums[0]] = 1
        }

        dfs(find[0], find[1], 0)

        if (isFound)
            println(level)
        else
            println(-1)
    }
}

private var isFound = false
private var level = 0

private fun dfs(node: Int, find: Int, l: Int) {
    if (node == find) {
        isFound = true
        level = l
        return
    }

    visited[node] = true

    for (i in 1..N) {
        if (isFound)
            return

        if (!visited[i] && graph[node][i] == 1)
            dfs(i, find, l + 1)
    }
}

// private lateinit var graph: MutableList<MutableList<Int>>
//
// fun main() {
//    BufferedReader(InputStreamReader(System.`in`)).use { br ->
//        val N = br.readLine().toInt()
//        val find = br.readLine().split(" ").map { it.toInt() }
//        val m = br.readLine().toInt()
//
//        graph = MutableList(N + 1) { mutableListOf() }
//        repeat(m) {
//            val line = br.readLine().split(" ").map { it.toInt() }
//            graph[line[0]].add(line[1])
//            graph[line[1]].add(line[0])
//        }
//
//        println(search(find[0], find[1]))
//    }
// }
//
// private fun search(start: Int, find: Int): Int {
//    val queue = LinkedList<Int>()
//    queue.add(start)
//    val visited = BooleanArray(graph.size)
//
//    var level = -1
//    var found = false
//    while (!queue.isEmpty() && !found) {
//        val size = queue.size
//        repeat(size) {
//            val curr = queue.poll()
//            if (curr == find) {
//                found = true
//                return@repeat
//            }
//            for (i in graph[curr]) {
//                if (!visited[i]) {
//                    visited[i] = true
//                    queue.add(i)
//                }
//            }
//        }
//        level++
//    }
//
//    return if (found) level else -1
// }
