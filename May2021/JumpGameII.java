// Soution 1
class Solution {

    // Tc : o(n)
    // Sc : o(n)
    public int jump(int[] nums) {
        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        qu.offer(0);
        int level = 0;
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-->0){
                Integer currIndex = qu.poll();
                if(visited[currIndex]){
                    continue;
                }
                if(currIndex == nums.length-1){
                    return level;
                }


                int maxIndex = Math.min(currIndex + nums[currIndex], nums.length-1);

                while(maxIndex>currIndex){
                    if(!visited[maxIndex]){
                        qu.offer(maxIndex);
                    }
                    maxIndex--;
                }
                visited[currIndex] = true;
            }
            level++;
        }
        return level;
    }
}

// Solution 2

class Solution {

    // TC : O(n)
    // SC : O(1)
    public int jump(int[] nums) {
        int level =0;
        int divider = 0;
        int maxReachableIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(i> divider){
                level++;
                divider = maxReachableIndex;
            }
            maxReachableIndex = Math.max(maxReachableIndex, i +nums[i]);
        }

        return level;
    }

}