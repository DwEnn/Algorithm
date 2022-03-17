package programmers

/*
    가장 큰 수
    https://programmers.co.kr/learn/courses/30/lessons/42746
 */
fun main() {
    val numbers = intArrayOf(6, 10, 2)
//    val numbers = intArrayOf(3, 30, 35, 5, 9)
//    println(solution(numbers))
}

/**
 * 26.7/100 (시간 초과)
 */
// private fun solution(numbers: IntArray): String {
//    permutation(numbers, numbers.size, 0)
//    return answer
// }
//
// var answer = ""
//
// private fun permutation(arr: IntArray, k: Int, index: Int) {
//    if (index == k) {
//        val sb = StringBuilder()
//        arr.forEach { sb.append(it) }
//        println(sb.toString())
//        answer = if (sb.toString() > answer) sb.toString() else answer
//    } else {
//        for (i in index until arr.size) {
//            swap(arr, index, i)
//            permutation(arr, k, index + 1)
//            swap(arr, index, i)
//        }
//    }
// }
//
// private fun swap(arr: IntArray, index: Int, target: Int) {
//    val temp = arr[index]
//    arr[index] = arr[target]
//    arr[target] = temp
// }

/**
 * is Cheated
 */
private fun solution(numbers: IntArray): String {
    var answer = ""

    numbers.sortedWith(
        Comparator { o1, o2 ->
            "$o2$o1".compareTo("$o1$o2")
        }
    ).forEach { answer += it }
    if ("(0*)".toRegex().replace(answer, "").isEmpty())
        answer = "0"

    return answer
}
