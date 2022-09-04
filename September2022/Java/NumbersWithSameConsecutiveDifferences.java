
// @saorav21994

// TC : O(2^n)
// SC : O(2^n)

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        // we need zero if n == 1, otherwise leading zeros not allowed, so special case
        if (n == 1) {       // difference won't matter
            return new int[] {0,1,2,3,4,5,6,7,8,9};
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(n-1, i, k, res);
        }
        
        // res.toArray(); -> will return Object ref (ex, Integer[], not int[])
        return res.stream().mapToInt(i->i).toArray();
    }
    
    public void dfs(int remDigit, int cur, int diff, List<Integer> res) {
        if (remDigit == 0) {
            res.add(cur);
            return;
        }
        
        // 2 cases -> cur+k, cur-k; also, if k == 0, only do num+k to avoid duplication
        
        int add = (cur%10)+diff;
        if (add < 10)
            dfs(remDigit-1, cur*10+add, diff, res);
        if (diff > 0) {
            int sub = (cur%10)-diff;
            if (sub >= 0)
                dfs(remDigit-1, cur*10+sub, diff, res);
        }
        
    }
}
