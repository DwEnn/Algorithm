package basic

interface IGraph {
    fun add(from: Int, to: Int)
    fun add(from: Int, to: Int, distance: Int)
    fun getDistance(from: Int, to: Int): Int

    /**
     * <노드, 차수의 수>
     */
    fun getIndegress(): Map<Int, Int>
    fun getVertexes(): Set<Int>
    fun getNodes(vertex: Int): List<Int>
}
