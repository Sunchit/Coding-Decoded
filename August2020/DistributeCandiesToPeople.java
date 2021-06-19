class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] distribution = new int[num_people];
        int index = 0;
        int candyCount = 1;
        while(candies>0){
            if(candies <candyCount){
                distribution[index] += candies;
            } else {
                distribution[index] += candyCount;
            }
            candies = candies - candyCount;
            candyCount++;
            index++;
            index  = index% num_people;

        }
        return distribution;
    }
}