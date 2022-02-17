class Solution {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates.length==0){
			return res;
		}
		combinationSumHelper(candidates, target, 0, new ArrayList<Integer>(), 0);
		return res;
	}




	private void combinationSumHelper(int[] candidates, int target, int currSum, List<Integer> subList, int index){
		if(index>=candidates.length || (currSum > target)){
			return ;
		}
		if(currSum == target){
			res.add(new ArrayList<>(subList));
			return ;
		}

		for(int i=index;i<candidates.length;i++){
			subList.add(candidates[i]);
			combinationSumHelper(candidates, target, currSum + candidates[i], subList, i);
			subList.remove(subList.size()-1);
		}
	}
}