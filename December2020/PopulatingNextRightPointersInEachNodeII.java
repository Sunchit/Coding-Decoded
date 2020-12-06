/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulatingNextRightPointersInEachNodeII {

    // TC : O(n)
    public Node connect(Node root) {
        if(root == null)
            return root;

        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()) {
            int size = qu.size();
            Node nextRight = null;
            while(size-->0){
                Node head = qu.poll();
                head.next = nextRight;
                nextRight = head;
                if(head.right!=null){
                    qu.offer(head.right);
                }

                if(head.left!=null){
                    qu.offer(head.left);
                }

            }
        }
        return root;

    }
}