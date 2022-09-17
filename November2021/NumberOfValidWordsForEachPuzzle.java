class Solution {
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		// English Character
		Map<Integer, List<Integer>> bucket = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			bucket.put(i, new ArrayList<>());
		}
		for (String word : words) {
			int temp = getBitMask(word);
			//
			for (int i = 0; i < 26; i++) {
				if ((temp & (1 << i)) != 0) {
					bucket.get(i).add(temp);
				}
			}
		}
		List<Integer> res = new ArrayList<>();
		for (String p : puzzles) {
			int puzzleMask =  getBitMask(p);
			int c = p.charAt(0) - 'a';
			int count = 0;
			// searching for those words that have first puzzle char
			for (int wordMask : bucket.get(c)) {
				if ((wordMask & puzzleMask) == wordMask) {
					count++;
				}
			}
			res.add(count);
		}
		return res;
	}

	private int getBitMask(String s) {
		int mask = 0;

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			mask |= getBitMask(c);
		}

		return mask;
	}

	private int getBitMask(char c) {
		int bit = (c - 'a');
		return (1 << bit);
	}
}