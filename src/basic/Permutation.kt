package basic

fun main() {
    val arr = intArrayOf(1, 3, 5, 9)
    val n = arr.size
    val k = 3
    permutation(arr, 0, n, k)
}

private fun permutation(arr: IntArray, index: Int, n: Int, k: Int) {
    if (index == k) {
        for (i in 0 until k) {
            print("${arr[i]} ")
        }
        println()
    } else {
        for (i in index until n) {
            swap(arr, index, i)
            permutation(arr, index + 1, n, k)
            swap(arr, index, i)
        }
    }
}

private fun swap(arr: IntArray, index: Int, i: Int) {
    val temp = arr[index]
    arr[index] = arr[i]
    arr[i] = temp
}
