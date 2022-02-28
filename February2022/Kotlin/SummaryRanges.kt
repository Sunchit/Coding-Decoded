//Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    fun summaryRanges(arr: IntArray): List<String> {
     val ans: MutableList<String> = ArrayList()
     if (arr.size == 0) {
         return ans
     }
     var i = 0
     var j = 0
     while (i < arr.size) {
         if (arr[i] - arr[j] != i - j) {
             val sb = StringBuilder()
             if (i - 1 == j) {
                 sb.append(arr[j])
                 ans.add(sb.toString())
             } else {
                 sb.append(arr[j].toString() + "->" + arr[i - 1])
                 ans.add(sb.toString())
             }
             j = i
         }
         i++
     }
     val sb = StringBuilder()
     if (i - 1 == j) {
         sb.append(arr[j])
         ans.add(sb.toString())
     } else {
         sb.append(arr[j].toString() + "->" + arr[i - 1])
         ans.add(sb.toString())
     }
     return ans
 }
 
}