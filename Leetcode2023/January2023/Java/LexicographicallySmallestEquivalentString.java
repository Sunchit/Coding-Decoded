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
			if(absoluteParentI<absoluteParentJ){

				parent[absoluteParentJ] = absoluteParentI ;
			}
			else{

				parent[absoluteParentI] = absoluteParentJ ;
			}
		}

	}


	public String smallestEquivalentString(String s1, String s2, String baseStr) {


		UnionFind uf = new UnionFind(26);

		StringBuilder sb  = new StringBuilder();

		for(int i=0 ; i<s1.length() ; i++){

			int charS1 = s1.charAt(i)-'a';
			int charS2 = s2.charAt(i)-'a';

			uf.unify(charS1, charS2 );
		}

		for(int i=0 ; i<baseStr.length() ; i++){

			int smallestMappedChar  = uf.getAbsoluteParent(baseStr.charAt(i)-'a');

			sb.append((char)(smallestMappedChar+'a'));
		}

		return sb.toString();
	}
}