// https://leetcode.com/problems/merge-intervals

// Time Complexity o(nlogn), Space Complexity O(n)
class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length==1){
            return intervals;
        }

        Comparator<int[]> customCompare = new Comparator<>(){

            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        };

        Arrays.sort(intervals, customCompare); // O(nlogn)

        List<int[]> ans = new ArrayList<>();

        for(int[] interval: intervals){ // O(n)
            if(ans.size() ==0){
                ans.add(interval);
            } else{
                int[] lastInterval = ans.get(ans.size() -1);
                if(lastInterval[1] >=  interval[0]){
                    int maxEnd = Math.max(lastInterval[1], interval[1]);
                    int start = lastInterval[0];

                    ans.remove(ans.size()-1);
                    ans.add(new int[]{start, maxEnd});
                } else{
                    ans.add(interval);
                }
            }
        }

        return ans.toArray(new int[ans.size()][2]);

    }
}