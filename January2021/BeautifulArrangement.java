class Solution {

    private int count = 0; // store the answer


    // TC : O(n!)
    public int countArrangement(int n) {
        if(n<=0)    {
            return count;
        }

        boolean[] visited = new boolean[n+1];// as the array starts from 1 to N
        // used to generate all the permutations of the input array
        helper(visited, 1, n);
        return count;
    }

    private void helper(boolean[] visited, int valOrIndex,  int n){
        if(valOrIndex > n){
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i] && (valOrIndex % i ==0 || i%valOrIndex ==0)){
                visited[i] = true; // index or val has been consumed
                helper(visited, valOrIndex+1, n);
                visited[i] = false; // undo the change
            }
        }
    }
}