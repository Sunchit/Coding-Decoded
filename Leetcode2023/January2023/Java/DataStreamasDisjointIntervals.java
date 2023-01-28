class SummaryRanges {
    private Set<Integer> numbers;

    public SummaryRanges() {
        numbers = new TreeSet<>();
    }
    
    // O(logn)
    public void addNum(int value) {
        numbers.add(value);
    }
    
    // O(n)
    public int[][] getIntervals() {
        // We are not sure of the size upfront
        List<int[]> disjointInterval = new ArrayList<>();
        
        for (int n : numbers) {
            int size = disjointInterval.size();
            
            if (size > 0 && disjointInterval.get(size - 1)[1] + 1 == n) {
                disjointInterval.get(size - 1)[1] = n;
                // [Merge] Update the right end state
            }
            else {
                // [New entry] Create a new interval
                disjointInterval.add(new int[]{ n, n });
            }
            
        }
        
        return disjointInterval.toArray(new int[0][]); 
    }
}
