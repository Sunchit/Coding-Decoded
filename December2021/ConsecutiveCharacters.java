// TC : O(n)
// SC : O(1)
class Solution {
	public int maxPower(String s) {
		if(s.length()==0){
			return 0;
		}
		int maxLen =1;
		int count = 1;

		for(int i=1;i<s.length();i++){
			if(s.charAt(i) == s.charAt(i-1)){
				count++;
			} else{
				count =1;
			}
			maxLen = Math.max(maxLen, count);

		}
		return maxLen;
	}
}