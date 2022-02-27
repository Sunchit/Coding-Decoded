
// @saorav21994
// TC : O(n+m)
// SC : O(n+m)

class Solution {
    public int compareVersion(String version1, String version2) {
        String[]  v1 = version1.split("\\.");
        String[]  v2 = version2.split("\\.");
        int v1l = v1.length;
        int v2l = v2.length;
        int maxLen = Math.max(v1l, v2l);
        int [][] arr = new int[2][maxLen];
        for (int i = 0; i < maxLen; i++) {
            if (i < v1l) {
                arr[0][i] = Integer.parseInt(v1[i]);
            }
            if (i < v2l) {
                arr[1][i] = Integer.parseInt(v2[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            if (arr[0][i] > arr[1][i]) {
                res = 1;
                break;
            }
            else if (arr[0][i] < arr[1][i]) {
                res = -1;
                break;
            }
        }        
        return res;
    }
}
