// https://leetcode.com/problems/time-based-key-value-store/
class TimeMap {
public:
    unordered_map<string, map<int, string>> map;
    
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        map[key].insert({ timestamp, value });
    }
    
    string get(string key, int timestamp) {
        auto it = map[key].upper_bound(timestamp);
        return it == map[key].begin() ? "" : prev(it)->second;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */
