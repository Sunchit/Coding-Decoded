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

    // TC : O(n)
    // SC : O(n)
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        // duplicate nodes
        Node it = head;
        while(it!=null){
            Node nextIt = it.next;
            Node newNode = new Node(it.val);
            newNode.next = it.next;
            it.next = newNode;
            it = nextIt;
        }

        // set random pointer

        Node newIt = head.next;
        Node newHead = head.next;
        it = head;

        while(it!=null){
            if(it.random!=null) {
                newIt.random = it.random.next;

            }
            it = newIt.next;
            if(it!=null)
                newIt = it.next;
        }

        // Reseting the next nodes so as to separte old and  duplicate lists

        it = head;
        newIt = head.next;

        while(it!=null){
            it.next = newIt.next;
            it = it.next;
            if(it!=null){
                newIt.next = it.next;
                newIt = it.next;
            }
        }

        return newHead;

    }
}