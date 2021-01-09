import java.util.*

fun main() {

    val lambdaNull: ((Int, String) -> String)? = null
    println(lambdaNull?.invoke(1, "1"))

    println(HighOrderFunc("sef"))

    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    val letters = listOf("Alpha", "Beta")
    println(letters.joinToStr())
    println(letters.joinToStr { it.toLowerCase() })
    println(letters.joinToStr(separator = "! ", postfix = "! ",
            transform = { it.toUpperCase() }))

    // return func
    var calc = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calc(Order(3))}")
    calc = getShippingCostCalculator(Delivery.STANDARD)
    println("Shipping costs ${calc(Order(3))}")

    // 람다로 중복 제거
    val log = listOf(
            SiteVisit("/", 34.0, OS.WINDOW),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOW),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID)
    )

    val averageWindowsDuration = log.filter { it.os == OS.WINDOW }
            .map(SiteVisit::duration).average()

    println(averageWindowsDuration)
    // -> Top-backjoon.level func 로 변경
    println(log.averageDurationFor(OS.ANDROID))
    println(log.averageDurationFor(OS.IOS))

    val a = SiteVisit::path
    println(a.get(SiteVisit("/", 16.3, OS.ANDROID)))

}

// 특정 OS 의 평균 접속 시간을 구하는 코드
// -> Top-backjoon.level func 로 변경
private fun List<SiteVisit>.averageDurationFor(os: OS) =
        filter{ it.os == os }.map(SiteVisit::duration).average()

private enum class OS { WINDOW, LINUX, MAC, IOS, ANDROID }
private data class SiteVisit(val path: String, val duration: Double, val os: OS)

private enum class Delivery { STANDARD, EXPEDITED }

private class Order(val itemCnt: Int)

private fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED)
        return { order -> 6 + 2.1 * order.itemCnt }

    return { order -> 1.2 * order.itemCnt }
}

private fun Collection<String>.joinToStr(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        transform: (String) -> String = { it }
): String {

    val result = kotlin.text.StringBuilder(prefix)

    for ((idx, element) in withIndex()) {
        if (idx > 0)
            result.append(separator)

        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}

private fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

object HighOrderFunc {

    operator fun invoke(str: String): String =
            str.toUpperCase()

}