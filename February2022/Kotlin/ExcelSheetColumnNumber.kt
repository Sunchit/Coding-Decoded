//Author : Shobhit Behl (LC:shobhitbruh)
class Solution {
    fun titleToNumber(a: String): Int {
        val arr=a.toCharArray();
        var ans=0
        var p=0
        for(i in arr.indices.reversed()){
           ans+=(pow(p)*(arr[i]-'A'+1))
           p++
        }

        return ans
    }

    fun pow(x: Int):Int{
        var i=1
        var t=x
        while(t-->0){
            i*=26
        }

        return i
    }
}