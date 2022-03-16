package basic

fun main() {
    val arr = intArrayOf(1, 3, 5, 9)
    val n = arr.size
    val r = 3
    val combArr = IntArray(n)
    combination(combArr, n, r, 0, 0, arr)
}

private fun combination(combArr: IntArray, n: Int, r: Int, index: Int, target: Int, arr: IntArray) {
    if (r == 0) {
        for (i in 0 until index)
            print(arr[combArr[i]])
        println()
    } else if (target == n) return
    else {
        combArr[index] = target
        combination(combArr, n, r - 1, index + 1, target + 1, arr)
        combination(combArr, n, r, index, target + 1, arr)
    }
}
