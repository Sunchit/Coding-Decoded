//Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    fun countBits(n: Int): IntArray {
        val arr = IntArray(n+1)
        
        for(i in arr.indices){
            var j=i
            var c=0
            while(j>0){
                c++
                j = j xor (j and (j.inv()+1))
            }
            arr[i]=c
        }
        
        
        return arr
    }
}