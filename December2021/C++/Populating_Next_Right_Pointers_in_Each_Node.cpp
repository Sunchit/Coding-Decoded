/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(!root) return root;
        queue<Node*> q;
        q.push(root);
        while(q.size())
        {
            int size=q.size();
            while(size>0)
            {
                Node* top=q.front();
                q.pop();
                if(top->left && top->right)
                {
                    q.push(top->left);
                    q.push(top->right);
                }
                if(--size==0) break;
                top->next=q.front();
            }
        }
        return root;
    }
};