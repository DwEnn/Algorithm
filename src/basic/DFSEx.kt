package basic

import java.util.*

fun main() {

//    var dfs = DFS(8)
//    dfs.run {
//        put(1, 2)
//        put(1, 3)
//        put(2, 4)
//        put(2, 5)
//        put(3, 6)
//        put(3, 7)
//        put(4, 8)
//        put(5, 8)
//        put(6, 8)
//        put(7, 8)
//
//        printGraphToAdjArr()
//        println()
//
//    }
//    // 정점 1-8 부터 탐색
//    for (i in 1..8) {
//        println("정점 $i 부터 탐색")
//        dfs.dfs(i)
//        dfs.clearVisitArr()
//        println()
//    }
//
//    println()
//    dfs = DFS(10)
//    dfs.run {
//        put(0, 1)
//        put(1, 3)
//        put(2, 3)
//        put(4, 6)
//        put(5, 7)
//        put(5, 8)
//        put(7, 8)
//
//        printGraphToAdjArr()
//        println()
//        dfsAll()
//        println()
//    }
//
//    // 정점 0-8 부터 탐색
//    for (i in 0..8) {
//        println("정점 $i 부터 탐색")
//        dfs.dfs(i)
//        dfs.clearVisitArr()
//        println()
//    }

    val dfs1 = DFS1(4).apply {
        addEdge(0, 1)
        addEdge(0, 2)
        addEdge(1, 2)
        addEdge(2, 0)
        addEdge(2, 3)
        addEdge(3, 3)
    }

    dfs1.DFS(2)
    dfs1.DFS()

}

/**
 * 인접 리스트 이용
 */
private class DFS1 private constructor() {
    // 노드의 개수
    private var V = 0

    // 인접 리스트
    private lateinit var adj: LinkedList<LinkedList<Int>>

    constructor(v: Int) : this() {
        V = v
        adj = LinkedList()
        // 인접 리스트 초기화
        for (i in 0 until V)
            adj.add(LinkedList())
    }

    /**
     * 노드를 연결
     */
    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
    }

    /**
     * DFS 에 의해 사용되는 함수
     */
    fun DFSUtil(v: Int, visited: BooleanArray) {
        // 현재 노드를 방문한 것으로 표시하고 출력
        visited[v] = true
        print("$v ")

        // 방문한 노드와 인접한 모든 노드를 가져온다
        val it = adj[v].listIterator()
        while (it.hasNext()) {
            val n = it.next()
            // 방문하지 않은 노드라면 해당 노드를 시작 노드로 다시 DFSUtil 을 호출
            if (!visited[n])
                DFSUtil(n, visited)
        }
    }

    /**
     * 주어진 노드를 시작노드로 DFS 탐색
     */
    fun DFS(v: Int) {
        // 노드의 방문 여부 판단 ( 초기값 : false )
        val visited = BooleanArray(V)
        DFSUtil(v, visited)
        println()
    }

    /**
     * DFS 탐색
     */
    fun DFS() {
        // 노드의 방문 여부 판단 ( 초기값 : false )
        val visited = BooleanArray(V)
        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (i in 0 until V) {
            if (!visited[i]) {
                DFSUtil(i, visited)
                println()
            }
        }
    }

}


/**
 * 인접 행렬 이용
 */
private class DFS {

    // 정점의 갯수
    private var N: Int = 0

    // 그래프
    private lateinit var dfsGraph: Array<IntArray>

    // 정점 방문 여부 확인 배열
    private lateinit var visited: BooleanArray

    private constructor() {
        N = 0
        init()
    }

    constructor(n: Int) {
        N = n
        init()
    }

    /**
     * 그래프 초기화
     */
    private fun init() {
        // put(x,y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // 배열의 index 는 0부터 시작이므로
        // OutOfIndexException 방지를 위해
        // 정점을 담는 인접 형렬의 행과 열 size 는 1을 더하여 초기화 해준다.
        visited = BooleanArray(N + 1) { false }
        dfsGraph = Array(N + 1) {
            IntArray(N + 1)
        }
    }

    /**
     * 그래프 추가(양방향)
     */
    fun put(x: Int, y: Int) {
        dfsGraph[x][y] = 1
        dfsGraph[y][x] = 1
    }

    /**
     * 그래프 추가(단방향)
     */
    fun putSingle(x: Int, y: Int) {
        dfsGraph[x][y] = 1
    }

    /**
     * 그래프 출력(인접 행렬)
     */
    fun printGraphToAdjArr() {
        dfsGraph.forEach {
            it.forEach { num ->
                print("$num")
            }
            println()
        }
    }

    /**
     * 정점 방문 여부 확인 배열 초기화
     */
    fun clearVisitArr() {
        for (i in visited.indices) {
            visited[i] = false
        }
    }

    /**
     * 그래프 탐색(재귀호출)
     * @return curr 부터 방문한 정점 개수를 반환
     */
    fun dfs(vIdx: Int): Int {
        // dfs()에 들어온 vIdx는 방문한 것이므로
        // backjoon.visited[]의 해당 index 값을 true 로 바꿔주고 값을 출력
        visited[vIdx] = true
        print("$vIdx")

        var nodes = 1

        // dfsGraph[][] 의 해당 정점이 연결되어 있고
        // 해당 정점을 방문하지 않은 상태
        for (i in 1..N) {
            if (dfsGraph[vIdx][i] == 1 && !visited[i])
                nodes += dfs(i)
        }

        return nodes
    }

    /**
     * 모든 정점을 깊이 우선 탐색하고 컴포넌트 개수를 반환
     */
    fun dfsAll() {
        var components = 0
        for (i in 0 until N) {
            if (!visited[i]) {
                println("------- new DFS Begins --------")
                val nodes = dfs(i)
                components++
                println("size: $nodes")
            }
        }
        println("The number of component is $components")
    }

}