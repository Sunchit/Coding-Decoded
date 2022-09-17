// https://leetcode.com/problems/course-schedule-iv/
// @author: anuj0503
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        HashSet<Integer>[] preCourseMap = new HashSet[numCourses];

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<>());
            preCourseMap[i] = new HashSet<>();
        }

        for(int[] p : prerequisites){
            int u = p[0];
            int v = p[1];

            Set<Integer> s = graph.get(u);
            s.add(v);
            indegree[v]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int head = queue.poll();

            for(int neighbour : graph.get(head)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0) queue.offer(neighbour);
                preCourseMap[neighbour].addAll(preCourseMap[head]);
                preCourseMap[neighbour].add(head);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries){
            int u = q[0];
            int v = q[1];

            result.add(preCourseMap[v].contains(u));
        }

        return result;
    }
}
