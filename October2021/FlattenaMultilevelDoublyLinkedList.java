class Solution {
	public Node flatten(Node head) {
		if(head==null){
			return head;
		}

		Node it = head;
		while(it!=null){
			if(it.child!=null){
				Node next = it.next;
				// whatever it returns
				it.next = flatten(it.child);
				it.next.prev = it;
				it.child =null;

				// move to the last node
				while(it.next!=null){
					it=it.next;
				}

				//stich
				if(next!=null){
					it.next = next;
					it.next.prev = it;

				}

			}
			it = it.next;
		}
		return head;
	}
}