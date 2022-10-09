// https://leetcode.com/problems/time-based-key-value-store/
// TC O(nLog n)
// SC O(n)

class TimeMap {
    
private:
    map<int,vector<pair<string,string>>>timeS; // to store timestap, key, value
    
     map<string,vector<int>>keyT; // to store timestaps corresponding to key
    
public:
    TimeMap() {
        // constructor
    }
    
    void set(string key, string value, int timestamp) {
        
        timeS[timestamp].push_back({key,value}); //  [timestamp] -> { {key1,val1}, {key2,val2} }
        
        keyT[key].push_back(timestamp); //  [key] -> { timestamp1, timestamp2, ... }
    }
    
    string get(string key, int timestamp) {
        
        auto it =  upper_bound(keyT[key].begin(), keyT[key].end(),timestamp); // finding time <= timestamp
        
        if(it==keyT[key].begin()){
            // edge case
            return "";
        }
        
        it--;
        int min_prev_time = (*it);
        
        for(auto num:timeS[min_prev_time]){
            // finding the value associated with the key
            if(num.first==key){
                return num.second;
            }
        }
        return "";
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */