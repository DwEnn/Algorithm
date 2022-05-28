package basic

import java.util.LinkedList

class MyLinkedHashTable<K, V>(
    private var bucketSize: Int = DEFAULT_BUCKET_SIZE
) : IHashTable<K, V> {

    companion object {
        private const val DEFAULT_BUCKET_SIZE = 1024
    }

    private val buckets = MutableList<LinkedList<Node>>(DEFAULT_BUCKET_SIZE) { LinkedList() }
    private var size = 0

    override fun put(key: K, value: V) {
        val idx = this.hash(key)
        val bucket = this.buckets[idx]
        for (node in bucket) {
            if (node.key == key) {
                node.data = value
                return
            }
        }
        val node = Node(key, value)
        bucket.add(node)
        this.size++
    }

    override fun get(key: K): V? {
        val idx = this.hash(key)
        val bucket = this.buckets[idx]
        for (node in bucket) {
            if (node.key == key) {
                return node.data
            }
        }
        return null
    }

    override fun delete(key: K): Boolean {
        val idx = this.hash(key)
        val bucket = this.buckets[idx]
        val iter = bucket.iterator()
        while (iter.hasNext()) {
            val node = iter.next()
            if (node.key == key) {
                iter.remove()
                this.size--
                return true
            }
        }
        return false
    }

    override fun contains(key: K): Boolean {
        val idx = this.hash(key)
        val bucket = this.buckets[idx]
        for (node in bucket) {
            if (node.key == key) {
                return true
            }
        }
        return false
    }

    override fun size(): Int {
        return this.size
    }

    private fun hash(key: K): Int {
        var hash = 0
        for (ch in key.toString().toCharArray()) {
            hash += ch.toInt()
        }
        return hash % this.bucketSize
    }

    private inner class Node(
        val key: K,
        var data: V
    )
}
