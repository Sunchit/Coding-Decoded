// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        var hm=HashMap<Int,Long>();
        for(el in arr){
            hm.put(el,hm.getOrDefault(el,0L)+1L);
        }
        var ans:Long=0;
        for(e1 in hm.keys){
            for(e2 in hm.keys){
                var e3:Int=target-(e1+e2);
                if(hm.containsKey(e3)){
                     val f1 = hm[e1]!!
                    val f2 = hm[e2]!!
                    val f3 = hm[e3]!!
                    if (e1 == e2 && e2 == e3) {
                        ans += f1 * (f1 - 1) * (f1 - 2) / 6
                    } else if (e1 == e2 && e2 != e3) {
                        ans += f1 * (f1 - 1) / 2 * f3
                    } else if (e1 < e2 && e2 < e3) {
                        ans += f1 * f2 * f3
                    }
                }
                ans=ans%1000000007;
            }
        }
        return ans.toInt();
    }
}