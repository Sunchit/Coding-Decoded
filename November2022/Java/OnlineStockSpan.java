// @saorav21994

class StockSpanner {

    // Concept: Next greatest element using stack

    Stack<Pair> stack;
    int gidx;

    public StockSpanner() {
        stack = new Stack<Pair>();
        gidx = -1;
    }
    
    public int next(int price) {
        
        gidx += 1;
        int curIdx = -1;

        if (stack.isEmpty()) {
            stack.push(new Pair(price, gidx));
            return 1;
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.peek();
            curIdx = pair.index;
            if (price < pair.value) {
                stack.push(new Pair(price, gidx));
                return gidx-pair.index;
            }
            else {
                stack.pop();
            }
        }

        stack.push(new Pair(price, gidx));
        return gidx+1;

    }

    class Pair {
        int value;
        int index;

        public Pair(int _value, int _index) {
            this.value = _value;
            this.index = _index;
        }
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
