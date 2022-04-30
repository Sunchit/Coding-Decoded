// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> q) {
        HashMap<String,HashMap<String,Double>> hm=new HashMap<>();
        for(int i=0;i<e.size();i++){
            if(!hm.containsKey(e.get(i).get(0))){
                HashMap<String,Double> al=new HashMap<>();
                al.put(e.get(i).get(1),v[i]);
                hm.put(e.get(i).get(0),al);
                hm.get(e.get(i).get(0)).put(e.get(i).get(0),1.0);
            }else{
                hm.get(e.get(i).get(0)).put(e.get(i).get(1),v[i]);
            }
             if(!hm.containsKey(e.get(i).get(1))){
                HashMap<String,Double> al=new HashMap<>();
                al.put(e.get(i).get(0),(1/v[i]));
                
                hm.put(e.get(i).get(1),al);
                hm.get(e.get(i).get(1)).put(e.get(i).get(1),1.0);
            }else{
                hm.get(e.get(i).get(1)).put(e.get(i).get(0),(1/v[i]));
            }
        }
        double[] ans=new double[q.size()];
        for(int i=0;i<q.size();i++){
            boolean y=false;
            if(!hm.containsKey(q.get(i).get(0))||!hm.containsKey(q.get(i).get(1))){
                ans[i]=-1.0;
            }else{
                HashMap<String,Double> A=hm.get(q.get(i).get(0));
                HashMap<String,Double> B=hm.get(q.get(i).get(1));
                for(String xy:A.keySet()){
                    if(B.containsKey(xy)){
                        ans[i]=A.get(xy)/B.get(xy);
                        break;
                    }else if(!q.get(i).get(0).equals(xy)){
                        HashSet<String> visited=new HashSet<>();
                        double u=dfs(q.get(i).get(0),q.get(i).get(1),(1/A.get(xy)),xy,hm,visited);
                        ans[i]=u;
                        if(u>=0.0){
                            break;
                        }
                    }
                }
               
            }
        }
        return ans;
    }
    
    public double dfs(String st,String en,double val,String intr,HashMap<String,HashMap<String,Double>> hm,HashSet<String> visited){
        HashMap<String,Double> x=hm.get(intr);
        visited.add(intr);
        for(String k:x.keySet()){
            if(visited.contains(k)){
                continue;
            }
            if(k.equals(en)){
                return x.get(k)/val;
            }
            double u=dfs(st,en,(val/x.get(k)),k,hm,visited);
            if(u>=0.0){
                return u;
            }
        }
        
        return -1.0;
    }
}