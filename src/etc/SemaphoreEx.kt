package etc

import java.util.concurrent.Semaphore

fun main() {
    val sem = Semaphore(3)
    val th1 = SyncMulti(sem, "1")
    val th2 = SyncMulti(sem, "2")
    val th3 = SyncMulti(sem, "3")
    val th4 = SyncMulti(sem, "4")

    th1.start()
    th2.start()
    th3.start()
    th4.start()
}

private class SyncMulti(
    private val sem: Semaphore,
    private val msg: String
) : Thread() {
    override fun run() {
        try {
            sem.acquire() // 실행
            println(msg)
            sleep(5000) // 5초 딜레이
            sem.release() // 끊어줌
            // 세마포어를 실행시키고 5초 후에는 세마포어를 끊어준다.
        } catch (e: java.lang.Exception) {
        }
    }
}
