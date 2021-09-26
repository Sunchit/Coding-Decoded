class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length, colMovesNeeded = 0, rowMovesNeeded = 0, noOfOnesInFirstRow = 0, noOfOnesInFirstCol = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((board[0][0] ^ board[i][0]) ^ (board[i][j] ^ board[0][j])) == 1) {
                    return -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            noOfOnesInFirstRow += board[0][i];
            noOfOnesInFirstCol += board[i][0];
            // Find the max swaps needed in worst case
            if (board[i][0] == i % 2) {
                rowMovesNeeded++;
            }
            if (board[0][i] == i % 2) {
                colMovesNeeded++;
            }
        }
        if (noOfOnesInFirstRow < N / 2 || noOfOnesInFirstRow > (N + 1) / 2) {
            return -1;
        }
        if (noOfOnesInFirstCol < N / 2 || noOfOnesInFirstCol > (N + 1) / 2) {
            return -1;
        }
        // N is odd
        if (N % 2 == 1) {
            // If colMovesNeeded is Odd, let us do the inverse
            if (colMovesNeeded % 2 == 1) {
                colMovesNeeded = N - colMovesNeeded;
            }
            // If rowMovesNeeded is Odd, let us do the inverse
            if (rowMovesNeeded % 2 == 1) {
                rowMovesNeeded = N - rowMovesNeeded;
            }
        } else {
            // Find min count (X, XBar)
            colMovesNeeded = Math.min(colMovesNeeded, N - colMovesNeeded);
            rowMovesNeeded = Math.min(rowMovesNeeded, N - rowMovesNeeded);
        }
        return (colMovesNeeded + rowMovesNeeded) / 2;
    }
}