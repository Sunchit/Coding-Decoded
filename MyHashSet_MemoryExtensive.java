class MyHashSet {

    boolean[] set = null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {

        // Redoing the same addition again, it wont have any impact on the set
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */