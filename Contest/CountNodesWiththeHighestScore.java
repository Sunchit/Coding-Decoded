class Solution {

	class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private long score = 0L;
		private int nodeCount = 0;

	}

	private int countNodes (TreeNode root) {
		if (root == null) {
			return 0;
		}
		root.nodeCount = countNodes(root.left) + countNodes(root.right) + 1;

		return root.nodeCount;
	}


	public int countHighestScoreNodes(int[] parents) {
		long max = 0l;

		int n = parents.length;
		int ans = 0;
		TreeNode[] tree = new TreeNode[n];

		for (int i = 0; i < parents.length; i++) {
			tree[i] = new TreeNode();
		}

		for (int i = 1; i < parents.length; i++) {
			int parentId = parents[i];
			if (tree[parentId].left == null) {
				tree[parentId].left = tree[i];
			} else {
				tree[parentId].right = tree[i];
			}
		}

		countNodes(tree[0]);


		for (int i = 0; i < parents.length; i++) {
			long product = 1;
			int leftCnt = tree[i].left == null ? 0 : tree[i].left.nodeCount;
			int rightCnt = tree[i].right == null ? 0 : tree[i].right.nodeCount;
			int parentCnt = n - 1 - leftCnt - rightCnt;

			if (leftCnt > 0) {
				product *= leftCnt;
			}
			if (rightCnt > 0) {
				product *= rightCnt;
			}
			if (parentCnt > 0) {
				product *= parentCnt;
			}
			tree[i].score = product;
			max = Math.max(max, product);
		}

		//count nodes
		for (int i = 0; i < parents.length; i++) {
			if (tree[i].score == max) {
				ans++;
			}
		}
		return ans;
	}


}


=============== Another approach without creating the nodes ==================
// https://leetcode.com/problems/count-nodes-with-the-highest-score/
// @author: anuj0503
class Solution {
    Map<Long, Integer> freq;
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        Map<Integer, Set<Integer>> tree = new HashMap<>();

        for(int i = 0; i < n; i++) tree.put(i, new HashSet<>());

        for(int i = 1; i < n; i++){
            Set<Integer> set = tree.get(parents[i]);
            set.add(i);
            tree.put(parents[i], set);
        }

        freq = new HashMap<>();
        dfs(0, n, tree);

        long maxFreq = -1;
        for(long f : freq.keySet()){
            maxFreq = Math.max(maxFreq, f);
        }

        return freq.get(maxFreq);
    }

    private int dfs(int node, int n, Map<Integer, Set<Integer>> tree){
        Set<Integer> s = tree.get(node);

        if(s.isEmpty()) {
            freq.put((long)n - 1, freq.getOrDefault((long)n - 1, 0) + 1);
            return 1;
        }

        long ans = 1;
        int count = 0;
        for(int neighbour : s){
            int c = dfs(neighbour, n, tree);
            count += c;
            ans *= c;
        }


        if(count + 1 != n){
            ans *= (n - count - 1);
        }

        freq.put(ans, freq.getOrDefault(ans, 0) + 1);

        return count + 1;
    }
}
