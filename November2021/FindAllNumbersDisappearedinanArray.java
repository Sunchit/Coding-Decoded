// O(n)
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			int el = Math.abs(nums[i])-1;
			if(nums[el]>0){
				nums[el] = -nums[el];
			}
		}

		for(int i=0;i<nums.length;i++){

			if(nums[i]>0){
				ans.add(i+1);
			}
		}
		return ans;
	}
}

