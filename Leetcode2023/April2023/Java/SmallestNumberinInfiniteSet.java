Author: Mahesh Reddy BN

Problem Link: https://leetcode.com/problems/smallest-number-in-infinite-set/description/

class SmallestInfiniteSet {
    TreeSet<Integer> ts;
    public SmallestInfiniteSet() {
        ts = new TreeSet<>();
        for(int i=1;i<=1000;i++){
            ts.add(i);
        }
    }
    public int popSmallest() {
        return ts.pollFirst();
    }
    
    public void addBack(int num) {
        ts.add(num);
    }
}
