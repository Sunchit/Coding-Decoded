
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

// @saorav21994
// TC : O(n)
// SC : O(26) ~ constant

// Parse string and keep last position of each character. Re-parse string and if (last position of cur char == cur index), add this partition to list

class Solution {
    public List<Integer> partitionLabels(String s) {
        int l = s.length();
        int hash [] = new int[26];
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            hash[ch-97] = i;
        }
        List<Integer> res = new ArrayList<>();
        int target = -1;
        int prev = 0;
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            target = Math.max(target, hash[ch-97]);
            if (i == target) {
                res.add(i+1-prev);
                prev = i+1;
                target = -1;
            }
        }
        return res;
    }
}
