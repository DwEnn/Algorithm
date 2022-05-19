package basic

class MyLinkedList<T : Any> : IList<T> {

    private var size = 0
    private var head: Node? = Node(null)

    override fun add(t: T) {
        var curr = head
        while (curr?.next != null) {
            curr = curr.next
        }
        val node = Node(t)
        curr?.next = node
        size++
    }

    override fun insert(index: Int, t: T) {
        if (index > size || index < 0) {
            throw IndexOutOfBoundsException("Out of Bounds")
        }

        var prev = head
        var curr = prev?.next

        var i = 0
        while (i++ < index) {
            prev = prev?.next
            curr = curr?.next
        }

        val node = Node(t, curr)
        prev?.next = node
        size++
    }

    override fun clear() {
        size = 0
        head?.next = null
    }

    override fun delete(t: T): Boolean {
        var prev = head
        var curr = prev?.next
        while (curr != null) {
            if (curr.data == t) {
                prev?.next = curr.next
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
        if (index >= size || index < 0) {
            throw IndexOutOfBoundsException("Out of Bounds")
        }

        var prev = head
        var curr = prev?.next

        var i = 0
        while (i++ < index) {
            prev = prev?.next
            curr = curr?.next
        }

        prev?.next = curr?.next
        curr?.next = null
        size--
        return true
    }

    override operator fun get(index: Int): T {
        if (index >= size || index < 0) {
            throw IndexOutOfBoundsException("Out of Bounds")
        }

        // head 는 더미노드로 사용하고 있기 때문에, 실제 데이터인 head.next 부터 검색 시작
        var curr = head?.next
        var i = 0
        while (i++ < index) {
            curr = curr?.next
        }
        return curr?.data!!
    }

    override fun indexOf(t: T): Int {
        var curr = head?.next
        var index = 0
        while (curr != null) {
            if (t == curr.data) {
                return index
            }
            curr = curr.next
            index++
        }
        return -1
    }

    override fun isEmpty(): Boolean {
        return head?.next == null
    }

    override fun contains(t: T): Boolean {
        var curr = head?.next
        while (curr != null) {
            if (curr.data == t) {
                return true
            }
            curr = curr.next
        }
        return false
    }

    override fun size(): Int {
        return size
    }

    private inner class Node(
        val data: T?,
        var next: Node? = null
    )
}
