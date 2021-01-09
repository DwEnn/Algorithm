package backjoon

import java.lang.StringBuilder
import java.util.*

var L = 0
var C = 0

lateinit var arr: Array<Char>
private lateinit var visited: Array<Boolean>

val MO_ARR = charArrayOf('a', 'e', 'i', 'o', 'u')
private val sb = StringBuilder()

fun main() {
//    var st = StringTokenizer(readLine())
    var st = StringTokenizer("4 6")
    L = st.nextToken().toInt()
    C = st.nextToken().toInt()

//    st = StringTokenizer(readLine())
    st = StringTokenizer("a t c i s w")
    arr = Array(C) { st.nextToken()[0] }
    visited = Array(C) { false }

    // 알파벳이 증가하는 형식이기 때문에 정렬 수행
    arr.sort()

    for (i in 0 until C) {
        val num = i + L
        if (num > C)
            continue
        visited[i] = true
        backTrack(i, 1, arr[i].toString())
        visited[i] = false
    }

    println(sb.toString())
}

private fun backTrack(idx: Int, cnt: Int, str: String) {
    val num = idx + L - cnt
    if (idx >= arr.size || num > C)
        return

    if (cnt == L) {
        if (isAble())
            sb.append(str + "\n")
        return
    }

    for (i in idx + 1 until C) {
        if (visited[i])
            continue

        visited[i] = true
        backTrack(i, cnt+1, str + arr[i])
        visited[i] = false
    }
}

private fun isAble(): Boolean {
    var MO_CNT = 0
    var JA_CNT = 0

    for (i in arr.indices) {
        if (visited[i]) {
            if (isJa(arr[i]))
                JA_CNT += 1
            else
                MO_CNT += 1
        }
    }

    // 모음이 최소 한 개 자음이 최소 두 개 있어야 함
    if (MO_CNT == 0 || JA_CNT < 2)
        return false

    return true
}

private fun isJa(c: Char): Boolean {
    for (mo in MO_ARR){
        if (c == mo)
            return false
    }

    return true
}

