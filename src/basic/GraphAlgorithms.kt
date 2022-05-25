package basic

import java.util.LinkedList
import java.util.PriorityQueue
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

    /**
     * 1. 모든 Vertex 의 indegree 수를 센다
     * 2. 큐에 indegree 가 0인 Vertex 삽입
     * 3. 큐에서 Vertex 를 꺼내 연결된(나가는 방향) edge 제거
     * 4. 3번으로 인해 indegree 가 0이 된 Vertex 를 큐에 삽입
     * 5. 큐가 빌 때까지 3-4 반복
     */
    fun topologicalSortIndegree(iGraph: IGraph): List<Int> {
        // <Vertex, Indegree>
        val indegreeCounter = iGraph.getIndegress() as HashMap

        val queue = LinkedList<Int>()
        val result = LinkedList<Int>()

        queue.addAll(indegreeCounter.filter { it.value == 0 }.keys)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            result.add(node)

            for (n in iGraph.getNodes(node)) {
                if (indegreeCounter.containsKey(n)) {
                    val count = indegreeCounter[n]
                    if (count?.minus(1) == 0) queue.add(n)
                    indegreeCounter[n] = count?.minus(1) ?: -1
                }
            }
        }
        return result
    }

    fun topologicalSort(iGraph: IGraph): List<Int> {
        val result = mutableListOf<Int>()
        val stack = Stack<Int>()
        val visited = HashSet<Int>()

        val vertexes = iGraph.getVertexes()
        for (vertex in vertexes) {
            if (!visited.contains(vertex)) {
                // dfs
                topologicalSort(iGraph, vertex, visited, stack)
            }
        }
        while (stack.isNotEmpty()) {
            result.add(stack.pop())
        }
        // result 개수와 graph vertex 개수가 다르다면 사이클이 존재하는 것
        return result
    }

    private fun topologicalSort(iGraph: IGraph, vertex: Int, visited: HashSet<Int>, stack: Stack<Int>) {
        visited.add(vertex)
        val nodes = iGraph.getNodes(vertex)
        for (n in nodes) {
            if (!visited.contains(n)) {
                topologicalSort(iGraph, n, visited, stack)
            }
        }
        // 역순으로 Stack 에 쌓기 때문에 나중에 push
        stack.push(vertex)
    }

    /**
     * @param src 출발 노드
     * @param dist 도착 노드
     * @return 출발 노드로부터 도착 노드까지의 최단 거리
     */
    fun dijkstraShortestPath(iGraph: IGraph, src: Int, dist: Int): Int {
        var size = 0
        for (n in iGraph.getVertexes()) {
            if (size < n) {
                size = n + 1
            }
        }

        // distance 배열을 노드 크기 만큼 초기화, INF 값으로 요소 초기화
        val dist = IntArray(size) { Int.MAX_VALUE }
        // 시작 노드의 distance 는 0
        dist[src] = 0

        // <Vertex, distance>, distance 를 기준으로 하는 민힙
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
            o1.second - o2.second
        }

        pq.add(Pair(src, 0))

        while (pq.isNotEmpty()) {
            val top = pq.poll()
            val vertex = top.second
            val distance = top.second

            if (dist[vertex] < distance) continue

            for (n in iGraph.getNodes(vertex)) {
                if (dist[n] > dist[vertex] + iGraph.getDistance(vertex, n)) {
                    dist[n] = dist[vertex] + iGraph.getDistance(vertex, n)
                    pq.add(Pair(n, dist[n]))
                }
            }
        }
        return dist[src]
    }
}
