package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val queue = Queue<Int>()
        repeat(N) {
            queue.inputCommand(br.readLine())
        }
    }
}

private class Queue<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    private var size = 0

    private class Node<T>(val data: T) {
        var next: Node<T>? = null
    }

    fun inputCommand(command: String) {
        when {
            command.contains("push") -> push(command.split(" ")[1] as T)
            command == "pop" -> pop()
            command == "size" -> size()
            command == "empty" -> empty()
            command == "front" -> front()
            command == "back" -> back()
        }
    }

    private fun push(data: T) {
        val new = Node(data)

        if (last != null)
            last?.next = new

        last = new

        if (first == null)
            first = last

        size++
    }

    private fun pop() {
        if (first == null) {
            println(-1)
            return
        }

        val node = first
        first = first?.next

        if (first == null) {
            last = null
        }

        size--
        println(node?.data)
    }

    private fun front() {
        println(first?.data ?: -1)
    }

    private fun back() {
        println(last?.data ?: -1)
    }

    private fun size() {
        println(size)
    }

    private fun empty() {
        if (size > 0)
            println(0)
        else
            println(1)
    }
}