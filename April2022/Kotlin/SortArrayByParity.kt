// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun sortArrayByParity(arr: IntArray): IntArray {
         var i:Int=0
         var j:Int=0
        while(j<arr.size){
            if(arr[j]%2==0){
                swap(arr,i,j)
                i++
            }
            j++
        }
        return arr
    }
    fun swap(arr:IntArray,i:Int,j:Int){
        var temp:Int=arr[i]
        arr[i]=arr[j]
        arr[j]=temp
    }
}