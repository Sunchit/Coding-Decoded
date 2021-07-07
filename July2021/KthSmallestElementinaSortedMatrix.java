class Solution {


  // Solution One TC : O(nlogk)
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        pq.offer(matrix[i][j]);
        if (pq.size() > k) {
          pq.poll();
        }

      }
    }

    return pq.peek();
  }

  // Solution 2 using Binary Search
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];
    // lo < hi , not lo <= hit
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int count = lessEqual(matrix, mid);
      if (count < k)
        lo = mid + 1;
        //
      else
        hi = mid;
    }
    return lo;


  }

  //  from left-bottom or right-top can count how much numbers are less equal than target
  public int lessEqual(int[][] matrix, int target) {
    int cnt = 0, N = matrix.length, i = N - 1, j = 0;
    while (i >= 0 && j < N) {
      if (matrix[i][j] > target)
        i--;
      else {
        cnt = cnt + i + 1;
        j++;
      }
    }
    return cnt;
  }

}