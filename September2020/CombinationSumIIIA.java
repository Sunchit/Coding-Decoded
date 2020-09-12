class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>>  set = new HashSet<>();
        combinationSum3Helper(set, k, n, new HashSet<>());
        return new ArrayList<>(set);
    }

    private void combinationSum3Helper(Set<List<Integer>> ans, int noOfElements, int remainingSum, Set<Integer> runningSet) {
        if(noOfElements ==0){
            if(remainingSum==0){
                ans.add(new ArrayList<>(runningSet));
                return ;
            } else {
                return ;
            }
        }

        if(remainingSum<0){
            return ;
        }

        for(int i=1;i<=9;i++) {
            if(!runningSet.contains(i)){
                runningSet.add(i);
                combinationSum3Helper(ans,noOfElements-1, remainingSum- i, runningSet);
                runningSet.remove(i);
            }
        }
    }
}