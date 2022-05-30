package hackerrank

import java.util.LinkedList
import java.util.Scanner

// Complete the getMinimumCost function below.
fun getMinimumCost(k: Int, c: Array<Int>): Int {
    val queue = LinkedList<Int>()
    repeat(k) {
        queue.add(0)
    }

    var price = 0
    c.sortedDescending().forEach {
        val purchaseCount = queue.poll()
        price += (purchaseCount + 1) * it
        queue.add(purchaseCount + 1)
    }
    return price
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
}
