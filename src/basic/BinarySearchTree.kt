package basic

class BinarySearchTree<T : Comparable<T>> : ITree<T> {

    private var root: Node<T>? = null
    private var size = 0

    fun min(): T {
        return this.minNode(this.root)
    }

    private fun minNode(node: Node<T>?): T {
        var minData = node?.data
        var node = node
        while (node?.left != null) {
            minData = node.left!!.data
            node = node.left!!
        }
        return minData!!
    }

    fun max(): T {
        return this.maxNode(this.root)
    }

    private fun maxNode(node: Node<T>?): T {
        var maxData = node?.data
        var node = node
        while (node?.right != null) {
            maxData = node.right!!.data
            node = node.right!!
        }
        return maxData!!
    }

    override fun insert(value: T) {
        this.root = this.insertNode(this.root, value)
        this.size++
    }

    private fun insertNode(node: Node<T>?, value: T): Node<T> {
        if (node == null) return Node(value)

        if (value < node.data) {
            node.left = insertNode(node.left, value)
        } else if (value > node.data) {
            node.right = insertNode(node.right, value)
        }

        return node
    }

    override fun delete(value: T) {
        this.deleteNode(this.root, value)
    }

    private fun deleteNode(node: Node<T>?, value: T): Node<T>? {
        if (node == null) return null

        if (value < node.data) {
            node.left = deleteNode(node.left, value)
        } else if (value > node.data) {
            node.right = deleteNode(node.right, value)
        } else {
            // value == node.data
            this.size--
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            }

            node.data = this.minNode(node.right)
            node.right = deleteNode(node.right, node.data)
        }
        return node
    }

    override fun contains(value: T): Boolean {
        return this.containsNode(this.root, value)
    }

    private fun containsNode(node: Node<T>?, value: T): Boolean {
        if (node == null) return false

        // a.compareTo(b)
        // a < b -> -1
        // a == b -> 0
        // a > b -> 1
        if (value.compareTo(node.data) == 0) {
            return true
        }
        if (value.compareTo(node.data) < 0) {
            return containsNode(node.left, value)
        }

        // value.compareTo(node.data) > 0)
        return containsNode(node.right, value)
    }

    override fun size(): Int {
        return this.size
    }

    fun preOrder(): List<T> {
        return this.preorderTree(root, mutableListOf())
    }

    private fun preorderTree(node: Node<T>?, visited: MutableList<T>): List<T> {
        if (node == null) return visited

        visited.add(node.data)
        preorderTree(node.left, visited)
        preorderTree(node.right, visited)

        return visited
    }

    fun inOrder(): List<T> {
        return this.inorderTree(root, mutableListOf())
    }

    private fun inorderTree(node: Node<T>?, visited: MutableList<T>): List<T> {
        if (node == null) return visited

        inorderTree(node.left, visited)
        visited.add(node.data)
        inorderTree(node.right, visited)

        return visited
    }

    fun postOrder(): List<T> {
        return this.postorderTree(root, mutableListOf())
    }

    private fun postorderTree(node: Node<T>?, visited: MutableList<T>): List<T> {
        if (node == null) return visited

        postorderTree(node.left, visited)
        postorderTree(node.right, visited)
        visited.add(node.data)

        return visited
    }

    private class Node<T>(
        var data: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    )
}
