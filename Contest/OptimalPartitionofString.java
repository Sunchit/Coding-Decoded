class Solution {
	// TC : O(n)
	// SC : O(n)
	public int partitionString(String s) {
		int count = 0;

		Set<Character> set = new HashSet<>();

		for(char c : s.toCharArray()){

			// If character found in set
			if(set.contains(c)){
				count++;

				//reset
				set = new HashSet<>();
				set.add(c);

			} else {
				set.add(c);

			}
		}

		if(!set.isEmpty()) count++;

		return count;
	}
}

============= Space Optimized Approach ===============
// https://leetcode.com/problems/optimal-partition-of-string/
// @author: anuj0503
class Solution {
    public int partitionString(String s) {
        int i = 0;
        int n = s.length();
        int result = 0;
        while (i < n){
            int mask = 0;
            while(i < n && ((1 << (s.charAt(i) - 'a')) & mask) == 0){
                mask = mask | (1 << (s.charAt(i) - 'a'));
                i++;
            }

            result++;
        }

        return result;
    }
}
