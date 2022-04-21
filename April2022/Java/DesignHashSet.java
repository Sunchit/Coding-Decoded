class MyHashSet {

    boolean[] set = null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}

class MyHashSet {

    // Hashset => 4(1), 10(2), 16(1) , 17(3)

    /*
       Hash
        1 -> 4 -> 16 ->.... Time complexity => o(n)
        2 -> 10 -> ...
        3 -> 17 -> ...
    */
    /** Initialize your data structure here. */

    private int capacity = 0;

    private List<Integer>[] set = null;
    public MyHashSet() {
        capacity = 1500;
        set = new List[capacity];
    }

    private int getKeyHash(int key){
        return key % capacity;
    }

    public void add(int key) {
        int hashIndex = getKeyHash(key);
        if(set[hashIndex] == null){
            set[hashIndex] = new LinkedList<>();
        }

        if(set[hashIndex].indexOf(key) == -1){
            set[hashIndex].add(key);
        }
    }

    public void remove(int key) {
        if(contains(key)) {
            int hashIndex = getKeyHash(key);
            // removing the key from the set
            set[hashIndex].remove(set[hashIndex].indexOf(key));
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashIndex = getKeyHash(key);
        if(set[hashIndex] == null  || set[hashIndex].indexOf(key) == -1){
            return  false;
        } else {
            return true;
        }

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class MyHashSet {

    // Hashset => 4(1), 10(2), 16(1) , 17(3)

    /*
       Hash
        1 -> 4 -> 16 ->.... Time complexity => o(n)
        2 -> 10 -> ...
        3 -> 17 -> ...
    */
    /** Initialize your data structure here. */

    private int capacity = 0;

    private List<Integer>[] set = null;
    public MyHashSet() {
        capacity = 1500;
        set = new List[capacity];
    }

    private int getKeyHash(int key){
        return key % capacity;
    }

    public void add(int key) {
        int hashIndex = getKeyHash(key);
        if(set[hashIndex] == null){
            set[hashIndex] = new LinkedList<>();
        }

        if(set[hashIndex].indexOf(key) == -1){
            set[hashIndex].add(key);
        }
    }

    public void remove(int key) {
        if(contains(key)) {
            int hashIndex = getKeyHash(key);
            // removing the key from the set
            set[hashIndex].remove(set[hashIndex].indexOf(key));
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashIndex = getKeyHash(key);
        if(set[hashIndex] == null  || set[hashIndex].indexOf(key) == -1){
            return  false;
        } else {
            return true;
        }

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

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
