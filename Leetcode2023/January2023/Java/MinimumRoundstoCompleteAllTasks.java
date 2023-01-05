// Problem Link: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
//  Author @ Mahesh Reddy B N

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }
        int count = 0;
        for(int i: hm.values()){
            if(i==1) return -1;
            count+= i/3;
            if(i%3!=0) count++;
        }
        return count;
    }
}