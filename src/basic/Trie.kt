package basic

import java.lang.Exception

/**
 * Trie(트라이) 자료구조 구현
 * @link https://the-dev.tistory.com/3
 */
fun main() {
    val str1 = "POW"
    val str2 = "PIE"
    val str3 = "POWER"
    val str4 = "PI"

    val trie = Trie()
    trie.insert(str1)
    trie.insert(str2)
    trie.insert(str3)
    trie.insert(str4)

    println(trie.contains("PIE"))
    trie.delete("PI")
}

private class Trie {
    private val rootNode = TrieNode()

    /**
     * 자식 노드 추가, 추가하려는 계층의 자식 노드가 존재하지 않을 때만 자식 노드를 생성
     */
    fun insert(str: String) {
        var node = rootNode

        for (i in str.indices) {
            node = node.childNodes.computeIfAbsent(str[i]) {
                TrieNode()
            }
        }

        node.isLastChar = true
    }

    /**
     * 특정 단어가 들어있는지 확인, 아래의 두 조건을 만족
     * 1. 루트 노드부터 순서대로 알파벳이 일치하는 자식노드들이 존재
     * 2. 해당 단어의 마지막 글자에 해당하는 노드의 isLastChar 가 true
     */
    fun contains(str : String): Boolean {
        var node = rootNode
        for (i in str.indices) {
            val n = node.childNodes[str[i]] ?: return false
            node = n
        }

        return node.isLastChar
    }

    /**
     * 문자열 삭제, 주어진 단어를 탐색 후 다시 올라가며 삭제하는 과정
     * 아래의 조건을 충족해야한다
     * 1. 자식 노드를 가지고 있지 않아야함
     * 2. 삭제를 시작하는 첫 노드의 isLastCher == true
     * 3. 삭제를 진행하는 중 isLastChar == false
     */
    fun delete(str: String) {
        delete(rootNode, str, 0)
    }

    private fun delete(node: TrieNode, str: String, idx: Int) {
        val c = str[idx]

        val childNode = node.childNodes[c]
        require(childNode != null) {
            Exception("There is no[$str] in this Trie")
        }

        if (idx == str.length - 1) {
            // 삭제 조건 2.
            require(childNode.isLastChar) {
                Exception("There is no[$str] in this Trie")
            }
            childNode.isLastChar = false
            // 삭제 조건 1.
            if (childNode.childNodes.isEmpty())
                node.childNodes.remove(c)
        } else {
            delete(childNode, str, idx + 1)
            // 삭제 조건 1, 3.
            if (!childNode.isLastChar && childNode.childNodes.isEmpty())
                node.childNodes.remove(c)
        }

    }

}

private class TrieNode {
    // 자식 노드
    val childNodes = HashMap<Char, TrieNode>()
    // 마지막 글자 여부
    var isLastChar = false
}