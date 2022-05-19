package basic

class MyArrayList<T : Any> : IList<T> {

    companion object {
        private const val DEFAULT_SIZE = 50
    }

    private var elements = Array<Any?>(DEFAULT_SIZE) { }
    private var size: Int = 0

    override fun add(t: T) {
        increaseElementsIfFull()
        elements[size++] = t
    }

    override fun insert(index: Int, t: T) {
        increaseElementsIfFull()
        for (i in index until size) {
            elements[i + 1] = elements[i]
        }
        elements[index] = t
        size++
    }

    /**
     * elements 크기 늘리기
     */
    private fun increaseElementsIfFull() {
        if (size == elements.size) {
            elements = elements.copyOf(size * 2)
        }
    }

    override fun clear() {
        size = 0
        elements = Array(DEFAULT_SIZE) { }
    }

    override fun delete(t: T): Boolean {
        for (i in 0 until size) {
            if (elements[i] == t) {
                moveElementsToLeftByIndex(i)
                size--
                return true
            }
        }
        return false
    }

    override fun deleteByIndex(index: Int): Boolean {
        // index 가 잘못된 경우
        if (index < 0 || index > size - 1)
            return false
        moveElementsToLeftByIndex(index)
        size--
        return true
    }

    private fun moveElementsToLeftByIndex(index: Int) {
        for (i in index until size - 1) {
            elements[i] = elements[i + 1]
        }
    }

    override operator fun get(index: Int): T {
        if (index < 0 || index > size - 1)
            throw IndexOutOfBoundsException("Out Of Index")
        return elements[index] as T
    }

    override fun indexOf(t: T): Int {
        for (i in 0 until size) {
            if (elements[i] == t)
                return i
        }
        // 실제 index 범위가 아닌 -1 을 리턴하여 찾지 못했다는 것을 표현
        return -1
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun contains(t: T): Boolean {
        for (i in 0 until size) {
            if (elements[i] == t)
                return true
        }
        return false
    }

    override fun size(): Int {
        return size
    }
}
