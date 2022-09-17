class Solution {
	// Tc : O(len of string)
	// SC: O(1)
	public boolean checkString(String s) {
		boolean sawB = false;
		for(char c : s.toCharArray()){
			if(c=='a' && sawB){
				// voilation
				return false;
			}
			else if(c=='b'){
				sawB = true;
			}
		}
		return true;

	}
}