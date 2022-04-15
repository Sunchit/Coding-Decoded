// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun maxArea(a: IntArray): Int {
        var i:Int=0
        var j:Int=a.size-1
        var ans:Int=0
        while(i<j){
            ans=Math.max(Math.min(a[i],a[j])*(j-i),ans)
            if(a[i]<a[j]){
                i++
            }else if(a[i]>a[j]){
                j--
            }else{
                i++
                j--
            }
        }
        
        return ans
    }
}