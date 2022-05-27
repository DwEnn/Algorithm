package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val K = Math.pow(2.toDouble(), br.readLine().toDouble()) - 1
        val list = br.readLine().split(" ").map { it.toInt() }

        val root = buildTree(list, 0, list.size - 1)
        printTree(root)
    }
}

private fun buildTree(inorder: List<Int>, start: Int, end: Int): Node? {
    if (start > end) return null

    val i = (start + end) / 2
    val node = Node(inorder[i])

    // 리프 노드에 도달함
    if (start == end) return node

    node.left = buildTree(inorder, start, i - 1)
    node.right = buildTree(inorder, i + 1, end)
    return node
}

private fun printTree(root: Node?) {
    val result = StringBuilder()

    val queue = LinkedList<Node?>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val n = queue.size
        repeat(n) {
            val node = queue.poll()
            result.append("${node?.data} ")
            if (node?.left != null) queue.add(node.left)
            if (node?.right != null) queue.add(node.right)
        }
        result.append("\n")
    }
    println(result.toString())
}

private class Node(
    var data: Int,
    var left: Node? = null,
    var right: Node? = null
)
