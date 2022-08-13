class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<Integer>();

		int len = words[0].length(); // length of each word

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);


		for (int i = 0; i <= s.length() - len * words.length; i++) {

			Map<String, Integer> copyMap = new HashMap<String, Integer>(map);

			for (int j = 0; j < words.length; j++) {
				String str = s.substring(i + j*len, i + j*len + len);

				// System.out.println(str +" " + len);
				if (copyMap.containsKey(str)) { // is in remaining words
					int count = copyMap.get(str);
					if (count == 1) copyMap.remove(str);
					else copyMap.put(str, count - 1);
					if (copyMap.isEmpty()) { // matches
						ans.add(i);
						break;
					}
				}   else { break; }
			}
		}
		return ans;
	}
}
