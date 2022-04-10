// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> al=new ArrayList<>();
        int a=num;
        while(a>0){
            int j=a%10;
            if(j%2==0){
                even.add(j);
                al.add(0,0);
            }else{
                odd.add(j);
                al.add(0,1);
            }
            a/=10;
        }
        StringBuilder b=new StringBuilder();
        for(int i=0;i<al.size();i++){
            if(al.get(i)==0){
                b.append(even.remove());
            }else{
                b.append(odd.remove());
            }
        }
        
        return Integer.parseInt(b.toString());
    }
}