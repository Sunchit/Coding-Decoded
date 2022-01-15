
class Solution {
	// TC: O(len(Str))
	// SC : O(1)
	public int myAtoi(String str) {
		int i = 0;
		int no =0;
		boolean neg = false;

		// triming white spaces
		while(i<str.length() && str.charAt(i)==' '){
			i++;
		}

		if(i<str.length() && str.charAt(i) == '-'){
			neg = true;
			i++;
		} else if(i<str.length() && str.charAt(i) == '+'){
			i++;
		}

		// now everything has to be no
		while(i<str.length() && Character.isDigit(str.charAt(i))){
			int c = str.charAt(i) -'0';
			if((Integer.MAX_VALUE - c)/10 <no){
				if(neg){
					return Integer.MIN_VALUE;
				} else{
					return Integer.MAX_VALUE;
				}
			}
			no = no*10 +  (c);
			i++;
		}

		if(no==0){
			return 0;
		} else{
			if(neg){
				return -no;
			} else
				return no;
		}


	}
}