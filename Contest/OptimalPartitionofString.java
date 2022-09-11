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