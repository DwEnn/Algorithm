package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()

        for (i in 0 until T) {
            val N = br.readLine().toInt()

            val numbers = arrayListOf<String>()
            for (j in 0 until N) {
                numbers.add(br.readLine())
            }

            val root = Trie()
            numbers.forEach { root.add(it) }

            var check = true
            for (number in numbers) {
                if (!root.check(number)) {
                    check = false
                    break
                }
            }

            if (!check)
                println("NO")
            else
                println("YES")
        }
    }
}

private class Trie(
    val node: Array<Trie?> = arrayOfNulls(10),
    var isEnd: Boolean = false
) {
    fun add(s: String) {
        if (s.isEmpty()) return

        var nodes = this.node
        var curr: Trie? = null
        for (c in s.toCharArray()) {
            val num = c - '0'
            if (nodes[num] == null) {
                nodes[num] = Trie()
            }
            curr = nodes[num]
            nodes = nodes[num]!!.node
        }
        curr?.isEnd = true
    }

    fun check(s: String): Boolean {
        var nodes = this.node
        var curr: Trie? = null
        for (i in s.indices) {
            val n = s[i] - '0'
            curr = nodes[n]
            if (curr != null && curr.isEnd && i < s.length - 1) {
                return false
            }
            nodes = curr!!.node
        }
        return true
    }
}
