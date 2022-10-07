// @saorav21994

/*
  Wanted to do using BIT, but the range is too big (10e9) to declare array offset.
  Can be done using segment tree -> given as part of official solution to this question by leetcode.
*/

class MyCalendarThree {

    // O(n * (n + logn)) ~ O(n^2)
         
    Map<Integer, Integer> map;
    
    public MyCalendarThree() {
        
        map = new TreeMap<>();      // keep the values sorted
        
    }
    
    public int book(int start, int end) {
        
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int cur = 0, res = 0;
        
        for (int values : map.values()) {
                        
            cur += values;
            res = Math.max(res, cur);
        }
                
        return res;
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
