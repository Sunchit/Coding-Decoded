// @saorav21994


// Amortized O(1) operation.

// Always push to first stack - O(1)
// When pop, check in 2nd stack -> if empty then pop all elements from first stack to 2nd stack [O(n)], then keep on popping from 2nd stack until empty [O(1)], hence repeat. -> Amortized O(1)

class MyQueue {

    Stack<Integer> push;
    Stack<Integer> pop;

    public MyQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }
    
    public void push(int x) {
        push.push(x);
    }
    
    public int pop() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }
    
    public int peek() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.peek();
    }
    
    public boolean empty() {
        if (pop.isEmpty()) {
            if (push.isEmpty())
                return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
