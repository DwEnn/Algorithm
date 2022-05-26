package basic

interface IHeap<T> {
    fun insert(value: T)
    fun contains(value: T): Boolean
    fun pop(): T
    fun peek(): T
    fun size(): Int
}
