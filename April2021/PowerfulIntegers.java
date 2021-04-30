class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();

        for(int powerX = 1; powerX < bound;powerX  = powerX  *x){
            for(int powerY = 1;powerY  < bound; powerY = powerY * y){
                int generatedNo = powerX  + powerY;
                if(generatedNo<=bound){
                    set.add(generatedNo);
                }

                // y is 1

                if(y==1){
                    break;
                }
            }
            if(x==1){
                break;
            }

        }

        return new ArrayList<>(set);
    }
}