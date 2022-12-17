package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val graph = HashMap<Int, MutableList<Int>>()
        val timeTable = IntArray(N) { -1 }
        val indegrees = IntArray(N) { 0 }
        repeat(N) { index ->
            val st = StringTokenizer(br.readLine())

            timeTable[index] = st.nextToken().toInt()
            while (st.hasMoreTokens()) {
                val num = st.nextToken().toInt()
                if (num != -1) {
                    val list = graph.getOrDefault(num, mutableListOf())
                    list.add(index + 1)
                    graph[num] = list

                    indegrees[index] += 1
                }
            }
        }

        val result = IntArray(N) { Int.MAX_VALUE }
        val queue = LinkedList<Int>()
        for (i in indegrees.indices) {
            if (indegrees[i] == 0) {
                queue.add(i + 1)
                result[i] = timeTable[i]
            }
        }

        while (queue.isNotEmpty()) {
            val p = queue.poll()

            if (graph.contains(p)) {
                for (node in graph[p]!!) {
//                    indegrees[node - 1] -= 1
                    if (result[node - 1] > result[p - 1] + timeTable[node - 1]) {
//                    if (indegrees[node - 1] == 0) {
                        result[node - 1] = result[p - 1] + timeTable[node - 1]
                        queue.add(node)
                    }
                }
            }
        }

        println(result.joinToString("\n"))
    }
}
