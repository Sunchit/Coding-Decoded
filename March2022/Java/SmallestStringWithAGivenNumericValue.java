class Solution {
	public String getSmallestString(int n, int k) {
		char[] ans = new char[n];
		int i = 0 ;
		while(i<n){
			ans[i] = 'a';
			i++;
		}
		k = k - n;
		int j = n-1;
		while(k>0){
			if(k<25){
				ans[j] = (char)('a' + k);
				k = 0;
			} else {
				ans[j] = 'z';
				k = k - 25;
			}
			j--;
		}
		return new String(ans);


	}
}