package programmers

/**
 * 자물쇠와 열쇠
 * @link https://programmers.co.kr/learn/courses/30/lessons/60059
 */
fun main() {
    val key = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(0, 1, 1)
    )
    val lock = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1)
    )

    println(solution(key, lock))
}

private fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {

    var key = if (key.size < lock.size) {
        val temp = Array(lock.size) {
            IntArray(lock.size) { 0 }
        }
        for (i in key.indices) {
            for (j in key[i].indices) temp[i][j] = key[i][j]
        }

        temp
    } else key

    dp = Array(4) {
        Array(lock.size * 2) {
            BooleanArray(lock.size * 2) { false }
        }
    }

    // 회전 시킴
    repeat(4) {
        calc(key, key, lock, it, 0, 0)
        if (result)
            return@repeat
        key = rotateKey(key)
    }

    return result
}

private var result = false
private lateinit var dp: Array<Array<BooleanArray>>

private fun calc(
    originKey: Array<IntArray>,
    key: Array<IntArray>,
    lock: Array<IntArray>,
    rotateCnt: Int, dx: Int, dy: Int
) {
    if (dx == key.size || dx == (0 - key.size)) return
    if (dy == key.size || dy == (0 - key.size)) return
    if (dp[rotateCnt][dx + key.size][dy + key.size]) return
    if (result) return

    if (checkMate(key, lock)) {
        println("rotateCnt: $rotateCnt, dx: $dx, dy: $dy")
        result = true
        return
    }

    dp[rotateCnt][dx + key.size][dy + key.size] = true

    // 상하 좌우 이동
    calc(originKey, moveToKey(originKey, dx + 1, dy), lock, rotateCnt, dx + 1, dy)
    calc(originKey, moveToKey(originKey, dx - 1, dy), lock, rotateCnt, dx - 1, dy)
    calc(originKey, moveToKey(originKey, dx, dy + 1), lock, rotateCnt, dx, dy + 1)
    calc(originKey, moveToKey(originKey, dx, dy - 1), lock, rotateCnt, dx, dy - 1)
}

private fun checkMate(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    for (i in lock.indices) {
        for (j in lock[i].indices) {
            if (lock[i][j] == key[i][j])
                return false
        }
    }
    return true
}

private fun rotateKey(key: Array<IntArray>): Array<IntArray> {
    val rotated = Array(key.size) {
        IntArray(key[0].size) { 0 }
    }

    var idx = rotated.size - 1
    for (i in key.indices) {
        for (j in key[i].indices) {
            rotated[j][idx] = key[i][j]
        }
        idx--
    }

    return rotated
}


private fun moveToKey(key: Array<IntArray>, dx: Int, dy: Int): Array<IntArray> {
    val moved = Array(key.size) {
        IntArray(key[0].size) { 0 }
    }

    for (i in key.indices) {
        for (j in key[i].indices) {
            runCatching { moved[i][j] = key[i + dy][j + dx] }
        }
    }

    return moved
}