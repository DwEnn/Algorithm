package test

import basic.BinarySearchTree
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BSTTest {
    @Test
    fun basic() {
        val given = BinarySearchTree<Int>()
        given.insert(3)
        given.insert(1)
        given.insert(5)
        given.insert(4)
        given.insert(0)

        assertEquals(5, given.size())
        assertTrue(given.contains(0))
        assertTrue(given.contains(1))
        assertFalse(given.contains(2))
        assertTrue(given.contains(3))
        assertTrue(given.contains(4))
        assertTrue(given.contains(5))

        given.delete(5)
        given.delete(0)
        given.delete(-1)
        given.delete(10)
        assertEquals(3, given.size())
        assertFalse(given.contains(0))
        assertTrue(given.contains(1))
        assertFalse(given.contains(2))
        assertTrue(given.contains(3))
        assertTrue(given.contains(4))
        assertFalse(given.contains(5))
    }

    @Test
    fun inorder() {
        val given = BinarySearchTree<Int>()
        given.insert(3)
        given.insert(1)
        given.insert(5)
        given.insert(4)
        given.insert(0)

        val visited = given.inOrder()
        assertEquals(5, visited.size)
        assertEquals(listOf(0, 1, 3, 4, 5), visited)
    }

    @Test
    fun preorder() {
        val given = BinarySearchTree<Int>()
        given.insert(3)
        given.insert(1)
        given.insert(5)
        given.insert(4)
        given.insert(0)

        val visited = given.preOrder()
        assertEquals(5, visited.size)
        assertEquals(listOf(3, 1, 0, 5, 4), visited)
    }

    @Test
    fun postorder() {
        val given = BinarySearchTree<Int>()
        given.insert(3)
        given.insert(1)
        given.insert(5)
        given.insert(4)
        given.insert(0)

        val visited = given.postOrder()
        assertEquals(5, visited.size)
        assertEquals(listOf(0, 1, 4, 5, 3), visited)
    }

    @Test
    fun min() {
        val given = BinarySearchTree<Int>()
        given.insert(3)
        given.insert(1)
        given.insert(5)
        given.insert(4)
        given.insert(0)
        given.insert(-1)

        assertEquals(-1, given.min())
    }

    @Test
    fun max() {
        val given = BinarySearchTree<Int>()
        given.insert(3)
        given.insert(1)
        given.insert(5)
        given.insert(4)
        given.insert(0)
        given.insert(10)
        given.insert(15)

        assertEquals(15, given.max())
    }
}
