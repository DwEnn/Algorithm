package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br->
        val list = LinkedList<Int>()
        // N 배열 초기화
        repeat(br.readLine().toInt()) {
            list.add(it+1)
        }

        while (list.size != 1) {
            play(list)
        }

        println(list.first)
    }
}

private fun play(list: LinkedList<Int>) {
    // 제일 위 카드 버리기
    list.removeFirst()

    // 제일 위 카드 뒤로 보내기
    list.addLast(list.pollFirst())
}