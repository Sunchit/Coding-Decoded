class Solution {
	public int[] groupStrings(String[] words) {
		int n = words.length;
		// Mask, Index in words array
		Map<Integer, Integer> maskToIndex = new HashMap<>();

		int[] masks = new int[n];

		for (int i = 0; i < n; i++) {
			masks[i] = getMask(words[i]);
			maskToIndex.put(masks[i], i);
		}

		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			// This is necessary to union the duplicate words
			// "abc", "cab"
			unionFind.union(i, maskToIndex.get(masks[i]));
			for (char ch : words[i].toCharArray()) {
				// Removing ch from the word
				int maskWithoutCh = masks[i] ^ (1 << ch - 'a');
				if (maskToIndex.containsKey(maskWithoutCh)) {
					unionFind.union(i, maskToIndex.get(maskWithoutCh));
				}

				// Replace ch with any other charactor
				for (int j = 0; j < 26; j++) {
					// Skip if the word already contains the char at j
					if (j == ch - 'a') {
						continue;
					}
					int maskWithReplace = maskWithoutCh | (1 << j);
					if (maskToIndex.containsKey(maskWithReplace)) {
						unionFind.union(i, maskToIndex.get(maskWithReplace));
					}
				}
			}
		}
		return new int[] {unionFind.groupCount, unionFind.maxSize };
	}

	private int getMask(String word){
		int mask = 0;
		for (char ch : word.toCharArray()) {
			mask |= (1 << ch - 'a');
		}
		return mask;
	}

	private class UnionFind {
		private int[] parent;
		private int[] size;
		private int groupCount;
		private int maxSize;

		UnionFind(int n) {
			groupCount = n;
			maxSize = 1;
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public int find(int a) {
			if (parent[a] != a) {
				parent[a] = find(parent[a]);
			}
			return parent[a];
		}

		public void union(int a, int b) {
			if (a == b) {
				return;
			}
			int pa = find(a);
			int pb = find(b);
			if (pa != pb) {
				if (size[pb] < size[pa]) {
					parent[pa] = pb;
					size[pb] += size[pa];
					maxSize = Math.max(maxSize, size[pb]);
				} else {
					parent[pb] = pa;
					size[pa] += size[pb];
					maxSize = Math.max(maxSize, size[pa]);
				}
				groupCount--;
			}
		}

	}
}