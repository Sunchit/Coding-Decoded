class FreqStack {

    // SC : O(n)
    // TC : O(1)
    List<Stack<Integer>> stList = null;
    Map<Integer, Integer> map = null;

    public FreqStack() {
        map = new HashMap<>();
        stList = new ArrayList<>();

    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0)+1);
        int freq = map.get(x);
        if(freq -1 >= stList.size()){
            stList.add(new Stack<Integer>());
        }
        stList.get(freq-1).add(x);

    }

    public int pop() {
        int size = stList.size();
        int x = stList.get(size-1).pop();
        if(stList.get(size-1).empty()){
            stList.remove(size-1);
        }

        map.put(x, map.get(x)-1);
        if(map.get(x) == 0){
            map.remove(x);
        }

        return x;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */