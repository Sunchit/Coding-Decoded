// Solution I using sorting
class Solution {

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> (b.getValue() - a.getValue()));

		pq.addAll(map.entrySet());
		String ans = "";
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> head = pq.poll();
			int freq = head.getValue();
			while (freq-- > 0) {
				ans += head.getKey();
			}
		}
		return ans;

	}


}

// Solution II using bucket sort
class Solution {

	public String frequencySort(String s) {
		if (s == null) {
			return null;
		}
		Map<Character, Integer> map = new HashMap();
		char[] charArray = s.toCharArray();
		int max = 0;
		for (Character c : charArray) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
			max = Math.max(max, map.get(c));
		}

		List<Character>[] array = buildBucketArray(map, max);

		return buildOutputString(array);
	}

	private List<Character>[] buildBucketArray(Map<Character, Integer> map, int maxCount) {
		List<Character>[] array = new List[maxCount + 1];
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (array[count] == null) {
				array[count] = new ArrayList();
			}
			array[count].add(c);
		}
		return array;
	}

	private String buildOutputString(List<Character>[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i > 0; i--) {
			List<Character> list = array[i];
			if (list != null) {
				for (Character c : list) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
}