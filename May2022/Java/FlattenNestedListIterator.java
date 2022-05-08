
// @saorav21994


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

    // Global class type stack as we need to make it generic and treat list as objects
    
    Stack<NestedInteger> st = new Stack<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        
        // initialize from end to start as stack is LIFO DS
        
        for (int i = nestedList.size()-1; i >=0; i--) {
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (st.isEmpty() == false) {
            if (st.peek().isInteger() == true) {
                return true;
            }
            NestedInteger tmpList = st.pop();
            for (int i = tmpList.getList().size()-1; i >= 0; i--) {
                st.push(tmpList.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
