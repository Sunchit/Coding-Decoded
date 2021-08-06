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

//TC : O(n)

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<Node> qu = new LinkedList<>();

        qu.offer(root);

        while(!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> nodesAtOneLevel = new ArrayList<>();
            while(size-->0){
                Node head = qu.poll();
                nodesAtOneLevel.add(head.val);
                for(Node child : head.children){
                    qu.offer(child);
                }
            }
            ans.add(nodesAtOneLevel);
        }

        return ans;
    }
}