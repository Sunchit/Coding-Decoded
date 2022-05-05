
// @saorav21994
// TC : O(n) -> push; O(1) -> all other
// SC : O(n) -> only 1 linkedlist as queue

class MyStack {
    
    LinkedList<Integer> queue;
    int itr;
    
    public MyStack() {
        queue = new LinkedList<>();
        itr = 0;
    }
    
    // O(n)
    public void push(int x) {
        queue.add(x);
        itr += 1;
        int cnt = itr;
        while (cnt > 1) {
            queue.add(queue.remove());      // take all elements from head to n-1 and append it at end 
            cnt -= 1;
        }
    }
    
    // O(1)
    public int pop() {
        int val = top();       
        queue.remove();             // head of list
        itr -= 1;
        return val;
    }
    
    // O(1)
    public int top() {
        return queue.peek();
    }
    
    // O(1)
    public boolean empty() {
        return itr == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
