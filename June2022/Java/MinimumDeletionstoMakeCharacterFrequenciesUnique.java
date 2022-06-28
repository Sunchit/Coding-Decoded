class Solution {
	public int minDeletions(String s) {
		int deletion = 0;

		int[] freq = new int[26];

		for(char c : s.toCharArray()){
			freq[c-'a']++;
		}

		Set<Integer> uniquefrequencies = new HashSet<Integer>();
		for(int count : freq){
			while(count > 0 && uniquefrequencies.contains(count)){
				deletion++;
				count--;
			}
			uniquefrequencies.add(count);

		}

		return deletion;
	}
}


// a -> 3
//     b->2
//     c->2

// ceabaacb

// c- > 2
//     a ->3
//     b->2
//     e->1