Brief note about Question-

We have to Merge all the linked-lists into one sorted linked-list and return it.

Take an example -
Given: k number of sorted linked list in ascending order.
Aim: Merge them into a single sorted linked list.

Take anthor example which is not given in question-
L1: 1 -> 5 -> 7 -> 9 -> N
L2: 2 -> 4 -> 8 -> N
L3: 3 -> 6 -> N

So our answer should like this:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> N
Solution - I (Most basic approach, Accepted)-

Okay, so the most basic approach we can think of is, we are obedient person, and not to do anything extra from ourself,
We will simply do what the question wants us to do, we create an array which store all the elements of all 'k' linked list present in the array.
After storing all elements, we sort them a/c to their vaules.
Now, the only task which is left is to link them, so we start linking them.
Okay, I got the approach, but how i will implement this or code these words-

We take help of a vector pair which of value and Node type.
But why vector pair?
See, Here we have k different linked list na and each linked list contain some elements so to observe that we need a vector pair.
Okay good, I take a vector pair,so now what i have to do?
Now we start storing each value in this vector pair.
After this, by using sort function (present in STL) we sort this vectorAnd at last, i start linking them, it can be done simply by putting next pointer i.e arr[i].second -> next = arr[i + 1].second.
Suppose if total number of nodes present in all linked list is 'n' 
Time Complexity --> O(n log n) // as sorting takes (n log n) time
Space Complexity --> O(n) // to store nodes of the all linked list
It paases [ 133 / 133] in built test cases
Code (C++)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k = lists.size(); // taking size of the list
        if(k == 0) // if size is zero
            return NULL; // simply return NULL
        
        // making a vector pair where first contain value and second contain node
        vector<pair<int, ListNode*>> arr; 
        
        for(int i = 0; i < k; i++) // traverse all over the list
        {
            ListNode* curr_list = lists[i]; // extracting current linked list
            
            while(curr_list != NULL) // while current linked list is NOT NULL
            {
                arr.push_back({curr_list -> val, curr_list}); // push into vector
                curr_list = curr_list -> next;
            }
        }
        
        // this does not gurantee that k is zero, 
        // suppose an array like this [[],[],[],],here k = 3 and size of array is 0
        if(arr.size() == 0) // if their is no element i.e zero element
            return NULL;
        
        sort(arr.begin(), arr.end()); // sort the vector on the basis of values
        
        // start making links b/w the elements of vector
        for(int i = 0; i < arr.size() - 1; i++)
        {
            arr[i].second -> next = arr[i + 1].second;
        }
        
        // in the next of last node put NULL
        arr[arr.size() - 1].second -> next = NULL;
        
        return arr[0].second; // return first node of the vector
    }
};
Solution - II (Further optimization in time as well as in space, Using priority queue, Accepted)-

Now, we want to become a good programmer and anyhow we want to optimize our soloution.
The main point is to observe here is that every linked list is already sorted and our task is just to merge them.
Our approach to merge linked list is same as about merge function of merge sort.
In merge sort, we have just two arrays / linked list but here we have 'k' linked list.
So by using min heap we compare k node values and add the smallest one to the final list.
One property of min heap we have to remember here is that, it keeps smallest element always on the top, so using that property we merge our k sorted linked list.
Suppose if total number of nodes present in all linked list is 'n' 
Time Complexity --> O(n log k) // as we are using min heap
Space Complexity --> O(k) // at a single point of time min heap always handle the k elements
It paases [ 133 / 133] in built test cases
Code (C++)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */


class Solution {
public:
    // we define pair as pi
    #define pi pair<int, ListNode* >
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k = lists.size(); // taking the size of the linked list
        
        if(k == 0) // if no linked list is present
            return NULL; // simply return null
        
        priority_queue<pi, vector<pi>, greater<pi>> minh; // making priority queue
        
        for(int i = 0; i < k; i++) // traverse from the whole array 
        {
            ListNode* curr_list = lists[i]; // extracting current linked list
            
            if(curr_list != NULL) // if element present in the linked list
            {
                minh.push({curr_list -> val, curr_list}); // push into min heap
            }
        }
        
        // this does not gurantee that k is zero, 
        // suppose an array like this [[],[],[],],here k = 3 and size of array is 0
        if(minh.size() == 0) // if their is no element i.e zero element
            return NULL;
        
        ListNode* head = new ListNode(); // can also be called as dummy
        ListNode* curr = head; // make a pointer pointing to head
        
        while(minh.empty() == false) // adding further most elements to min heap
        {
            pair<int, ListNode*> temp = minh.top(); // extracting top pair
            minh.pop(); // pop that pair
            
            if(temp.second -> next != NULL) // if elements still remaining in the linked list then push them
            {
                minh.push({temp.second -> next -> val, temp.second -> next});
            }
            
            curr -> next = temp.second;
            curr = curr -> next;
        }
        
        curr -> next = NULL; 
        head = head -> next; // move head, which is actually containg the list
        
        return head; // return head
    }
};
Solution - III (Further optimization in space, Accepted)-

Okay, the question arises, if we just have to merge k linked list,
Is the use of priority queue is necesssary? Can't we do it without using the priority queue?
The answer is YES, we can do further optimization in space complexity as well.
We use two pointers for doing this.
First we put start pointer to zero index and last pointer to last index and after that we start merging them thinking of as two sorted linked list.
And again we will continue this task until we get a single linked list.
See commented code, you will get it easily.
Suppose if total number of nodes present in all linked list is 'n' 
Time Complexity --> O(n log k)
Space Complexity --> O(1) 
It paases [ 133 / 133] in built test cases
Code (C++)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // this do the same work as merge function of merging two values
    ListNode* merge(ListNode* first, ListNode* second)
    {
        ListNode* result = NULL;
        
        if(first == nullptr)
            return second;
        
        if(second == nullptr)
            return first;
        
        
        if(first -> val <= second -> val)
        {
            result = first;
            result -> next = merge(first -> next, second);
        }
        else
        {
            result = second;
            result -> next = merge(first, second -> next);
        }
        return result;
    }
    ListNode* mergeKLists(vector<ListNode*>& arr) {
        int k = arr.size(); // extracting size of array
        if(k == 0) // if size of array is value
            return NULL;
        
        int start = 0; // start pointer
        int last = k -1; // last pointer
        int temp;
        while(last != 0) // if last pointer not becomes zero
        {
            start = 0;
            temp = last;
            while(start < temp)
            {
                // merge them and store in one of the linked list
                arr[start] = merge(arr[start],arr[temp]);
                start++; // increment start
                temp--; // decrese start
                
                if(start >= temp) // if at any point start passes the temp
                {
                    last = temp;
                }
            }
        }
        return arr[0]; // return first linked list of the aray as now it contains the all nodes in the sorted order.
        
    }
};