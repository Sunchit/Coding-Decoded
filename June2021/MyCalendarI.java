
class MyCalendar {
    // FloorEntry => Lower Entry Value
    // CeilingEntry => High Entry Value
    TreeMap<Integer, Integer> calendar = null;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        // Condition around start time
        // start < Lower Entry End Time
        if(calendar.floorEntry(start) !=null && start < calendar.floorEntry(start).getValue()){
            return false;
        }
        // Condition around end
        // end > Higher Entry Start Time
        if(calendar.ceilingEntry(start) !=null && end> calendar.ceilingEntry(start).getKey()){
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */