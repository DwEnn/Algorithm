package hackerrank

/*
 * Complete the 'isValid' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isValid(s: String): String {
    val map = HashMap<Char, Int>()
    for (c in s) {
        val count = map.getOrDefault(c, 0)
        map[c] = count + 1
    }

    val list = map.values.sorted()
    val min = list.first() * list.size
    val max = min + 1
    val result = if (list.sum() in min..max) {
        "YES"
    } else {
        val set = HashSet<Int>(list)
        if (set.size == 2 && list.count { it == 1 } == 1)
            "YES"
        else
            "NO"
    }
    return result
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = isValid(s)

    println(result)
}
