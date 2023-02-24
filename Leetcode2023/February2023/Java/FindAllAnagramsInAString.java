// @saorav21994

class Solution {

	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> ans = new ArrayList<>();

		int unmatchingCharCount = t.length();

		if(t.length()>s.length()){
			return ans;
		}

		int[] freqCount = new int[26];

		for(int i=0;i<t.length();i++){
			int index = t.charAt(i)-'a';
			freqCount[index]++;
		}

		int start =0;
		int end =0;
		for(;end<t.length();end++) {
			int index = s.charAt(end)-'a';
			if(freqCount[index]>0){

				unmatchingCharCount--;
			}
			freqCount[index]--;

		}
		if(unmatchingCharCount==0){
			ans.add(start);

		}
		for(;end<s.length();){
			// remove starting index
			int indexStart = s.charAt(start) -'a';

			if(freqCount[indexStart]>=0) {
				// char was present in t
				unmatchingCharCount++;
			}

			freqCount[indexStart]++;

			start++;

			int indexEnd = s.charAt(end)-'a';
			if(freqCount[indexEnd]>0){
				unmatchingCharCount--;
			}
			freqCount[indexEnd]--;

			end++;

			if(unmatchingCharCount==0){
				ans.add(start);
			}

		}

		return ans;
	}
}
