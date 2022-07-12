
// @saorav21994
// TC : O(4^n)
// SC : O(n)

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int sum = 0;
        for (int len : matchsticks) {
            sum += len;
        }
        if (sum%4 != 0) return false;
        int max = sum/4;
        Arrays.sort(matchsticks);
        int [] arr = new int[] {max, max, max, max};
        if (matchsticks[matchsticks.length-1] > max) return false;
        return dfs(matchsticks.length-1, matchsticks, arr);
    }
    
    public boolean dfs(int idx, int [] matchsticks, int [] arr) {
        if (idx < 0) {
            return ((arr[0] == 0) && (arr[1] == 0) && (arr[2] == 0) && (arr[3] == 0));
        }
        for (int j = 0; j < 4; j++) {
            if (matchsticks[idx] > arr[j]) continue;    // Diff will be negative
            arr[j] -= matchsticks[idx];
            if (dfs(idx-1, matchsticks, arr)) return true;
            arr[j] += matchsticks[idx];
        }
        return false;
    }
}
