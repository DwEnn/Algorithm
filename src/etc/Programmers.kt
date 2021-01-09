package etc

import java.lang.StringBuilder

fun main() {

    val solution = Solution()

//    val result = solution.solution(intArrayOf(5,2,3,3,5,3))
//    val result = solution.solution(intArrayOf(0))
//    val result = solution.solution(intArrayOf(0,3,3,0,7,2,0,2,2,0))

//    println(result)

    println(solution.solution("try hello world"))
    println(solution.solution("asdfgasdfasdf asdfasdf ass asdf"))
    println(solution.solution(" try hello world "))

}

private class Solution {
    fun solution(s: String) =
        s.split(" ").map {
            it.mapIndexed { index, c ->
                if (index%2 == 0)
                    c.toUpperCase()
                else
                    c
            }
            val sb = StringBuilder()
            it.forEachIndexed { index, c ->
                if (index%2 == 0)
                    sb.append(c.toUpperCase())
                else
                    sb.append(c)
            }
            sb.toString()
        }.let {
            val sb = StringBuilder()
            it.forEach { str ->
                if (str.isNotBlank())
                    sb.append("$str ")
            }
            sb.deleteCharAt(sb.lastIndex).toString()
        }

}


//private class Solution {
//
//    var ans = 0
//
//    fun solution(a: IntArray): Int {
//        powerSet(a, BooleanArray(a.size), a.size, 0)
//        return ans
//    }
//
//    fun powerSet(backjoon.getArr: IntArray, backjoon.visited: BooleanArray, n: Int, idx: Int) {
//        if (idx == n) {
//            val backjoon.array = merge(backjoon.getArr, backjoon.visited, n)
//            if (checkStarArray(backjoon.array))
//                ans = Math.max(ans, backjoon.array.size)
//
//            return
//        }
//
//        backjoon.visited[idx] = false
//        powerSet(backjoon.getArr, backjoon.visited, n, idx + 1)
//
//        backjoon.visited[idx] = true
//        powerSet(backjoon.getArr, backjoon.visited, n, idx + 1)
//    }
//
//    fun merge(backjoon.getArr: IntArray, backjoon.visited: BooleanArray, n: Int): IntArray {
//        val backjoon.array = ArrayList<Int>()
//        for (i in 0 until n) {
//            if (backjoon.visited[i])
//                backjoon.array.add(backjoon.getArr[i])
//        }
//        return backjoon.array.toIntArray()
//    }
//
//    fun checkStarArray(backjoon.getArr: IntArray): Boolean {
//        var isStarArray = false
//
//        if (backjoon.getArr.size < 2 || backjoon.getArr.size % 2 != 0)
//            return isStarArray
//
//        for (i in backjoon.getArr.indices step 2) {
//            if (backjoon.getArr[i] == backjoon.getArr[i + 1])
//                return isStarArray
//        }
//
//        val list = ArrayList<String>()
//        for (i in 0 until backjoon.getArr.size - 1) {
//            list.add("${backjoon.getArr[i]}${backjoon.getArr[i + 1]}")
//        }
//
//        var backjoon.cnt = 0
//        for (i in list.indices) {
//            for (j in i+1 until list.size) {
//                if (list[i] == list[j])
//                    backjoon.cnt++
//            }
//        }
//
//        if (backjoon.cnt < 1)
//            return isStarArray
//
//        isStarArray = true
//        return isStarArray
//    }

//    var convertCnt = 0
//    var removedZeroNumCnt = 0
//
//    fun solution(s: String): IntArray {
//        var str = s
//        do {
//            convertCnt++
//            str = backjoon.calc(str)
//        } while (str != "1")
//
//        return intArrayOf(convertCnt, removedZeroNumCnt)
//    }
//
//    fun backjoon.calc(s: String): String {
//        val backjoon.sb = StringBuilder()
//        s.forEach {
//            if (Character.getNumericValue(it) != 0)
//                backjoon.sb.append(it)
//            else
//                removedZeroNumCnt++
//        }
//
//        return Integer.toBinaryString(backjoon.sb.toString().length)
//    }

//    fun solution(a: IntArray, b: IntArray): Int {
//        var answer: Int = 0
//
//        for (i in a.indices) {
//            answer += a[i] * b[i]
//        }
//
//        return answer
//    }

//    fun solution(n: Int): IntArray {
//        val list = arrayOfNulls<Array<Int?>>(n)
//        repeat(n) {
//            list[it] = arrayOfNulls(n)
//        }
//
//        var backjoon.cnt = 1
//        val dir = arrayOf("down","right", "up")
//        var dirCnt = 0
//        var position = 0
//        var row = -1
//
//
//        for (i in n downTo 1) {
//            val direction = dir[dirCnt++%3]
//            repeat(i) {
//                when(direction) {
//                    "down" -> {
//                        list[++row]!![position] = backjoon.cnt++
//                    }
//                    "right" -> {
//                        list[row]!![++position] = backjoon.cnt++
//                    }
//                    "up" -> {
//                        list[--row]!![--position] = backjoon.cnt++
//                    }
//                }
//            }
//        }
//
//        val answer = LinkedList<Int>()
//
//        list.forEach {
//            it!!.forEach {num ->
//                if (num != null)
//                    answer.add(num)
//            }
//        }
//
//        return answer.toIntArray()
//    }
//}