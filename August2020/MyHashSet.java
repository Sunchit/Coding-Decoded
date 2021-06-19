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