/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> fList =null;
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        fList = new ArrayList<>();
        flattening(nestedList);
        it = fList.iterator();

    }

    private void flattening(List<NestedInteger> nestedList){
        for(NestedInteger currEl : nestedList){
            if(currEl.isInteger()){
                fList.add(currEl.getInteger());
            } else {
                flattening(currEl.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(it.hasNext()){
            return it.next();
        } else{
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */