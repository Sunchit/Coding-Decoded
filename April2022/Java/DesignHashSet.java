

// @saorav21994
// TC : O(1)
// SC : O(n)

// This can also be done in O(log10n) - Space + Time using Trie. At max 7 loop in each add/remove call.
// This can also be done using buckets + linkedList approach. 


class MyHashSet {

    boolean [] hash;
    
    public MyHashSet() {
        hash = new boolean[1000010];
    }
    
    public void add(int key) {
        hash[key] = true;
    }
    
    public void remove(int key) {
        hash[key] = false;
    }
    
    public boolean contains(int key) {
        return hash[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// Author: Shobhit Behl (LC: shobhitbruh)
class MyHashSet {
    HashSet<Integer> hs;
    public MyHashSet() {
        hs=new HashSet<>();
    }
    
    public void add(int key) {
        hs.add(key);
    }
    
    public void remove(int key) {
        hs.remove(key);
    }
    
    public boolean contains(int key) {
        return hs.contains(key);
    }
}
