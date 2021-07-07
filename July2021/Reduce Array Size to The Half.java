/*
 * @author : Darshika Jha
 * Question Link : https://leetcode.com/problems/reduce-array-size-to-the-half/submissions/
*/
class Solution {
    public int minSetSize(int[] arr) {
        int res = 0;
        Arrays.sort(arr); //nlog(n)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]); 
        int count = 1;
        int prev = arr[0];
        for(int i = 1;i<arr.length;i++){  //O(n)
            int cur = arr[i];
            if(prev!=cur){
                int[] temp ={prev,count};
                pq.add(temp); //logn
                count = 1;
                prev = cur;
            }else{
                count++;
            }
        }
        if(count>0){
            int[] temp ={prev,count};
            pq.add(temp);
        }
        int tot = arr.length;
        while(tot>arr.length/2){
            int freq = pq.poll()[1];
            tot -= freq;
            res++;
        }
        return res;
    }
}
