class MinimumCostOfTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] travelCost = new int[days[days.length-1]+1];

        // Set for identifying travel dates
        Set<Integer> set = new HashSet<>();
        for(int day: days){
            set.add(day);
        }

        for(int i=1;i<travelCost.length;i++){
            if(!set.contains(i)) {
                // Non travel day simply copy the value from previous day
                travelCost[i] =travelCost[i-1];
            } else{
                int priceUsingDailyPass = travelCost[i-1]+ costs[0];

                int priceUsingWeeklyPass = costs[1];
                if(i>=7){
                    priceUsingWeeklyPass = travelCost[i-7]+ costs[1];
                }


                int priceUsingMonthlyPass = costs[2];
                if(i>=30){
                    priceUsingMonthlyPass = travelCost[i-30]+ costs[2];
                }
                // comparison between the possible 3 values
                travelCost[i]= Math.min(priceUsingMonthlyPass, Math.min(priceUsingDailyPass,priceUsingWeeklyPass));
            }
        }

        return travelCost[travelCost.length-1];
    }
}