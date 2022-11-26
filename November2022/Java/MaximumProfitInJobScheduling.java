// @saorav21994

class Solution {
    
    private class job {
        private int st;
        private int et;
        private int p;
        
        public job(int st, int et, int p) {
            this.st = st;
            this.et = et;
            this.p = p;
        }
        
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<job> list = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            list.add(new job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(list, (a,b)->(a.et-b.et));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for (job j : list) {
            Integer stime = map.floorKey(j.st);
            int curp = stime == null ? 0 : map.get(stime);
            max = Math.max(max, curp + j.p);
            map.put(j.et, max);
        }
        return max;
    }
}

