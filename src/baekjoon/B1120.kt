import kotlin.math.min

fun main() {
    val data = readLine()!!.split(" ")
    val A = data[0]
    val B = data[1]

    var result: Int = 10000000
    for (i in B.indices) {
        if (i + A.length <= B.length) {
            result = min(result, calc(A, B, i))
        } else
            break
    }

    println(result)
}

private fun calc(A: String, B: String, pos: Int): Int {
    var cnt = 0
    var idx = pos

    for (c in A) {
        if (c != B[idx++]) {
            cnt++
        }
    }

    return cnt
}
