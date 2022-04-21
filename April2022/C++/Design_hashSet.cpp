//Problem Link : https://leetcode.com/problems/design-hashset/
class MyHashSet {
public:
    vector<bool> v;
    MyHashSet() {
         v.resize(1e6 + 1,false); 
    }
    
    void add(int key) {
      v[key] = true;
    }
    
    void remove(int key) {
        v[key] = false;
    }
    
    bool contains(int key) {
        return v[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
