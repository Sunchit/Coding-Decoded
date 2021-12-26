class Solution {

	// TC : O(1)
	// SC : O(1)
	public boolean isSameAfterReversals(int num) {
		return num == 0 || !String.valueOf(num).endsWith("0");
	}
}