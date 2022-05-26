package basic

import java.util.Collections

class MaxHeap<T : Comparable<T>>(
    maxSize: Int
) : IHeap<T> {

    // 0번째를 비워두고 1번째 부터 데이터를 삽입하기 때문에 maxSize + 1
    private val data = arrayOfNulls<Any?>(maxSize + 1) as Array<T?>
    private var size = 0

    private fun parent(pos: Int): Int {
        return pos / 2
    }

    private fun leftChild(pos: Int): Int {
        return pos * 2
    }

    private fun rightChild(pos: Int): Int {
        return (pos * 2) + 1
    }

    private fun isLeaf(pos: Int): Boolean {
        return (pos > (size / 2) && pos <= size)
    }

    override fun insert(value: T) {
        this.data[++this.size] = value

        var current = size
        while (data[parent(current)] != null &&
            data[current]!! > data[parent(current)]!!
        ) {
            Collections.swap(listOf(this.data), current, parent(current))
            current = parent(current)
        }
    }

    override fun pop(): T {
        val top = this.data[1]!!

        this.data[1] = this.data[this.size--]
        heapify(1)
        return top
    }

    private fun heapify(idx: Int) {
        // idx 가 리프 노드라면 연산할 필요가 없음
        if (isLeaf(idx)) return

        val current = this.data[idx]!!
        val left = this.data[leftChild(idx)]!!
        val right = this.data[rightChild(idx)]!!

        if (current < left || current > right) {
            if (left > right) {
                Collections.swap(listOf(this.data), idx, leftChild(idx))
                heapify(leftChild(idx))
            } else {
                Collections.swap(listOf(this.data), idx, rightChild(idx))
                heapify(rightChild(idx))
            }
        }
    }

    override fun peek(): T {
        if (this.size < 1)
            throw RuntimeException("Empty")
        return this.data[1]!!
    }

    override fun size(): Int {
        return this.size
    }

    override fun contains(value: T): Boolean {
        for (i in 1..this.data.size) {
            if (value == this.data[i]) {
                return true
            }
        }
        return false
    }
}
