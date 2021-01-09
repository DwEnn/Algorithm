package etc

fun main() {

    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)

    val p = Point(10, 20)
    println(p * 1.5)
    // 교환법칙 성립하지 않음 ( Double.times(p: Point): Point 를 추가적으로 선언해주어야함 )
//    println(1.5 * p)

    arrayOf("a", "b", "c").map(String::toUpperCase)

}

private data class Point(val x: Int, val y: Int)

private operator fun Point.plus(other: Point): Point = Point(x + other.x, y + other.y)

private operator fun Point.times(scale: Double): Point = Point((x * scale).toInt(), (y * scale).toInt())
