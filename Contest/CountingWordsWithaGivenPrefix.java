class Solution {
	// TC : O(no of words * pref length)
	// SC : O(1)
	public int prefixCount(String[] words, String pref) {
		int count = 0;
		for(String word: words){
			count += (word.startsWith(pref) == true) ? 1 :0 ;
		}
		return count;
	}
}