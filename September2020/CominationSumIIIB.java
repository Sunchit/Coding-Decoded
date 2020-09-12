class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>>  set = new HashSet<>();
        combinationSum3Helper(set, k, n, new HashSet<>(), 1);
        return new ArrayList<>(set);
    }

    private void combinationSum3Helper(Set<List<Integer>> ans, int noOfElements, int remainingSum, Set<Integer> runningSet, int startVal) {
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

        for(int i=startVal;i<=9;i++) {

            runningSet.add(i);
            combinationSum3Helper(ans,noOfElements-1, remainingSum- i, runningSet, i+1);
            runningSet.remove(i);

        }
    }
}