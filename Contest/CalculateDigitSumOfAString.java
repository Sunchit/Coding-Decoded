class Solution {
	public String digitSum(String s, int k) {
		while(s.length()>k){
			s = roundTrip(s, k);
		}
		return s;
	}

	private String roundTrip(String s, int k){
		int i=0;
		int j=0;
		String ans = "";
		int sum=0;
		for(;i<s.length();){
			while(j<k && i<s.length()){
				sum += (s.charAt(i) -'0');
				j++;
				i++;
			}
			ans = ans +sum;
			j=0;
			sum = 0;
		}

		return ans;
	}
}
