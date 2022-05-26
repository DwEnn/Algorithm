package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use {br ->
        repeat(br.readLine().toInt()) {
            val st = StringTokenizer(br.readLine())
            val N = st.nextToken().toInt()
            val targetIndex = st.nextToken().toInt()

            val list = br.readLine().split(" ").mapIndexed { i, it ->
                Doc(it.toInt(), i)
            } as ArrayList<Doc>

            var cnt = 0
            while (list.isNotEmpty()) {
                val printedDoc = print(list, targetIndex)
                cnt++
                if (printedDoc.index == targetIndex) {
                    println(cnt)
                    break
                }
            }
        }
    }
}

private fun print(docs: ArrayList<Doc>, targetIndex: Int): Doc {
    if (docs.size == 1)
        return docs[0]

    for (i in 1 until docs.size) {
        if (docs[0].priority < docs[i].priority) {
            docs.add(docs.removeAt(0))
            return print(docs, targetIndex)
        }
    }

    return docs.removeAt(0)
}

private data class Doc(val priority: Int, val index: Int)