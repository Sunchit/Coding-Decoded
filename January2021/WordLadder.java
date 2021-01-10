class Solution {

    // TC: O(n*n)/ O(v+E)
    // SC : O(V+E)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String el: wordList){
            set.add(el);
        }

        set.add(beginWord);

        Map<String, List<String>> map = new HashMap<>();

        buildGraph(map, set);

        Set<String> visited = new HashSet<String>();

        Queue<String> qu = new LinkedList<>();

        qu.offer(beginWord);

        int level = 0;
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-->0){
                String head = qu.poll();
                if(head.equals(endWord)){
                    return level+1;
                }

                if(visited.contains(head)){
                    continue;
                }


                for(String connection : map.getOrDefault(head, new ArrayList<>())){
                    if(!visited.contains(connection)){
                        qu.offer(connection);
                    }
                }
                visited.add(head);
            }
            level++;
        }

        if(visited.contains(endWord)){
            return level;
        } else{
            return 0;
        }

    }

    // O(n2)
    private void buildGraph(Map<String, List<String>> map, Set<String> wordSet){
        for(String el : wordSet){

            for(String innerEl : wordSet){
                if(el.equals(innerEl)){
                    continue;
                }else {
                    if(stringsDifferByOne(el, innerEl)){
                        // el to innerEl
                        List<String> connections = map.getOrDefault(el, new ArrayList<>());
                        connections.add(innerEl);
                        map.put(el, connections);

                    }
                }
            }

        }

    }


    private boolean stringsDifferByOne(String a, String b){
        if(a.length() !=b.length()){
            return false;
        } else{
            boolean foundOneDifference = false;
            for(int i=0;i<a.length();i++){
                char aChar = a.charAt(i);
                char bChar = b.charAt(i);
                if(aChar != bChar){
                    if(foundOneDifference){
                        return false;
                    }
                    foundOneDifference = true;
                }
            }
            return true;
        }
    }
}