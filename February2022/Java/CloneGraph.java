

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

// Author : @romitdutta10
// SC : O(n)
// TC : O(total node references in original graph)
// DFS easy to understand
// Problem : https://leetcode.com/problems/clone-graph/

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
    Map<Node, Node> nodePool = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        if(nodePool.containsKey(node)) {
            return nodePool.get(node);
        }
        
        Node copy = new Node(node.val);
        nodePool.put(node, copy);
        
        List<Node> neighbours = new ArrayList<>();
        
        for(Node neighbour : node.neighbors) {
            Node copiedNeighbour = cloneGraph(neighbour);
            neighbours.add(copiedNeighbour);
        }
        
        copy.neighbors = neighbours;
        
        
        return copy;
        
        
    }
}

// Author : @romitdutta10
// SC : O(n)
// TC : O(total node references in original graph)
// DFS optimized
// Problem : https://leetcode.com/problems/clone-graph/

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
    HashMap<Integer, Node> nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Node new_node;
        if(nodeMap.get(node.val)!=null)
            new_node = nodeMap.get(node.val);
        else {
            //System.out.println("Adding new node "+node.val);
            new_node = new Node(node.val);
            nodeMap.put(node.val, new_node);
        }

        List<Node> neighbors = new_node.neighbors;
        for(Node n : node.neighbors){
            //System.out.println("Traversing over neighbors "+n.val);
            if(!neighbors.contains(n)){
                if(nodeMap.get(n.val)!=null)
                    neighbors.add(nodeMap.get(n.val));
                else
                    neighbors.add(cloneGraph(n));
            }
        }
        

        return new_node;
    }
}
