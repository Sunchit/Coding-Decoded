class Solution {
public:
    Node* connect(Node* root) {
        if(!root) return root;
        queue<Node*> q;
        q.push(root);
        Node* temp=NULL;
        int size;
        while(q.size())
        {
            size=q.size();
            for(int i=0;i<size;i++)
            {
                temp=q.front();
                q.pop();

                if(temp->left) q.push(temp->left);
                if(temp->right) q.push(temp->right);
                if(i+1==size) continue;
                else temp->next =q.front();
            }
        }
        return root;
    }
};