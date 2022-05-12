package etc

fun main() {
    val bank1 = Bank("ATM")
    val bank2 = Bank("은행")

    bank1.start()
    bank2.start()
}

private class Account {
    var balance = 1000

    // 정수를 매개변수로 받아서
    // balance 의 값 보다 작거나 같으면
    // balance 에서 빼주는 메소드
    // 돈을 찾는 메소드
    fun withDraw(money: Int) {
        if (balance >= money) {
            try {
                Thread.sleep(1000)
            } catch (e: java.lang.Exception) {
            }
            balance -= money
        }
    }
}

// Thread 로 사용할 클래스
private class Bank(name: String) : Thread(name) {
    // 여러 개의 객체가 공유해서 사용할 수 있는 변수
    companion object {
        val obj = Account()
    }

    // 스레드로 수행할 메소드
    override fun run() {
        while (true) {
            // 100 ~ 300을 랜덤하게 추출
            val money = ((Math.random() * 3) + 1).toInt() * 100
            if (obj.balance >= money) {
                synchronized(obj) {
                    println("${name}의 balance : ${obj.balance}")
                    println("${name}의 찾는 금액 : $money")
                    obj.withDraw(money)
                    println("${name}의 balance : ${obj.balance}")
                }
            } else {
                println("$name Not enough money")
                break
            }
        }
    }
}
