class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node *iter=head,*next=NULL,*copyNode=NULL;
        
        while(iter)
        {
            next=iter->next;
            copyNode=new Node(iter->val);
            iter->next=copyNode;
            copyNode->next=next;
            iter=next;
        }
        
        iter=head;
        while(iter)
        {
            if(iter->random)
                iter->next->random=iter->random->next;
            iter=iter->next->next;
        }
        
        
        Node* res=new Node(-1);
        Node *copy=res,*copyIter=res;
        
        iter=head;
        while(iter)
        {
            next=iter->next->next;
            
            copyIter=iter->next;
            copy->next=copyIter;
            copy=copy->next;
            
            iter->next=next;
            iter=next;
        }
        
        return res->next;
    }
};