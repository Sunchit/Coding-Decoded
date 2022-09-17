
class Solution {
	// TC : O(Max(a.length, b.length)
	// SC : O(a.length +b.length)
	public String addBinary(String a, String b) {
		String ans = "";
		int n = a.length();
		int m = b.length();
		int i=n-1;
		int j=m-1;
		int carry=0;
		while(i>=0 || j>=0) {

			int x = (i>=0)? a.charAt(i)-'0':0;
			int y=  (j>=0)?b.charAt(j)-'0':0;
			int sum = x+y+carry;
			carry = sum/2;
			ans = sum%2 + ans;
			i--;
			j--;
		}
		if(carry>0) {
			ans = carry + ans;
		}
		return ans;

	}
}