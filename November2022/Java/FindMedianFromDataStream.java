// @saorav21994

class MedianFinder {
    
    // Principle : The max element in maxheap should be < than min element in min heap
    // and both the heaps need to be balanced such that |maxheap_size-minheap_size| <= 1

    private PriorityQueue<Integer> minHeap = null;
    private PriorityQueue<Integer> maxHeap = null;    
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();    // Default
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // ((a,b)->(b-a))
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }
        // Balance the heaps
        if ((maxHeap.size() - minHeap.size()) > 1) {
            int extra = maxHeap.poll();
            minHeap.offer(extra);
        }
        else if ((minHeap.size() - maxHeap.size()) > 1) {
            int extra = minHeap.poll();
            maxHeap.offer(extra);
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else {  // both are equal = even = (a+b)/2
            return ((maxHeap.peek() + minHeap.peek())/2.0);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
