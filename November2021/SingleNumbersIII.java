public class Solution {
	public int[] singleNumber(int[] nums) {
		int xor = 0;
		for(int num: nums){
			xor^=num;
		}
		int elWithLowestBitSet = Integer.highestOneBit(xor);

		int[] ans = new int[2];

		for(int num: nums){
			// Column where the bit is unset
			if((elWithLowestBitSet & num) == 0){
				ans[0] ^= num;
			}
			else{
				// Column where the bit is set
				ans[1] ^= num;
			}
		}
		return ans;
	}
}