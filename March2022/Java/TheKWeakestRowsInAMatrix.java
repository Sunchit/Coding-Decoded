
// @saorav21994
// TC : O(nlogn)
// SC : O(n)

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        int [][] data = new int[r][2];
        for (int i = 0; i < r; i++) {
            data[i][0] = i;
            int j = 0;
            while (j < c && mat[i][j] == 1) {
                data[i][1] += 1;
                j += 1;
            }
        }
        Arrays.sort(data, (a, b) -> a[1] - b[1]);
        // for (int i = 0; i < r; i++) {
        //     System.out.println(data[i][0] + " " + data[i][1]);
        // }
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = data[i][0];
        }
        return res;
    }
}
