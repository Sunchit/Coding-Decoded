//Author : Shobhit Behl (LC:shobhitbruh)
class Solution {
    fun removeCoveredIntervals(arr: Array<IntArray>): Int {
        Arrays.sort(arr){a:IntArray,b:IntArray->if(a[0]==b[0])b[1]-a[1] else a[0]-b[0]}
        var ans=0
        var j=-1
        for(i in arr.indices){
            if(arr[i][1]>j){
                j=arr[i][1]
            }else{
                ans++
            }
        }
        
        return arr.size-ans
    }
}