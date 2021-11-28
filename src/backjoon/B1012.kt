import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val t = br.readLine().toInt()
        repeat(t) {
            val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
            val cabbages = Array(k) {
                val (x, y) = br.readLine().split(" ").map { it.toInt() }
                Cabbage(x, y)
            }
            var cnt = 0
            for (i in cabbages.indices) {
                if (!cabbages[i].visit) {
                    search(cabbages, i)
                    cnt++
                }
            }
            println(cnt)

        }
    }
}

private fun search(cabbages: Array<Cabbage>, target: Int) {
    val cabbage = cabbages[target]
    if (cabbage.visit)
        return

    cabbage.visit = true
    for (i in cabbages.indices) {
        if (i != target) {
            if (inRange(cabbage, cabbages[i])) {
                search(cabbages, i)
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)
private fun inRange(cabbage1: Cabbage, cabbage2: Cabbage): Boolean {
    repeat(4) {
        val x = cabbage1.x + dx[it]
        val y = cabbage1.y + dy[it]

        if (x == cabbage2.x && y == cabbage2.y) {
            return true
        }
    }

    return false
}

private class Cabbage(val x: Int, val y: Int, var visit: Boolean = false)


//fun main() {
//    BufferedReader(InputStreamReader(System.`in`)).use { br ->
//        val T = br.readLine().toInt()
//        val sb = StringBuilder()
//
//        repeat(T) {
//            var lines = br.readLine().split(" ")
//            val M = lines[0].toInt()
//            val N = lines[1].toInt()
//            val K = lines[2].toInt()
//            val graph = Graph(M, N)
//
//            for (i in 0 until K) {
//                lines = br.readLine().split(" ")
//                graph.put(lines[0].toInt(), lines[1].toInt())
//            }
//
//            sb.append(graph.dfsAll()).append("\n")
//        }
//
//        println(sb.toString())
//    }
//}
//
//private class Graph private constructor(){
//
//    lateinit var graph: Array<IntArray>
//    lateinit var visited: BooleanArray
//
//    constructor(M: Int, N: Int) : this() {
//        graph = Array(M) {
//            IntArray(N)
//        }
//        visited = BooleanArray(M)
//    }
//
//    fun put(x: Int, y: Int) {
//        graph[x][y] = 1
//    }
//
//    fun dfs(idx: Int) {
//        print("visit : $idx")
//        visited[idx] = true
//        for (i in graph[idx].indices) {
//            if (graph[idx][i] == 1 && !visited[i])
//                dfs(i)
//        }
//    }
//
//    fun dfsAll(): Int {
//        var count = 0
//        repeat(graph.size) {
//            if (!visited[it]) {
//                dfs(it)
//                count++
//            }
//        }
//        return count
//    }
//
//}
