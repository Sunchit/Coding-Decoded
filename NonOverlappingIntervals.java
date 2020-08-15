class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Comparator<int[]> sortCompare = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b ){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                } else{
                    return a[0] - b[0];
                }
            }
        };

        Arrays.sort(intervals, sortCompare);

        Stack<Pair<Integer, Integer>> st = new Stack<Pair<Integer, Integer>>();

        for(int[] interval: intervals){
            if(!st.empty()) {
                Pair<Integer, Integer> top = st.peek();
                if(top.getValue() > interval[0]){ // Overlapping case
                    if(top.getValue() > interval[1]){

                        // ----------------------
                        //.   --------------
                        st.pop();
                        st.push(new Pair<>(interval[0], interval[1]));
                    }
                } else{
                    st.push(new Pair<>(interval[0], interval[1]));
                }


            } else {
                st.push(new Pair<>(interval[0], interval[1]));
            }
        }
        return intervals.length -st.size();

    }
}