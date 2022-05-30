package hackerrank

/*
 * Complete the 'activityNotifications' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY expenditure
 *  2. INTEGER d
 */

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var noticeCnt = 0
    val cntArr = IntArray(201) { 0 }

    for (i in 0 until d) {
        cntArr[expenditure[i]]++
    }

    for (i in d until expenditure.size) {
        val median = findMedian(cntArr, d)

        if (2 * median <= expenditure[i])
            noticeCnt++

        cntArr[expenditure[i - d]]--
        cntArr[expenditure[i]]++
    }

    return noticeCnt
}

private fun findMedian(cntArr: IntArray, d: Int): Double {
    var cnt = 0
    var result = 0.toDouble()
    if (d % 2 != 0) {
        for (i in cntArr.indices) {
            cnt += cntArr[i]

            if (cnt > d / 2) {
                result = i.toDouble()
                break
            }
        }
    } else {
        var first = 0
        var second = 0

        for (i in cntArr.indices) {
            cnt += cntArr[i]

            if (first == 0 && cnt >= d / 2)
                first = i
            if (cnt >= d / 2 + 1) {
                second = i
                break
            }
        }
        result = (first + second) / 2.0
    }
    return result
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val expenditure = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}
