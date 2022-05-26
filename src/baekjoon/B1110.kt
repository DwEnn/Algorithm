package baekjoon

fun main() {
    val N = readLine()!!.toInt()
    calc(N, N)
    println(cnt)
}

private var cnt = 0

private fun calc(input: Int, num: Int) {
    val n = if (num < 10)
        "0$num"
    else
        num.toString()

    val first = n[1]
    val second = (Character.getNumericValue(n[0]) + Character.getNumericValue(n[1])).toString().last()
    val newNum = "$first$second".toInt()
    cnt++

    if (input == newNum)
        return
    else
        calc(input, newNum)
}
