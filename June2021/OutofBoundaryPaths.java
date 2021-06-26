/*@author : Coding Decoded
 TC : O(n *m*maxxMoves)
 SC : O(n*m*maxMoves)
 question link : https://leetcode.com/problems/out-of-boundary-paths/
 */
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

/* @author : Darshika Jha
   question link : https://leetcode.com/problems/out-of-boundary-paths/
*/

class Solution {
  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    HashMap<String,Long> hm = new HashMap<>();
    long res = findPathsHelper(m,n,maxMove,startRow,startColumn,hm);
    return (int) res;
  }

  public long findPathsHelper(int m, int n, int maxMove, int startRow, int startColumn,HashMap<String,Long> hm){
    if(maxMove < 0){
      return 0;
    }
    if(startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n){
      return 1;
    }
    if(hm.containsKey(startRow+";"+startColumn+";"+maxMove)){
      return hm.get(startRow+";"+startColumn+";"+maxMove);
    }

    long res = 0;

    res += (findPathsHelper(m,n,maxMove-1,startRow-1,startColumn,hm) %1000000007);
    res += (findPathsHelper(m,n,maxMove-1,startRow,startColumn+1,hm) %1000000007);
    res += (findPathsHelper(m,n,maxMove-1,startRow+1,startColumn,hm) %1000000007);
    res += (findPathsHelper(m,n,maxMove-1,startRow,startColumn-1,hm) %1000000007);
    hm.put(startRow+";"+startColumn+";"+maxMove,(res %1000000007));
    return (res %1000000007);
  }
}
