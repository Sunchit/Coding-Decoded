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