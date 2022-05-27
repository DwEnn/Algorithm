package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var root: Node1? = null
        while (true) {
            val num = br.readLine() ?: break
            root = insertNode(root, num.toInt())
        }

        println(
            postOrder(root, mutableListOf()).joinToString("\n")
        )
    }
}

private fun insertNode(node: Node1?, value: Int): Node1 {
    if (node == null) return Node1(value)

    if (node.data > value) {
        node.left = insertNode(node.left, value)
    } else if (node.data < value) {
        node.right = insertNode(node.right, value)
    }

    return node
}

private fun postOrder(node: Node1?, visited: MutableList<Int>): List<Int> {
    if (node == null) return visited

    postOrder(node.left, visited)
    postOrder(node.right, visited)
    visited.add(node.data)

    return visited
}

private class Node1(
    var data: Int,
    var left: Node1? = null,
    var right: Node1? = null
)
