package basic

class MyDoubleLinkedList<T : Any> : IList<T> {

    private var head: Node? = Node(null).apply { next = tail }
    private var tail: Node? = Node(null).apply { prev = head }
    private var size = 0

    override fun add(t: T) {
        val last = this.tail?.prev
        val node = Node(t, last, this.tail)
        last?.next = node
        this.tail?.prev = node
        this.size++
    }

    override fun insert(index: Int, t: T) {
        if (index > this.size || index < 0)
            throw IndexOutOfBoundsException("Out Of Bounds")

        var prev: Node?
        var curr: Node?

        var i = 0
        if (index < this.size / 2) {
            prev = this.head
            curr = this.head?.next

            while (i++ < index) {
                prev = prev?.next
                curr = curr?.next
            }
        } else {
            curr = this.tail
            prev = this.tail?.prev
            while (i++ < (this.size - index)) {
                curr = curr?.prev
                prev = prev?.prev
            }
        }
        val node = Node(t, curr, prev)
        curr?.prev = node
        prev?.next = node
        this.size++
    }

    override fun clear() {
        this.size = 0
        this.head?.next = this.tail
        this.head?.prev = null
        this.tail?.next = null
        this.tail?.prev = this.head
    }

    override fun delete(t: T): Boolean {
        var prev = this.head
        var curr = prev?.next
        while (curr != null) {
            if (curr.data == t) {
                prev?.next = curr.next
                curr.next?.prev = prev
                curr.prev = null
                curr.next = null
                size--
                return true
            }
            prev = prev?.next
            curr = curr.next
        }
        return false
    }

    override fun deleteByIndex(index: Int): Boolean {
        if (index >= this.size || index < 0)
            throw IndexOutOfBoundsException("Out Of Bounds")

        var prev: Node?
        var curr: Node?
        var next: Node?

        var i = 0
        if (index < this.size / 2) {
            prev = this.head
            curr = this.head?.next
            while (i++ < index) {
                prev = prev?.next
                curr = curr?.next
            }

            prev?.next = curr?.next
            curr?.next?.prev = prev
            curr?.next = null
            curr?.prev = null
        } else {
            curr = this.tail?.prev
            next = this.tail
            while (i++ < (this.size - index - 1)) {
                next = next?.prev
                curr = curr?.prev
            }
            next?.prev = curr?.prev
            curr?.prev?.next = next
            curr?.next = null
            curr?.prev = null
        }
        this.size--
        return true
    }

    override operator fun get(index: Int): T {
        if (index >= this.size || index < 0)
            throw IndexOutOfBoundsException("Out Of Bounds")

        var i = 0
        val curr = if (index < this.size / 2) { // index 가 헤드에서 더 가까우면
            var temp = this.head?.next
            while (i++ < index) {
                temp = temp?.next
            }
            temp
        } else { // index 가 tail 에서 가까우면
            var temp = this.tail?.prev
            while (i++ < (this.size - index - 1)) { // 역순으로 index 탐색
                temp = temp?.prev
            }
            temp
        }
        return curr?.data!!
    }

    override fun indexOf(t: T): Int {
        var head = this.head?.next
        var tail = this.tail?.prev
        var i = 0
        do {
            if (head?.data == t) {
                return i
            } else if (tail?.data == t) {
                return size - i - 1
            }
            head = head?.next
            tail = tail?.prev
        } while (i++ < this.size / 2)
        return -1
    }

    override fun isEmpty(): Boolean {
        return this.head?.next == this.tail && this.tail?.prev == this.head
    }

    override fun contains(t: T): Boolean {
        var head = this.head?.next
        var tail = this.tail?.prev
        var i = 0
        do {
            if (head?.data == t || tail?.data == t) {
                return true
            }
            head = head?.next
            tail = tail?.prev
        } while (i++ < this.size / 2)

        return false
    }

    override fun size(): Int {
        return size
    }

    private inner class Node(
        var data: T?,
        var prev: Node? = null,
        var next: Node? = null
    )
}
