
// @saorav21994
// TC : O(n) [ 2 traversals ]
// SC : O(n) [ HashMap for storing the nodes ]

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node orgTmp = head;
        
        // create new node list as per the original node list
        while (orgTmp != null) {
            tmp.next = new Node(orgTmp.val);
            tmp = tmp.next;
            map.put(orgTmp, tmp);
            orgTmp = orgTmp.next;            
        }
        
        // align random pointers as per org node list
        orgTmp = head;
        tmp = newHead.next;
        while (orgTmp != null && tmp != null) {
            Node curRand = orgTmp.random;
            if (curRand != null) {
                // System.out.println(orgTmp.random.val + " - " + map.get(orgTmp.random).val);
                tmp.random = map.get(orgTmp.random);
            }
            orgTmp = orgTmp.next;
            tmp = tmp.next;
        }
        
        return newHead.next;
    }
}
