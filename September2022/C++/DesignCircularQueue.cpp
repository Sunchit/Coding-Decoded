// https://leetcode.com/problems/design-circular-queue/
class MyCircularQueue {
private:
    vector<int> queue;
    int front, rear, length;
    
public:
    // SC: O(k)
    MyCircularQueue(int k) {
        vector<int> temp(k, 0);
        queue = temp;
        front = 0;
        rear = -1;
        length = 0;
    }
    
    // TC: O(1)
    bool enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        rear += 1;
        rear %= queue.size();   // alternate -> rear = (rear + 1) % queue.size();
        queue[rear] = value;
        length++;
        return true;
    }
    
    // TC: O(1)
    bool deQueue() {
        if (isEmpty()) {
            return false;
        }
        queue[front] = -1;
        front += 1;
        front %= queue.size();
        length--;
        return true;
    }
    
    // TC: O(1)
    int Front() {
        return !isEmpty() ? queue[front] : -1;
    }
    
    // TC: O(1)
    int Rear() {
        return !isEmpty() ? queue[rear] : -1;
    }
    
    // TC: O(1)
    bool isEmpty() {
        return length == 0;
    }
    
    // TC: O(1)
    bool isFull() {
        return length == queue.size();
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */
