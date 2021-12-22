class SORTracker {
	// Scores, Name of Locations
	private TreeMap<Integer, List<String>> map;

	private int queryCount = 0;

	public SORTracker() {
		map = new TreeMap<>((a, b) -> b - a);
	}

	public void add(String name, int score) {
		map.putIfAbsent(score, new ArrayList<>());
		List<String> locationList = map.get(score);

		if (locationList.size() == 0) locationList.add(name);
		else {
			int idx = insertionIndexUsingBinarySearch(locationList, name);
			locationList.add(idx, name);
		}
		map.put(score, locationList);
	}

	public String get() {
		int searchIndex = queryCount;
		String res = "";
		for (int score : map.keySet()) {
			if (searchIndex < map.get(score).size()) {
				res = map.get(score).get(searchIndex);
				break;
			} else searchIndex -= map.get(score).size();
		}
		this.queryCount++;
		return res;
	}

	private int insertionIndexUsingBinarySearch(List<String> list, String t) {
		int left = 0, right = list.size() - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (list.get(mid).compareTo(t) < 0)  {
				left = mid + 1;
			}
			else {
				right = mid;
			}

		}
		return list.get(left).compareTo(t) >= 0 ? left : left + 1;// one corner case
	}
}