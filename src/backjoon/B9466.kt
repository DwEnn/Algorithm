package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val t = br.readLine().toInt()
        repeat(t) {
            val n = br.readLine().toInt()
            val st = StringTokenizer(br.readLine())
            visited = BooleanArray(n + 1) { false }
            students = Array(n + 1) {
                if (it == 0)
                    Student(0, 0)
                else
                    Student(it, st.nextToken().toInt())
            }

            for (i in 1..n) {
                val student = students[i]
                if (!visited[student.no])
                    search(student)
            }

            var cnt = 0
            for (i in 1..n)
                if (!students[i].made) cnt++
            println(cnt)
        }
    }
}

private fun search(student: Student) {
    visited[student.no] = true

    val want = students[student.wantNo]
    if (visited[want.no]) {
        if (!want.searched) {
            buildTeam(student.no, want)
        }
    } else {
        search(want)
    }

    student.searched = true
}

private fun buildTeam(firstNo: Int, student: Student) {
    student.made = true

    if (student.no == firstNo)
        return

    buildTeam(firstNo, students[student.wantNo])
}

private lateinit var students: Array<Student>
private lateinit var visited: BooleanArray
private class Student(val no: Int, val wantNo: Int, var made: Boolean = false, var searched: Boolean = false)