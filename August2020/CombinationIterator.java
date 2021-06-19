class CombinationIterator {

    PriorityQueue<String> pq = new PriorityQueue<String>();

    public CombinationIterator(String characters, int combinationLength) {
        generateCombinations(characters, combinationLength, 0, new StringBuilder());
    }

    private void generateCombinations(String input, int len, int start, StringBuilder currStr){
        if(len==0){
            pq.add(currStr.toString());
            return ;
        }

        for(int i=start;i<=input.length()-len;i++){
            currStr.append(input.charAt(i));
            generateCombinations(input, len-1,i+1, currStr);
            currStr.setLength(currStr.length()-1);
        }
    }

    public String next() {
        if(hasNext()){
            return pq.poll();
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return (pq.size()>0);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */