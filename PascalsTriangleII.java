class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> newList = new ArrayList<>();
        List<Integer> previousList = new ArrayList<>();

        if(rowIndex==0){
            newList.add(1);
            return newList;
        }

        previousList.add(1);
        previousList.add(1);
        if(rowIndex==1){
            return previousList;
        }

        int count =1;

        while(count<rowIndex) {
            newList = new ArrayList<>();
            for(int i=0;i<previousList.size()+1;i++){
                if((i==0) || i==previousList.size()){
                    newList.add(1);
                } else {
                    newList.add(previousList.get(i) + previousList.get(i-1));
                }
            }
            previousList = newList;
            count++;
        }
        return newList;

    }

}