// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html


// TC : O(n)
class PeekingIterator implements Iterator<Integer> {
    // Peek element
    Integer nextEl = null;
    Iterator<Integer> it = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        nextEl = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextEl;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer valueToReturn = nextEl;
        if(it.hasNext()){
            this.nextEl = it.next();
        } else{
            this.nextEl = null;
        }
        return valueToReturn;
    }

    @Override
    public boolean hasNext() {
        return nextEl!=null;
    }
}