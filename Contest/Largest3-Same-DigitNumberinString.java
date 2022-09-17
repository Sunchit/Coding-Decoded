class Solution {

	// TC : O(n)
	// SC : O(1)

	public String largestGoodInteger(String num) {
		int start = 0;
		int i= 0;
		int ansDigit = -1;

		while(i<num.length()){
			if(i+1<num.length() && num.charAt(i) == num.charAt(i+1)){
				i++;
				continue;
			} else {
				int len = i -start +1;
				if(len>=3){
					ansDigit = Math.max(ansDigit, num.charAt(start) - '0');
				}
				start = i +1;
				i++;
			}
		}

		if(ansDigit!=-1){
			return ansDigit+"" + ansDigit+ ""+ansDigit;
		} else {
			return "";
		}
	}
}