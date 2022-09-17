// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
         val ans = Array(board.size) { IntArray(board[0].size) }
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                var n = 0
                if (board[i][j] == 1) {
                    if (i - 1 >= 0 && board[i - 1][j] == 1) {
                        n++
                    }
                    if (i + 1 < board.size && board[i + 1][j] == 1) {
                        n++
                    }
                    if (j - 1 >= 0 && board[i][j - 1] == 1) {
                        n++
                    }
                    if (j + 1 < board[0].size && board[i][j + 1] == 1) {
                        n++
                    }
                    if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
                        n++
                    }
                    if (i + 1 < board.size && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
                        n++
                    }
                    if (i - 1 >= 0 && j + 1 < board[0].size && board[i - 1][j + 1] == 1) {
                        n++
                    }
                    if (i + 1 < board.size && j + 1 < board[0].size && board[i + 1][j + 1] == 1) {
                        n++
                    }
                    if (n < 2 || n > 3) {
                        ans[i][j] = 0
                    } else {
                        ans[i][j] = board[i][j]
                    }
                } else {
                    if (i - 1 >= 0 && board[i - 1][j] == 1) {
                        n++
                    }
                    if (i + 1 < board.size && board[i + 1][j] == 1) {
                        n++
                    }
                    if (j - 1 >= 0 && board[i][j - 1] == 1) {
                        n++
                    }
                    if (j + 1 < board[0].size && board[i][j + 1] == 1) {
                        n++
                    }
                    if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
                        n++
                    }
                    if (i + 1 < board.size && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
                        n++
                    }
                    if (i - 1 >= 0 && j + 1 < board[0].size && board[i - 1][j + 1] == 1) {
                        n++
                    }
                    if (i + 1 < board.size && j + 1 < board[0].size && board[i + 1][j + 1] == 1) {
                        n++
                    }
                    if (n == 3) {
                        ans[i][j] = 1
                    } else {
                        ans[i][j] = board[i][j]
                    }
                }
            }
        }
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                board[i][j] = ans[i][j]
            }
        }
    }
}