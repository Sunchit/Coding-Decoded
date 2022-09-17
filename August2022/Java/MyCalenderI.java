// @saorav21994
// TC : O(nlogn)
// SC : O(n)

// GOOGLE : 03 August 2022


class MyCalendar {
    
    TreeMap<Integer, Integer> calender;
    Integer minStart = null, maxEnd = null;
    
    public MyCalendar() {
        calender = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        // first time, directly initialize
        if (minStart == null || maxEnd == null) {
            minStart = start;
            maxEnd = end;
            calender.put(start, end);
            return true;
        }
        
        if (minStart >= end) {
            calender.put(start, end);
            minStart = start;
            return true;
        }
        
        if (maxEnd <= start) {
            calender.put(start, end);
            maxEnd = end;
            return true;
        }
        
        
        Integer prev = calender.floorKey(start);
        Integer next = calender.ceilingKey(start);
        if ((prev == null || calender.get(prev) <= start) && (next == null || end <= next)) {
            calender.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
