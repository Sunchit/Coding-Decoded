class Solution {
	// TC : O(len(Word))
	public boolean detectCapitalUse(String word) {
		if(word.length()==0 || word.length()==1){
			return true;
		}

		char zeroChar = word.charAt(0);
		if(Character.isUpperCase(zeroChar)){
			// starting with the first character and then
			boolean isFirstCharUpper = Character.isUpperCase(word.charAt(1));
			for(int i =2;i<word.length();i++){
				boolean currentCharState = Character.isUpperCase(word.charAt(i));
				if(currentCharState!=isFirstCharUpper){
					return false;
				}
			}

		} else {
			// all should be lower
			for(int i =1;i<word.length();i++){
				if(Character.isUpperCase(word.charAt(i))){
					return false;
				}
			}
		}
		return true;


	}
}