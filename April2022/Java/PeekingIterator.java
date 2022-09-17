
// @saorav21994
// TC : O(1)
// SC : O(1)


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> itr;
    private boolean end = false;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        itr = iterator;
        traverse();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
        traverse();
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !end;
	}
    
    public void traverse() {
        if (itr.hasNext() == true) {
            next = itr.next();
        }
        else { end = true; }
    }
}
