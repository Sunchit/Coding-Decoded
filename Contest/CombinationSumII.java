// https://leetcode.com/problems/combination-sum-ii/
// @author: anuj0503
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        
        Arrays.sort(candidates);
        getSubsets(0, new ArrayList<Integer>(), candidates, target, candidates.length);
        
        return result;      
    }
    
    private void getSubsets(int index, ArrayList<Integer> al, int[] nums, int target, int n){
        if(target == 0){
            result.add(new ArrayList<Integer>(al));
            return;
        }
        
        if(target < 0){
            return;
        }
        
        for(int i = index; i < n; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            
            al.add(nums[i]);
            getSubsets(i + 1, al, nums, target - nums[i], n);
            
            al.remove(al.size() - 1);
        }
    }
}
