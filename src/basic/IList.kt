package basic

interface IList<T> {
    fun add(t: T)

    fun insert(index: Int, t: T)

    fun clear()

    fun delete(t: T): Boolean

    fun deleteByIndex(index: Int): Boolean

    operator fun get(index: Int): T

    fun indexOf(t: T): Int

    fun isEmpty(): Boolean

    fun contains(t: T): Boolean

    fun size(): Int
}
