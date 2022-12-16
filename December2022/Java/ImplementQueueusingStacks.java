// Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/description/
// Author: Mahesh Reddy B N

class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;
    public MyQueue() {
        this.in = new LinkedList<Integer>();
        this.out = new LinkedList<Integer>();
    }
    public void push(int x) {
        in.offerFirst(x);
    }
    public int pop() {
        move();
        return out.pollFirst();
    }
    public int peek() {
        move();
        return out.peekFirst();
    }
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }
    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }
}
