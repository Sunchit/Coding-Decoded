// @saorav21994


// TC : O(2^n * O(nlog2) * O(n))
// Insert to set = O(log n), for 2^n elements (O(log 2^n)) = O(nlog2) = O(n)

class Solution {
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> res = new HashSet<>();
        dfs(nums, 0 /*start index*/, res, new ArrayList<>());
        
        return new ArrayList(res);
    }
    
    public void dfs(int [] nums, int start, Set<List<Integer>> res, List<Integer> cur) {
        /*
        System.out.println("numslength = " + nums.length + " start = " + start);
        for (Integer val : cur) {
            System.out.print(val + " ");
        }
        System.out.println("\n"+cur.size());
        */
        if (start == nums.length) {
            if (cur.size() >= 2) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
           
        if (cur.size() == 0 || cur.get(cur.size()-1) <= nums[start]) {
            cur.add(nums[start]);
            dfs(nums, start+1, res, cur);
            cur.remove(cur.size()-1);
        }
            
        dfs(nums, start+1, res, cur);
        
    }
}
