
// @saorav21994
// TC : O(1) - asymptotically
// SC : O(station^2) - for each station -> other station we need to know the details

class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> srcStation;
    HashMap<String, station> stationDetail;
    public UndergroundSystem() {
        srcStation = new HashMap<>();
        stationDetail = new HashMap<>();
        // System.out.println("init");
    }
    
    public void checkIn(int id, String stationName, int t) {
        srcStation.put(id, new Pair<>(stationName, t));
        // System.out.println("checkIn");
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = srcStation.get(id);
        String dst = stationName;
        String src = pair.getKey();
        srcStation.remove(id);
        int timeTaken = t-pair.getValue();
        HashMap<String, Pair<Integer, Integer>> tmp;
        Pair<Integer, Integer> timecount;
        if (stationDetail.containsKey(src) == true) {
            tmp = stationDetail.get(src).time;
            if (tmp.containsKey(dst) == true) {
                timecount = tmp.get(dst);    
            }
            else {
                timecount = new Pair<>(0, 0);
            }
            int ptotal = timecount.getKey();
            int pcount = timecount.getValue();
            pcount += 1;
            ptotal += timeTaken;
            timecount = new Pair<>(ptotal, pcount);
        }
        else {
            timecount = new Pair<>(timeTaken, 1);
            tmp = new HashMap<>();
        }
        tmp.put(dst, timecount);
        stationDetail.put(src, new station(tmp));
        // System.out.println("checkOut");
    }
    
    public double getAverageTime(String startStation, String endStation) {
        HashMap<String, Pair<Integer, Integer>> tmp;
        Pair<Integer, Integer> timecount;
        station stat = stationDetail.get(startStation);
        tmp = stat.time;
        timecount = tmp.get(endStation);
        double res = (double)((double)timecount.getKey()/(double)timecount.getValue());
        // System.out.println("res = " + res);
        return res;
    }
    
    public class station {
        private HashMap<String, Pair<Integer, Integer>> time = new HashMap<>();
        public station(HashMap<String, Pair<Integer, Integer>> time) {
            this.time = time;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
