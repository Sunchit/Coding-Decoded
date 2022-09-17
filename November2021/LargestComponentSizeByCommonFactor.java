class Solution {
	private class UnionFind {
		private int[] parent;

		private UnionFind(int n){
			parent = new int[n];
			for(int i=0;i<n;i++){
				parent[i] = i;
			}
		}
		private int getAbsoluteParent(int i){
			if(parent[i]==i){
				// absolute parent
				return i;
			}
			parent[i]=getAbsoluteParent(parent[i]);
			return parent[i];
		}

		private void unify(int i, int j){
			int absoluteParentI = getAbsoluteParent(i);
			int absoluteParentJ = getAbsoluteParent(j);
			if(absoluteParentI!=absoluteParentJ){
				// 7->2, 21->2 (7,21)
				parent[absoluteParentJ] = absoluteParentI;
			}
		}

	}

	public int largestComponentSize(int[] nums) {
		int max=0;
		for(int el:nums) {
			max = Math.max(el, max);
		}
		UnionFind uf = new UnionFind(max+1);

		for(int i:nums) {
			for(int j=2;j*j<=i;j++) {
				if(i%j==0){ // j is a factor of i
					uf.unify( j,i); // i=21, j=3
					uf.unify(i/j,i); // (21,3), (21,21/3(7))
				}
			}
		}
		//<Parent, Freq>
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxComponet = 0;
		for(int el:nums){
			int parent = uf.getAbsoluteParent(el);
			map.put(parent, map.getOrDefault(parent, 0) + 1);
			maxComponet= Math.max(maxComponet, map.get(parent));
		}



		return maxComponet;
	}
}