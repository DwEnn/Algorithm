package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.collections.set

/*
3 6
1 2 3 4 1 2
---------------
2 7
2 3 2 3 1 2 7
(2)
---------------
2 13
2 3 1 3 1 3 1 3 2 2 2 2 2
: 2
---------------
7 3
1 5 1
(0)
---------------
7 7
1 5 1 1 1 2 5
---------------
100 10
1 2 3 4 5 6 7 8 9 10
---------------
2 6
2 1 3 2 1 3 / 2 1 3 1 2 3
---------------
3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4
---------------
2 15
3 2 1 2 1 2 1 2 1 3 3 3 3 3 3
: 2
---------------
3 8
1 2 3 4 1 1 1 2
: 1
---------------
1 3
1 2 1
: 2
---------------
3 6
1 2 3 4 1 2
: 1
---------------
6 7
1 1 1 1 1 1 2
: 0
---------------
2 10
1 2 3 2 3 2 2 2 1 2
: 2
---------------
5 20
1 2 3 4 1 1 1 3 3 2 5 7 20 1 3 4 2 1 9 19
: 4
---------------
3 20
1 2 3 4 4 3 5 8 9 19 20 1 2 3 20 4 1 2 3 4
: 10
---------------
3 10
2 3 1 4 2 3 2 4 1 4
: 2
---------------
 */

/**
 * 최초 콘센트 꼽을 때, 중복을 생각해야함 ( ArrayList 풀이는 x )
 *
 * 6 7
 * 1 1 1 1 1 1 2
 * : 0
 */
fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var N = 0
        var len: Int
        br.readLine().split(" ").let {
            len = it[0].toInt()
            N = it[1].toInt()
        }
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        var result = 0
        val powers = HashSet<Int>()

        loop@ for (i in arr.indices) {
            if (powers.size == len) {
                // 빈자리가 없는 경우
                val map = HashMap<Int, Int>()

                // 이미 꼽혀있는 경우, 패스
                for (p in powers) {
                    if (p == arr[i])
                        continue@loop
                }

                for (j in i + 1 until arr.size) {
                    for (p in powers) {
                        if (p == arr[j] && map[p] == null)
                            map[p] = j
                    }
                }

                // 1. 사용되지 않는 것이 있으면 제거
                // 2. 모두 사용된다면 가장 나중에 사용되는 것 제거
                var toPlug = -1
                var useIdx = -1
                for (p in powers) {
                    if (useIdx < map.getOrDefault(p, Int.MAX_VALUE)) {
                        toPlug = p
                        useIdx = map.getOrDefault(p, Int.MAX_VALUE)
                    }
                }

                powers.remove(toPlug)
                powers.add(arr[i])

                result ++

            } else
                powers.add(arr[i])
        }

        println(result)
    }
}

/**
 * 가장 적게 사용하는것을 제거하능 방법으로 풀은 것
 */
//fun main() {
//    BufferedReader(InputStreamReader(System.`in`)).use { br ->
//        var N = 0
//        var len: Int
//        br.readLine().split(" ").let {
//            len = it[0].toInt()
//            N = it[1].toInt()
//        }
//        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
//        val cntMap = HashMap<Int, Int>()
//        arr.forEach {
//            cntMap[it] = cntMap.getOrDefault(it, 0) + 1
//        }
//
//        var result = 0
//        val powers = ArrayList<Int>()
//
//        for (i in arr.indices) {
//            if (powers.size == len) {
//                // 빈자리가 없는 경우
//                val map = HashMap<Int, Int>()
//                for (j in i + 1 until arr.size) {
//
//                }
//
//            } else
//                powers.add(arr[i])
//        }
//
//        for (i in arr.indices) {
//            if (powers.size == len) {
//                var toPlug = -1
//                var min = Int.MAX_VALUE
//                var notToPlug = false
//                for (j in powers) {
//                    if (j != arr[i]) {
//                        if (min > cntMap[j]!!) {
//                            min = cntMap[j]!!
//                            toPlug = j
//                        } else if (min == cntMap[j]!!) {
//                            var idx1 = Int.MAX_VALUE
//                            var idx2 = Int.MAX_VALUE
//                            // 사용빈도가 같다면, 가장 늦게 사용하는것을 먼저 뽑음
//                            // 하나는 사용되지 않는다면 사용하지 않는 것을 뽑음
//                            for (k in i + 1 until arr.size) {
//                                if (arr[k] == toPlug && idx1 == -1)
//                                    idx1 = k
//                                else if (arr[k] == j && idx2 == -1)
//                                    idx2 = k
//                            }
//
//                            if (idx1 < idx2)
//                                toPlug = j
//                        }
//                    } else {
//                        notToPlug = true
//                        break
//                    }
//                }
//
//                if (!notToPlug && toPlug != -1) {
//                    powers.remove(toPlug)
//                    powers.add(arr[i])
//                    result++
//                }
//
//            } else
//                powers.add(arr[i])
//        }
//
//        println(result)
//    }
//}