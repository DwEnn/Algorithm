package test

import basic.MyLinkedList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Random
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyLinkedListTest {
    @Test
    fun add() {
        val given = MyLinkedList<Int>()
        repeat(50) {
            given.add(it)
            assertEquals(it + 1, given.size())
            assertEquals(it, given[it])
        }
        given.insert(10, 999)
        assertEquals(51, given.size())
        assertEquals(999, given[10])
        given.insert(47, 998)
        assertEquals(52, given.size())
        assertEquals(998, given[47])
    }

    @Test
    fun insert() {
        val given = MyLinkedList<Int>()
        given.add(9)
        given.add(8)
        given.add(7)
        given.insert(0, 1)
        assertEquals(given.size(), 4)
    }

    @Test
    fun insert2() {
        val given = MyLinkedList<Int>()
        given.insert(0, 1)
        assertEquals(1, given.size())

        given.insert(1, 2)
        assertEquals(2, given.size())

        assertEquals(1, given[0])
        assertEquals(2, given[1])
    }

    @Test
    fun indexOf() {
        val given = MyLinkedList<Int>()
        repeat(50) {
            given.add(it)
        }
        repeat(50) {
            val idx = given.indexOf(it)
            assertEquals(it, idx)
        }
    }

    @Test
    fun insert_exception() {
        val given = MyLinkedList<Int>()
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            given.insert(2, 1)
        }
    }

    @Test
    fun clear() {
        val given = MyLinkedList<Int>()
        repeat(100) {
            given.add(it)
        }
        assertEquals(100, given.size())
        assertFalse { given.isEmpty() }
        given.clear()
        assertEquals(0, given.size())
        assertTrue { given.isEmpty() }
    }

    @Test
    fun deleteByIndex() {
        val given = MyLinkedList<Int>()
        repeat(100) {
            given.add(it)
        }
        val random = Random()
        val givenIndex = random.nextInt(99)
        val expected = given[givenIndex + 1]
        given.deleteByIndex(givenIndex)

        assertEquals(expected, given[givenIndex])
    }

    @Test
    fun delete() {
        val given = MyLinkedList<Int>()
        repeat(100) {
            given.add(it)
        }
        val random = Random()
        val target = random.nextInt(99)
        assertEquals(100, given.size())
        assertTrue { given.contains(target) }
        assertEquals(target, given.indexOf(target))
        given.delete(target)
        assertEquals(99, given.size())
        assertFalse { given.contains(target) }
        assertEquals(-1, given.indexOf(target))
    }
}
