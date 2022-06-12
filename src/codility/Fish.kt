package codility

import java.util.LinkedList

fun main() {
    val A = intArrayOf(4, 3, 2, 1, 5)
    val B = intArrayOf(0, 1, 0, 0, 0)
//    val A = intArrayOf(3, 4, 2, 1, 5)
//    val B = intArrayOf(1, 0, 1, 1, 1)
//    val A = intArrayOf(4, 3, 2, 1, 5)
//    val B = intArrayOf(1, 1, 1, 1, 0)

    println(solution(A, B))
}

private fun solution(A: IntArray, B: IntArray): Int {
    val flow = LinkedList<Pair<Int, Int>>()
    flow.offer(Pair(B[0], A[0]))
    for (i in 1 until A.size) {
        var isFeedingTime = false
        var newFish: Pair<Int, Int>? = Pair(B[i], A[i])
        do {
            val lastFishInFlow = flow.last()
            if (lastFishInFlow.first == 1 && newFish?.first == 0) {
                if (lastFishInFlow.second < newFish.second) {
                    isFeedingTime = true
                    flow.removeLast()
                } else {
                    newFish = null
                }
            } else {
                isFeedingTime = false
            }
        } while (isFeedingTime && flow.isNotEmpty())
        newFish?.let { flow.offer(it) }
    }
    return flow.size
}
