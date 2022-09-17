// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public Node copyRandomList(Node head) {
        Node p=head;
        HashMap<Node,Node> hm=new HashMap<>();
        
        while(p!=null){
            Node x=new Node(p.val);
            hm.put(p,x);
            p=p.next;
        }
        
        p=head;
        while(p!=null){
            Node x=hm.get(p);
            if(p.next!=null){
                x.next=hm.get(p.next);
            }
            if(p.random!=null){
                x.random=hm.get(p.random);
            }
            p=p.next;
        }
        return hm.get(head);
        
    }
}