
// @saorav21994

/*
    TC : O(Time to find hash of string key)*#calls for set
         O(Time to find hash of string key)*#calls*log(#items in same bucket) for get
         
    SC : O(#calls*hashLength of key) for set
         O(1) for get
*/

class TimeMap {

    Map<String, TreeMap<Integer, String>> map;      // (key, (timestamp, value))
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, x -> new TreeMap<>()).put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {

        Map.Entry<Integer, String> result = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
        if (result == null)
            return "";
        return result.getValue();
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
