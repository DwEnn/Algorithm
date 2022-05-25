package basic

class AdjacencyListGraph(numOfVertex: Int) : IGraph {

    private val graph = MutableList(numOfVertex) { mutableListOf<Node>() }
    private val vertexes = HashSet<Int>()
    private val indegrees = HashMap<Int, Int>()

    override fun add(from: Int, to: Int) {
        this.vertexes.add(from)
        this.vertexes.add(to)

        val count = this.indegrees.getOrDefault(to, 0)
        this.indegrees[to] = count + 1

        this.graph[from].add(Node(from, to))
    }

    override fun add(from: Int, to: Int, distance: Int) {
        this.vertexes.add(from)
        this.vertexes.add(to)

        val count = this.indegrees.getOrDefault(to, 0)
        this.indegrees[to] = count + 1

        this.graph[from].add(Node(from, to, distance))
    }

    override fun getDistance(from: Int, to: Int): Int {
        for (node in this.graph[from]) {
            if (node.to == to)
                return node.weight
        }
        return -1
    }

    override fun getIndegress(): Map<Int, Int> = this.indegrees

    override fun getVertexes(): Set<Int> {
        return this.vertexes
    }

    override fun getNodes(vertex: Int): List<Int> {
        val nodes = mutableListOf<Int>()
        for (node in this.graph[vertex]) {
            nodes.add(node.to)
        }
        return nodes
    }

    private class Node(
        val from: Int,
        val to: Int,
        val weight: Int = 1
    )
}
