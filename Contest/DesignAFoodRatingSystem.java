// https://leetcode.com/problems/design-a-food-rating-system/
// @author: anuj0503
class FoodRatings {
    Map<String, SortedSet<Pair<String, Integer>>> cMap;
    Map<String, String> fMap;
    Map<String, Integer> rMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cMap = new HashMap<>();
        fMap = new HashMap<>();
        rMap = new HashMap<>();

        for(int i = 0; i < foods.length; i++){
            SortedSet<Pair<String, Integer>> set = cMap.getOrDefault(cuisines[i], new TreeSet<Pair<String, Integer>>(new Comparator<Pair<String, Integer>>(){
                @Override
                public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2){
                    if(p1.getValue().equals(p2.getValue())){
                        return p1.getKey().compareTo(p2.getKey());
                    }

                    return p2.getValue() - p1.getValue();

                }
            }));
            set.add(new Pair<String, Integer>(foods[i], ratings[i]));
            
            cMap.put(cuisines[i], set);
            fMap.put(foods[i], cuisines[i]);
            rMap.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        SortedSet<Pair<String, Integer>> set = cMap.get(fMap.get(food));
        set.remove(new Pair<String, Integer>(food, rMap.get(food)));

        set.add(new Pair<String, Integer>(food, newRating));

        cMap.put(fMap.get(food), set);
        rMap.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cMap.get(cuisine).first().getKey();
    }
}


class FoodRatings {


    private class Food {
        private int rating;
        private String name;
        private String cuisine;
        Food(String name, String cuisine, int rating){
            this.name = name; this.rating = rating; this.cuisine = cuisine;
        }
    }

    // <Cuisine, PriorityQueue<Food>>
    Map<String, PriorityQueue<Food>> cuisineMap = new HashMap<>(); // get pq from cuisine name
    // <FoodName, Food>
    Map<String, Food> menu = new HashMap<>(); // get Food (object) using  food name

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0; i<foods.length; i++){

            Food foodObject = new Food(foods[i], cuisines[i], ratings[i]);

            // Create a Max Heap on the basis of rating
            cuisineMap.putIfAbsent(cuisines[i], new PriorityQueue<>((a,b)->
                                                                            b.rating==a.rating ? a.name.compareTo(b.name) : b.rating-a.rating));

            PriorityQueue<Food> pq = cuisineMap.get(cuisines[i]);
            pq.add(foodObject);
            menu.put(foods[i], foodObject);

        }
    }

    public void changeRating(String food, int newRating) {
        Food curr = menu.get(food);
        PriorityQueue<Food> pq = cuisineMap.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;
        pq.add(curr);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek().name;
    }


}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */