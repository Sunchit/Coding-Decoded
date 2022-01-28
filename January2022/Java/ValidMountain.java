class Solution {
	// TC : O(n)
	// SC : O(1)
	public boolean validMountainArray(int[] A) {
		int len = A.length;
		if(len==0){
			return false;
		}
		int i = 0;
		for(;i+1<len;i++){
			if(A[i]<A[i+1]){

			} else {
				break;
			}
		}

		if(i==0|| i==len-1){
			return false;
		}

		for(;i+1<len;i++){
			if(A[i]>A[i+1]){

			} else {
				break;
			}
		}
		return i==(len-1);
	}
}