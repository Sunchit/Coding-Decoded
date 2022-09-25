
// @saorav21994

class MyCircularQueue {
    
    // Queue -> add in rear and delete in front -> FIFO
    
    LinkedList<Integer> queue;
    int size;
    int cur = 0;
    public MyCircularQueue(int k) {
        size = k;
        queue = new LinkedList<>();
    }
    
    public boolean enQueue(int value) {
        if (cur == size) 
            return false;   // queue full
        cur += 1;
        queue.addLast(value);
        return true;
    }
    
    public boolean deQueue() {
        if (cur == 0)
            return false;   //queue empty
        cur -= 1;
        queue.removeFirst();
        return true;
    }
    
    public int Front() {
        if (cur == 0)
            return -1;
        return queue.getFirst();
    }
    
    public int Rear() {
        if (cur == 0)
            return -1;
        return queue.getLast();    
    }
    
    public boolean isEmpty() {
        return (cur == 0);
    }
    
    public boolean isFull() {
        return (cur == size);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
