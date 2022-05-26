package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader


private var N = 0
private lateinit var array: Array<CharArray>
private lateinit var visited: Array<BooleanArray>

private val dx = intArrayOf(0,1,0,-1)
private val dy = intArrayOf(1,0,-1,0)

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use {br ->
        N = br.readLine().toInt()

        array = Array(N) {
            br.readLine().toCharArray()
        }

        visited = Array(N) {
            BooleanArray(N)
        }

        var cnt1 = 0
        for (i in array.indices) {
            for (j in array.indices) {
                if (!visited[i][j]) {
                    dfs(i, j, array[i][j], true)
                    cnt1++
                }
            }
        }

        visited = Array(N) {
            BooleanArray(N)
        }

        var cnt2 = 0
        for (i in array.indices) {
            for (j in array.indices) {
                if (!visited[i][j]) {
                    dfs(i, j, array[i][j], false)
                    cnt2++
                }
            }
        }


        println(cnt1)
        println(cnt2)
    }
}

private fun dfs(x: Int, y: Int, color: Char, isNormal: Boolean) {
    visited[x][y] = true

    repeat(4) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if (isInRange(nx, ny) &&!visited[nx][ny])
            if (isNormal) {
                if (array[nx][ny] == color)
                    dfs(nx, ny, color, isNormal)
            }
            else {
                if (array[nx][ny] == color || (array[nx][ny] == 'R'&& color=='G') || (array[nx][ny] == 'G'&& color=='R'))
                    dfs(nx, ny, color, isNormal)
            }
    }

}

private fun isInRange(x: Int, y: Int) = x in 0 until N && y in 0 until N
