class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] sortedArray = new int[A.length];
        int start =0;
        int end = A.length-1;
        for(int el: A){
            if(el%2==0){ // Track for even values
                sortedArray[start] = el;
                start++;
            } else{ // Track for odd values
                sortedArray[end] = el;
                end--;
            }
        }
        return sortedArray;
    }
}