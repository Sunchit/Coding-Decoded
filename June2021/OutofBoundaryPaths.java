
// TC : O(n *m*maxxMoves)
// SC : O(n*m*maxMoves)
class Solution {

  private Long[][][] memo = null;
  private int mod = 1000000007;

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    memo = new Long[m + 1][n + 1][maxMove + 1];
    return (int)(findPathsMemoHelper(m, n, maxMove, startRow, startColumn));
  }


  public long findPathsMemoHelper(int m, int n, int maxMove, int row, int col) {


    if (maxMove < 0) {
      return 0;
    }

    // boundary condition
    if (row == m || col == n || row < 0 || col <0) {
      return 1;
    }


    if (memo[row][col][maxMove] != null)
      return memo[row][col][maxMove];

    long total = 0;
    long left_maxMoveReduced = findPathsMemoHelper(m, n, maxMove - 1, row, col - 1);
    long right_maxMoveReduced = findPathsMemoHelper(m, n, maxMove - 1, row, col + 1);
    long up_maxMoveReduced = findPathsMemoHelper(m, n, maxMove - 1, row - 1, col);
    long down_maxMoveReduced = findPathsMemoHelper(m, n, maxMove - 1, row + 1, col);

    total =  (( left_maxMoveReduced + right_maxMoveReduced + down_maxMoveReduced + up_maxMoveReduced) % mod);
    memo[row][col][maxMove] = total;
    return total;
  }
}