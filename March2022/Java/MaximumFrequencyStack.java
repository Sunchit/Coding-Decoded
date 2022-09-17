
// @saorav21994
// TC : O(1)  -> total number of push and pop operations with asymptotic time complexity of O(1)
// SC : O(max (total push operation at one go))

// Partial concept taken from leetcode official solution. Nicely explained there.


class FreqStack {

    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> stackMap;
    int maxFreq = 0;
    
    public FreqStack() {
        map = new HashMap<>();
        stackMap = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int count = map.get(val);
        maxFreq = Math.max(maxFreq, count);
        stackMap.putIfAbsent(count, new Stack<>());
        stackMap.get(count).push(val);
    }
    
    public int pop() {
        int element = stackMap.get(maxFreq).pop();
        map.put(element, map.get(element) - 1);
        if (stackMap.get(maxFreq).size() == 0)
            maxFreq -= 1;
        return element;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */


// Author: @romitdutta10
// TC: O(1)
// SC: O(N)
// Problem: https://leetcode.com/problems/maximum-frequency-stack/

class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int currFreq = freq.get(val);
        if(!group.containsKey(currFreq)) {
            group.put(currFreq, new Stack<>());
        }
        
        group.get(currFreq).push(val);
        maxFreq = Math.max(currFreq, maxFreq);
    }
    
    public int pop() {
        int ele = group.get(maxFreq).pop();
        if(group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        freq.put(ele, freq.get(ele) - 1);
        return ele;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
