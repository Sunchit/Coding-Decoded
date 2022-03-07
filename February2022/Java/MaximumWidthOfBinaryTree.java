class Solution {
	public int widthOfBinaryTree(TreeNode root) {
		if(root==null || (root.left==null &&root.right==null)){
			return 1;
		}

		int maxWidth = 0;
		// <Nodee, Weight>
		Map<TreeNode, Integer> map = new HashMap<>();
		map.put(root, 0);
		Queue<TreeNode> qu = new LinkedList<>();
		qu.offer(root);
		while(!qu.isEmpty()){
			int size = qu.size();
			int left = map.get(qu.peek());
			while(size-->0){
				TreeNode head = qu.poll();
				maxWidth = Math.max(maxWidth , map.get(head) - left+1);
				if(head.left!=null){
					qu.offer(head.left);
					map.put(head.left, 2*map.get(head) );
				}

				if(head.right!=null){

					qu.offer(head.right);
					map.put(head.right, 2*map.get(head)+1 );
				}
			}
		}
		return maxWidth;
	}
}