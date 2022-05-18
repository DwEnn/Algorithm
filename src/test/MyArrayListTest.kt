package test

import basic.MyArrayList
import org.junit.jupiter.api.Test
import java.util.Random
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyArrayListTest {
    @Test
    fun add() {
        val given = MyArrayList<Int>()
        repeat(50) {
            given.add(it)
            assertEquals(it + 1, given.size())
            assertEquals(it, given[it])
        }
    }

    @Test
    fun clear() {
        val given = MyArrayList<Int>()
        repeat(100) {
            given.add(it)
        }
        assertEquals(100, given.size())
        assertFalse(given.isEmpty())
        given.clear()
        assertEquals(0, given.size())
        assertTrue { given.isEmpty() }
    }

    @Test
    fun deleteByIndex() {
        val given = MyArrayList<Int>()
        repeat(100) {
            given.add(it)
        }
        repeat(50) {
            val random = Random()
            val givenIndex = random.nextInt(99 - it)
            val expected = given[givenIndex + 1]
            given.deleteByIndex(givenIndex)
            assertEquals(expected, given[givenIndex])
        }
    }

    @Test
    fun delete() {
        val given = MyArrayList<Int>()
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
