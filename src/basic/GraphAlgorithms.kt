package basic

import java.util.LinkedList
import java.util.Stack

class GraphAlgorithms {
    fun bfs(iGraph: IGraph, from: Int): List<Int> {
        val result = mutableListOf<Int>()
        val visited = HashSet<Int>()
        val queue = LinkedList<Int>()

        queue.add(from)
        visited.add(from)

        while (queue.isNotEmpty()) {
            val next = queue.poll()
            result.add(next)
            for (n in iGraph.getNodes(next)) {
                if (!visited.contains(n)) {
                    queue.add(n)
                    visited.add(n)
                }
            }
        }
        return result
    }

    fun dfs(iGraph: IGraph, from: Int): List<Int> {
        val result = mutableListOf<Int>()
        val visited = HashSet<Int>()

        val stack = Stack<Int>()

        stack.push(from)
        visited.add(from)

        while (stack.isNotEmpty()) {
            val next = stack.pop()
            result.add(next)

            for (n in iGraph.getNodes(next)) {
                if (!visited.contains(n)) {
                    stack.push(n)
                    visited.add(n)
                }
            }
        }
        return result
    }
}
