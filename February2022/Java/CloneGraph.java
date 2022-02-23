

// @saorav21994
// SC : O(n)
// TC : O(total node references in original graph)
// BFS algo to parse and clone each reference 1-by-1. Map is used to prevent duplicate creation of existing node and get reference to previous node. 

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));
      
        // BFS
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neigh : curr.neighbors) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    queue.offer(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }
        return map.get(node);       // return the head
    }
}
