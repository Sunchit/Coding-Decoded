class Solution {
    // TC : O(n)
    // SC : O(n) // 1 2 3 4 6 ...n
     public int distributeCandies(int[] candyType) {

         HashSet<Integer> hashSet = new HashSet<>();
         for(int type : candyType){
             hashSet.add(type);
         }

         return Math.min(hashSet.size(), candyType.length/2);
     }

    public int distributeCandies(int[] candyType) {
        return Math.min(candyType.length/2, ((int)Arrays.stream(candyType).distinct().count()));
    }
}