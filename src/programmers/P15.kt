package programmers

import java.util.Stack

/**
 * @link https://programmers.co.kr/learn/courses/30/lessons/81303
 * 표 편집
 */
fun main() {
    val n = 8
    val k = 2
    val cmd = arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z")
    println(solution(n, k, cmd))
}

private val delete = Stack<Pair<Int, Int>>()
private val list = mutableListOf<Int>()

private fun solution(n: Int, k: Int, cmd: Array<String>): String {
    repeat(n) {
        list.add(it)
    }

    cmd.fold(k) { acc, s ->
        val str = s.split(" ")
        val cursor = when (str[0]) {
            "U" -> moveUp(acc, str[1].toInt())
            "D" -> moveDown(acc, str[1].toInt())
            "C" -> delete(acc)
            "Z" -> undo(acc)
            else -> acc
        }
        cursor
    }

    val sb = StringBuilder()
    repeat(n) { num ->
        if (num == list.first()) {
            list.removeFirst()
            sb.append("O")
        } else {
            sb.append("X")
        }
    }

    return sb.toString()
}

private fun moveUp(cursor: Int, move: Int): Int {
    return cursor - move
}

private fun moveDown(cursor: Int, move: Int): Int {
    return cursor + move
}

private fun undo(cursor: Int): Int {
    val element = delete.pop()
    list.add(element.first, element.second)
    return if (cursor >= element.first) {
        cursor + 1
    } else {
        cursor
    }
}

private fun delete(cursor: Int): Int {
    val len = list.size
    delete.push(Pair(cursor, list.removeAt(cursor)))
    return if (cursor == len - 1) {
        list.size - 1
    } else {
        cursor
    }
}
