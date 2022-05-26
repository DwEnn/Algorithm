package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val sb = StringBuilder()

        repeat(br.readLine().toInt()) {
            var playerList = LinkedList<Player>()
            repeat(br.readLine().toInt()) {
                playerList.add(Player(it + 1, br.readLine()))
            }

            val k = playerList.first.command.length
            var round = 0
            while (round < k && playerList.size > 1) {
                playerList = play(round++, playerList)
            }

            if (playerList.size == 1)
                sb.append(playerList.first.name)
            else
                sb.append(0)

            sb.append("\n")
        }

        println(sb.toString())
    }
}

private fun play(round: Int, playerList: LinkedList<Player>): LinkedList<Player> {
    val set = HashSet<Char>()
    playerList.forEach { set.add(it.command[round]) }

    if (set.size < 3) {
        val winners = LinkedList<Player>()

        playerList.forEach { player ->
            var lose = false
            for (p in playerList) {
                if (rsp(player.command[round], p.command[round]) == -1) {
                    lose = true
                    break
                }
            }
            if (!lose)
                winners.add(player)
        }

        return winners
    } else {
        return playerList
    }


}

/**
 * @return win: 1, lose: -1, draw: 0
 */
private fun rsp(command1: Char, command2: Char): Int {
    when (command1) {
        'R' -> {
            return when (command2) {
                'S' -> 1
                'P' -> -1
                else -> 0
            }
        }
        'S' -> {
            return when (command2) {
                'R' -> -1
                'P' -> 1
                else -> 0
            }
        }
        else -> {
            return when (command2) {
                'R' -> 1
                'S' -> -1
                else -> 0
            }
        }
    }
}

private class Player(val name: Int, val command: String)