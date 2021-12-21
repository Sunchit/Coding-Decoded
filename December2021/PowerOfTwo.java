// TC  : O(1)
// SC : O(1)
class Solution {
	 public boolean isPowerOfTwo(int n) {
	     if(n == 0 || n ==Integer.MIN_VALUE){
	         return false;
	     }
	     int ans = n&(n-1);
	     return (ans==0);
	 }

	public boolean isPowerOfTwo(int n) {

		if(n == 0 || n ==Integer.MIN_VALUE){
			return false;
		}
		boolean foundOne = false;
		for(int i=0;i<32;i++){
			if(((n>>i)&1)==1){
				if(foundOne){
					return false;
				}
				foundOne = true;
			}
		}
		return true;
	}
}