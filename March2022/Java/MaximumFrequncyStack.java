// Author: Shobhit Behl (LC: shobhitbruh)
class FreqStack {
    public class pair implements Comparable<pair>{
        int val;
        int fr;
        int t;
        pair(int val,int fr,int t){
            this.val=val;
            this.fr=hm.getOrDefault(val,0);
            this.t=t;
        }
        
        public int compareTo(pair x){
            if(this.fr!=x.fr){
                return x.fr-this.fr;
            }
            return x.t-this.t;
        }
    }
    int c;
    PriorityQueue<pair> pq;
    HashMap<Integer,Integer> hm;
    public FreqStack() {
        c=0;
        hm=new HashMap<>();
        pq=new PriorityQueue<>();
    }
    
    public void push(int val) {
        int j=hm.getOrDefault(val,0);
        hm.put(val,j+1);
        pq.add(new pair(val,hm.get(val),c));
        c++;
    }
    
    public int pop() {
        if(pq.size()==0){
            return -1;
        }
        pair a=pq.remove();
        a.fr--;
        hm.put(a.val,a.fr);
        if(a.fr==0){
            hm.remove(a.val);
        }
        return a.val;
    }
    
}