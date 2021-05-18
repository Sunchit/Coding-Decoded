class Solution {
    public List<List<String>> findDuplicate(String[] paths) {

        // <Content, List<FilePath>>
        Map<String, List<String>> map = new HashMap<>();


        //"root/a 1.txt(abcd) 2.txt(efgh)

        for(String path : paths){
            String[] dir = path.split(" ");
            String rootPath = dir[0]; // root/a
            for(int i=1;i<dir.length;i++){
                //1.txt(abcd)
                String content = dir[i].substring(dir[i].indexOf("("),dir[i].indexOf(")"));

                if(!map.containsKey(content)) {
                    map.put(content,new ArrayList<>());
                }

                //1.txt(abcd)
                map.get(content).add(rootPath +"/" +dir[i].substring(0 ,dir[i].indexOf("(")));
            }
        }


        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){

            // check for duplication
            if(entry.getValue().size()>1)
                list.add(entry.getValue());
        }
        return list;
    }
}