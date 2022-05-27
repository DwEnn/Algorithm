package programmers

/**
 * 모음 사전
 * @link https://programmers.co.kr/learn/courses/30/lessons/84512
 */
fun main() {
//    val word = "AAAAE"
    val word = "EIO"
    println(solution(word))
}

private val arr = arrayOf("A", "E", "I", "O", "U")
private val result = mutableListOf<String>()

private fun solution(word: String): Int {
    dfs("")
    result.forEachIndexed { idx, s ->
        if (s == word) return idx
    }
    return -1
}

private fun dfs(str: String) {
    if (str.length > 5) return
    result.add(str)
    for (a in arr) {
        dfs(str + a)
    }
}

// private val words = arrayOf('A', 'E', 'I', 'O', 'U')

// private fun solution(word: String): Int {
//    var answer = 0
//    val stack = Stack<Char>()
//
//    for (i in words) {
//        stack.push(i)
//        answer++
//        if (stack.joinToString("") == word)
//            return answer
//        for (j in words) {
//            stack.push(j)
//            answer++
//            if (stack.joinToString("") == word)
//                return answer
//            for (k in words) {
//                stack.push(k)
//                answer++
//                if (stack.joinToString("") == word)
//                    return answer
//                for (t in words) {
//                    stack.push(t)
//                    answer++
//                    if (stack.joinToString("") == word)
//                        return answer
//                    for (z in words) {
//                        stack.push(z)
//                        answer++
//                        if (stack.joinToString("") == word)
//                            return answer
//                        stack.pop()
//                    }
//                    stack.pop()
//                }
//                stack.pop()
//            }
//            stack.pop()
//        }
//        stack.pop()
//    }
//
//    return answer
// }
