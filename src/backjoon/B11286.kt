package backjoon
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {
    val pq = PriorityQueue<Int> { o1, o2 ->
        if (abs(o1) >  abs(o2)) 1
        else if (abs(o1) == abs(o2)) {
            if (o1 >= o2)
                1
            else -1
        }
        else -1
    }

    BufferedReader(InputStreamReader(System.`in`)).use {
        repeat(it.readLine().toInt()) {i ->
            when(val num = it.readLine().toInt()) {
                0 -> {
                    if (pq.size != 0)
                        println(pq.poll())
                    else
                        println(0)
                }
                else -> pq.add(num)
            }
        }
    }
}