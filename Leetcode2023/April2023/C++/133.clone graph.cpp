/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    unordered_map<int,Node*> dict;
public:
    Node* cloneGraph(Node* node) {
        if(!node) return NULL;
        Node* curr = new Node(node->val);
        dict[curr->val]=curr;
        for(auto& i:node->neighbors)
        {
            if(dict[i->val]) 
            {
                curr->neighbors.push_back(dict[i->val]);
                continue;
            }
            curr->neighbors.push_back(cloneGraph(i));
        }

        return curr;
    }
};