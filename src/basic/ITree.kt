package basic

interface ITree<T> {
    fun insert(value: T)
    fun delete(value: T)
    fun contains(value: T): Boolean
    fun size(): Int
}
