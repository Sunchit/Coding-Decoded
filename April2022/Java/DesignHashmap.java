
// @saorav21994
// TC : O(1)
// SC : O(n)

class MyHashMap {

    boolean [] key;
    int [] value;
    
    public MyHashMap() {
        key = new boolean[1000010];
        value = new int[1000010];
    }
    
    public void put(int _key, int _value) {
        key[_key] = true;
        value[_key] = _value;
    }
    
    public int get(int _key) {
        if (key[_key])
            return value[_key];
        return -1;
    }
    
    public void remove(int _key) {
        key[_key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
