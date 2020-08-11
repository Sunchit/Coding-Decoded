class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len+1];

        for(int el: citations){
            if(el>= len){
                bucket[len]++;
            } else{
                bucket[el]++;
            }
        }
        int total =0;
        for(int i=len;i>=0;i--){
            total += bucket[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}