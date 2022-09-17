
// @saorav21994
// Simple DFS -> Iterate for each digit from 1 -> 9

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, k, n, new ArrayList<Integer>(), 1/*starting value*/);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, int k, int n, List<Integer> cur, int start) {
        
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if ((n == 0 && k != 0) || (n != 0 && k == 0) || (n < 0) || (k < 0)) {
            return;
        }
        
        // numbers range is 1-9
        for (int idx = start; idx < 10; idx++) {
            cur.add(idx);
            dfs(res, k-1, n-idx, cur, idx+1);
            cur.remove(cur.size()-1);
        }
        
    }
}
