// Time complexity is O(n2)
// Space complexity is O(n)

class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        int len = A.length;
        List<Integer> ans = new ArrayList<>();
        if(len==0){
            return ans;
        }

        int index = A.length-1;
        while(index>=0){
            int maxElIndex = getMaxElIndex(A, index); // find the max element index
            if(maxElIndex != index){ // if the index is not at the correct position
                flip(A, maxElIndex); //Bring the max el to the top
                ans.add(maxElIndex+1);
                flip(A, index); // Bring the max el to the last index in the list
                ans.add(index+1);
            }
            index--; // reduce the index as  we got last elment at the bottom
        }
        return ans;
    }

    // helper to identify the max el index
    private int getMaxElIndex(int[] A, int len){

        int maxIndex = 0;
        int maxEl = A[0];
        for(int i=0;i<=len;i++){
            if(maxEl<A[i]){
                maxEl = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    // Flip the array
    private void flip(int[] A, int len){
        int start = 0;
        int end = len;
        while(start<=end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }

    }
}