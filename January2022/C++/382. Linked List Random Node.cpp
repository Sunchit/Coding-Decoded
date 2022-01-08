
Brute force:
Time complexity : O(N)
Space complexity : O(N)
  
class Solution {
public:
    vector<int>res;
    Solution(ListNode* head) {
        while(head){
            res.push_back(head->val);
            head = head -> next;
        }
    }
    
    int getRandom() {
        return res[rand()%res.size()];
    }
};



Optimal solution :

Time complexity : O(N)
Space complexity : O(1)
  
class Solution {
public:
    ListNode* root;
    Solution(ListNode* head) {
        root= head;
    }   
    int getRandom() {
        int index = 1;
        int ans = 0;
        ListNode* curr = root;
        while(curr){
            if(rand() % index == 0){
                ans = curr->val;
            }
            index++;
            curr = curr->next;
        }
        return ans;
    }
};
