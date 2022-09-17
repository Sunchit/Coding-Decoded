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



class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] ans = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            Set<String> visited = new HashSet<String>();
            if(query.get(0).equals(query.get(1))){
                if(graph.containsKey(query.get(0))){
                    ans[i] = 1.0;
                    i++;

                } else{
                    ans[i] = -1.0;
                    i++;

                }
                continue;
            }
            double res = dfs(query.get(0), query.get(1), graph, visited);
            ans[i] = res;
            i++;
        }

        return ans;
    }
    private double dfs(String start, String end,  Map<String, Map<String, Double>> graph, Set<String> visited) {
        if(!graph.containsKey(start)) {
            return -1.0;
        }

        if(graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        Map<String, Double> startMap = graph.get(start);
        for(Map.Entry<String, Double> entry: startMap.entrySet()) {
            if(!visited.contains(entry.getKey())){

                double currVal = dfs(entry.getKey(), end, graph, visited);

                if(currVal!=-1){
                    return currVal * entry.getValue();
                }
            }
        }
        return -1.0;

    }
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        // source, <End, Value>
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for(List<String> equation : equations) {
            String startEl = equation.get(0);
            String endEl = equation.get(1);
            double val = values[i];
            i++;
            graph.putIfAbsent(startEl, new HashMap<>());

            graph.get(startEl).put(endEl, val);


            graph.putIfAbsent(endEl, new HashMap<>());

            graph.get(endEl).put(startEl, 1/val);
        }
        return graph;

    }
}