
class Passenger{
    int startTime;
    int endTime;
    String startStation;
    String endStation;

    public Passenger(String startStation,int startTime){
        this.startStation  = startStation;
        this.startTime = startTime;
    }

    void checkout(String endStation, int endTime) {
        this.endTime = endTime;
        this.endStation = endStation;
    }
}


class Route {

    int tripCount;
    long totalTravelTime;

    public Route() {
    }

    double getAverageTime() {
        return (double) totalTravelTime / tripCount;
    }

    void addTrip(int travelDuration) {
        totalTravelTime += travelDuration;
        tripCount += 1;
    }
}
class UndergroundSystem {

    // Passenger ID, Passenger
    Map<Integer, Passenger> passengerMap = null;
    // Routemap
    // <StartingStation_Ending, Route>
    Map<String, Route> routeMap = null;

    public UndergroundSystem() {
        routeMap =new HashMap<>();
        passengerMap = new HashMap();

    }

    // TC : O(1)
    public void checkIn(int id, String stationName, int t) {
        if(!passengerMap.containsKey(id)){
            Passenger newTraveller = new Passenger(stationName, t);
            passengerMap.put(id, newTraveller);
        }
    }

    // TC : O(1)
    public void checkOut(int id, String stationName, int t) {
        if(passengerMap.containsKey(id)){
            Passenger oldTraveller = passengerMap.get(id);
            oldTraveller.checkout(stationName, t);
            String routeKey  = oldTraveller.startStation + "_" + oldTraveller.endStation;

            Route routeDetails = routeMap.getOrDefault(routeKey, new Route());
            int duration = oldTraveller.endTime -oldTraveller.startTime;
            routeDetails.addTrip(duration);
            routeMap.put(routeKey, routeDetails);
            passengerMap.remove(id);
        }
    }

    // TC : O(1)
    public double getAverageTime(String startStation, String endStation) {
        String routeKey  = startStation + "_" + endStation;
        Route routeDetails = routeMap.get(routeKey);
        return routeDetails.getAverageTime();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */