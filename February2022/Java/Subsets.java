class Solution {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>();
		if(nums.length==0){
			return ans;
		}
		ans.add(new ArrayList<>());
		helper(nums, ans, new ArrayList<>(),0);
		return ans;
	}

	private void helper(int[] nums, List<List<Integer>> ans, List<Integer> curList, int index){
		if(index>=nums.length){
			return;
		} else{
			for(int i=index;i<nums.length;i++){
				curList.add(nums[i]);
				ans.add(new ArrayList<>(curList));
				helper(nums, ans, curList, i+1);
				curList.remove(curList.size()-1);
			}
		}
	}
}

// Another shorter solution but same approach
// Author : @romitdutta10
// Problem : https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        
        if(nums == null || nums.length == 0)
            return result;


        generateSubSets(nums, nums.length, 0, new ArrayList<>(), result);

        return result;
    }
    
    private static void generateSubSets(int nums[], int n, int index, List<Integer> temp,
                                       List<List<Integer>> result){
        result.add(new ArrayList<>(temp));

        for(int i=index;i<n;i++){
            temp.add(nums[i]);
            generateSubSets(nums, n, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
