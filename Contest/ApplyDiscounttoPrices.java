class Solution {
	public String discountPrices(String sentence, int discount) {
		String[] strList = sentence.split(" ");
		String ans = "";
		for(String s : strList) {
			if(valid(s)) {

				long val = Long.parseLong(s.substring(1));
				ans += ("$" +  String.format("%.2f", val*(1-discount/100.0d)));
			} else {
				ans += s;
			}
			ans += " ";
		}
		return ans.substring(0,ans.length()-1);
	}


	// $
	private boolean valid(String s){
		if(s.length()<=1){
			return false;
		}

		if(s.charAt(0)!='$'){
			return false;
		}


		for(int i=1;i<s.length();i++){
			if(!Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
}