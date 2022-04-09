class Solution {
	public long[] kthPalindrome(int[] queries, int intLength) {
		int n = queries.length;
		long ans[] = new long[n];
		int i = 0;

		int halfPalindromeLength = ( intLength+1 )/2 ;

		long l = (long)Math.pow(10, halfPalindromeLength-1); //10
		long r = (long)Math.pow(10, halfPalindromeLength)-1; //99


		for(int q:queries){

			//if queries[ith] is within the range of
			//r-l+1 because 10 to 99 we have all the palindrome (in total we have 99-10 +1)
			long totalCount = (r-l+1);
			if(q<=totalCount){

				//first half is the minimum value in range (which is l) + query number -1
				//-1 bcz we have l (10) number palindrome also
				String leftHalf  = Long.toString(l+q-1);

				//second half is just mirror image (01)
				String rightHalf=(new StringBuilder(leftHalf)).reverse().toString();

				//now for intLength 4 we have (1001) and 3 we have (1001)
				//we don't need middle value (right half 0 index) if intLength is odd
				ans[i]=Long.parseLong( leftHalf+rightHalf.substring(intLength % 2 ) );

			}
			else{
				ans[i]=-1;
			}

			i++;
		}

		return ans;
	}
}