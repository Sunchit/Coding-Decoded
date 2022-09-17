class CountIntervals {

	//              < left, right >
	private TreeMap<Integer, Integer> treeMap;
	private int count;

	public CountIntervals() {
		treeMap = new TreeMap<>();
		count = 0;
	}

	public void add(int left, int right) {

		int l = left;
		int r = right;

		while(!(treeMap.floorKey(r) == null || treeMap.get(treeMap.floorKey(r)) < l)){

			int smallerLeft = treeMap.floorKey(r);
			int smallerRight = treeMap.get(smallerLeft);

			// reduce the count
			count -= (smallerRight - smallerLeft + 1);
			treeMap.remove(smallerLeft);

			// merge
			l = Math.min(l, smallerLeft);
			r = Math.max(r, smallerRight);
		}

		treeMap.put(l, r);
		count += (r - l + 1);

	}

	public int count() {
		return count;
	}
}