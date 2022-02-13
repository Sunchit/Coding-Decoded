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