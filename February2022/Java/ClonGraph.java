
class Solution {
	public Node cloneGraph(Node node) {
		if(node==null){
			return node;
		}
		Map<Node, Node> map = new HashMap<>();

		Queue<Node> qu = new LinkedList<>();
		Node newNode = new Node();
		newNode.val = node.val;
		map.put(node, newNode);
		qu.offer(node);
		while(!qu.isEmpty()){
			int size = qu.size();
			while(size-->0){
				Node orginalNode = qu.poll();
				for(Node child: orginalNode.neighbors){
					if(!map.containsKey(child)){
						Node newChild = new Node();
						newChild.val = child.val;
						// this is controlling
						qu.offer(child);
						map.put(child, newChild);
					}
					Node newListNode = map.get(orginalNode);
					newListNode.neighbors.add(map.get(child));
				}
			}
		}
		return map.get(node);

	}
}