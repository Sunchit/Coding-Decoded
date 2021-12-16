class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int[] nonIncrease = new int[security.length];
        
        for(int i = 1; i < security.length - time; i++){
            if(security[i]>security[i-1]){
                nonIncrease[i] = 0;
            } else {
                nonIncrease[i] = nonIncrease[i-1] + 1;
            }
        }
        
        for(int el: nonIncrease){
            System.out.print(el+ " ");
        }

        int[] nonDecrease = new int[security.length];
        for(int i = security.length - 2; i >= time; i--) {
            if(security[i] > security[i + 1]){
                nonDecrease[i] = 0;
            } else {
                nonDecrease[i] = nonDecrease[i + 1] + 1;
            }
        }
        System.out.println();
         for(int el: nonDecrease){
                    System.out.print(el+ " ");
        }


        ArrayList<Integer> result = new ArrayList<>();
        for(int i = time; i < security.length - time; i++) {
            if(nonIncrease[i] >= time && nonDecrease[i] >= time) {
                result.add(i);
            }
        }
        return result;

    }
}