fun main() {
//    val N = readLine()!!.toInt()
    val N = "4".toInt()
//    val arr = readLine()!!.split(" ").map { it.toInt() }
//    val arr = "2 1 1 0".split(" ").map { it.toInt() }
    val arr = "3 0 1 0".split(" ").map { it.toInt() }

    val result = ArrayList<Int>().also { it.add(arr.size) }
    for (i in arr.size - 1 downTo 1) {
        var cnt = arr[i - 1]

        for (pos in 0 until N) {
            if (cnt == 0) {
                result.add(pos, i)
                break
            }

            if (pos < result.size && result[pos] > i)
                cnt--
        }

    }

    result.forEachIndexed { index, i ->
        if (index != result.size - 1)
            print("$i ")
        else
            print(i)
    }

}
