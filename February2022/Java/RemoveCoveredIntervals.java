//Author : Shobhit Behl (LC:shobhitbruh)
class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int ans=0;
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][1]>j){
                j=arr[i][1];
            }else{
                ans++;
            }
        }

        return arr.length-ans;

    }
}