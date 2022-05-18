class Solution {
	// TC : O(n * len(str))
	// SC : O(1)
	public List<String> removeAnagrams(String[] words) {
		List<String> ans = new ArrayList<>();
		int start = 0;

		if(words.length>1) {
			int i=1;
			for(;i<words.length-1;) {
				if((i+1 < words.length) && (freq(words[start])).equals((freq(words[i])))){
					i++;
				} else {
					ans.add(words[start]);
					start = i;
					i++;
				}
			}

			ans.add(words[start]);
			if(!(freq(words[start])).equals((freq(words[words.length-1])))) {
				ans.add(words[words.length-1]);
			}
		} else {
			ans.add(words[start]);
		}
		return ans;
	}



	private String freq(String word){
		int[] freq = new int[26];
		for(char c: word.toCharArray()){
			freq[c-'a']++;
		}

		String ans = "";
		for(int el: freq){
			ans += el;
		}

		return ans;
	}
}