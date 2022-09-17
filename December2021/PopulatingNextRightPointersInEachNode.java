
class Solution {
    public Node connect(Node root) {

        if(root==null) {
            return null;
        }

        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);



        while(!qu.isEmpty()) {
            int size = qu.size();
            Node prev = null;
            while(size-->0){
                Node head = qu.poll();
                // System.out.println(head.val +  " "+ size);
                head.next = prev;
                prev = head;
                if(head.right != null){
                    qu.offer(head.right);
                }
                if(head.left != null){
                    qu.offer(head.left);
                }

            }
        }
        //System.out.println("Hree");
        return root;
    }
}