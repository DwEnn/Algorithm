package basic

class AdjacencyMatrixGraph(numOfVertex: Int) : IGraph {

    private val matrix: Array<IntArray> = Array(numOfVertex) { IntArray(numOfVertex) }
    private val vertexes = HashSet<Int>()
    private val indegrees = HashMap<Int, Int>()
    // indegrees.get(3) = 5 -> 노드 3을 가르키는 노드의 갯수가 5

    override fun add(from: Int, to: Int) {
        this.vertexes.add(from)
        this.vertexes.add(to)
        val count = this.indegrees.getOrDefault(to, 0)
        indegrees[to] = count + 1

        matrix[from][to] = 1
        // 양방향 그래프라면 둘 다 연결해주어야함
//        matrix[to][from] = 1
    }

    override fun add(from: Int, to: Int, distance: Int) {
        this.vertexes.add(from)
        this.vertexes.add(to)
        val count = this.indegrees.getOrDefault(to, 0)
        indegrees[to] = count + 1

        matrix[from][to] = distance
    }

    override fun getDistance(from: Int, to: Int): Int {
        return this.matrix[from][to]
    }

    override fun getIndegress(): Map<Int, Int> {
        return this.indegrees
    }

    override fun getVertexes(): Set<Int> {
        return this.vertexes
    }

    override fun getNodes(vertex: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in matrix.indices) {
            if (this.matrix[vertex][i] != -1) {
                result.add(i)
            }
        }
        return result
    }
}