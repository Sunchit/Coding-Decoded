
// @saorav21994
// TC : O(n)
// SC : O(n)

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        // standard bfs
        while (!queue.isEmpty()) {
            int lsize = queue.size();           // current level size
            List<Integer> sublist = new ArrayList<>();
            while (lsize-- > 0) {
                Node cur = queue.poll();
                int csize = cur.children.size();            // current node's children size
                for (int i = 0; i < csize; i++) {
                    queue.add(cur.children.get(i));
                }
                sublist.add(cur.val);
            }
            res.add(new ArrayList<>(sublist));
        }
        
        return res;
    }
}
