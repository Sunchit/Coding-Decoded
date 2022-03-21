class Solution {
	public List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<>();
		int[] endIndex = new int[26];
		for(int i =0;i<s.length();i++){
			endIndex[s.charAt(i) - 'a'] = i;
		}


		int i = 0; // start Pointer
		while(i<s.length()){
			char startChar = s.charAt(i);
			int terminalIndex = endIndex[startChar-'a'];

			for(int j= 0;j<=terminalIndex;j++){
				terminalIndex = Math.max(terminalIndex, endIndex[s.charAt(j)-'a']);
			}

			ans.add(terminalIndex- i+1);
			i=terminalIndex+1;
		}
		return ans;
	}
}