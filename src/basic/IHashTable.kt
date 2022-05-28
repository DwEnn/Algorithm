package basic

interface IHashTable<K, V> {
    fun put(key: K, value: V)
    fun get(key: K): V?
    fun delete(key: K): Boolean
    fun contains(key: K): Boolean
    fun size(): Int
}
