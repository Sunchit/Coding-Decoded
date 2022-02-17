
// @saorav21994
// Simple Backtracking


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, res, 0, target, new ArrayList<>());
        return res;
    }
    
    public void backtrack(int [] candidates, List<List<Integer>> res, int index, int target, List<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if (target < 0 || index == candidates.length) {
            return;
        }
        
        // skip current element
        backtrack(candidates, res, index+1, target, cur);
        
        // take current element
        cur.add(candidates[index]);
        backtrack(candidates, res, index, target-candidates[index], cur);

        cur.remove(cur.size()-1);
    }
}
