class Solution {

    // TC : O(n)
    // SC : O(1)
    public boolean isIdealPermutation(int[] A) {

        int cMax = A[0];
        for(int i=0;i<A.length-2;i++){
            cMax = Math.max(cMax, A[i]);
            if(cMax>A[i+2]){
                return false;
            }
        }
        return true;
    }
    // TC : O(n2) passed
     public boolean isIdealPermutation(int[] A) {


             for(int i=0;i<A.length;i++){
             for(int j=i+2;j<A.length;j++){
                 if(A[i]>A[j]){
                    return false;
                 }
             }
         }
         return true;
     }

    // O(n2) Causing TLE
     public boolean isIdealPermutation(int[] A) {
         int local = 0;
         for(int i=0;i<A.length-1;i++){
             if(A[i]>A[i+1]){
                 local++;
             }
         }

         int global = 0;
         for(int i=0;i<A.length;i++){
             for(int j=i+1;j<A.length;j++){
                 if(A[i]>A[j]){
                    global++;
                 }
             }
         }
         return local ==global;
     }




}