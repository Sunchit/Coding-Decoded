
class Solution {
	public int minMaxGame(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for(int el: nums){
			list.add(el);
		}

		while(list.size()>1) {
			list = processList(list);
		}
		return list.get(0);
	}

	private List<Integer> processList(List<Integer> input){
		int i=0;

		List<Integer> ans = new ArrayList<>();
		for(;i<input.size()/2;){
			if(i%2==0) {
				ans.add(Math.min(input.get(2*i), input.get(2*i+1)));
			} else {

				ans.add(Math.max(input.get(2*i), input.get(2*i+1)));

			}
			i++;
		}
		return ans;
	}
}
