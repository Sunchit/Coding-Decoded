class Solution {
	// TC :  O(V+E)
	// SC : O(V+E)
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		// Course, List of Course Ids
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i=0;i<numCourses;i++){
			map.put(i, new HashSet<>());
		}
		for(int[] prereq : prerequisites) {
			int course = prereq[0];
			int dependingCourse = prereq[1];
			// Egde from dependingCourse towards the current course
			map.get(dependingCourse).add(course);
			indegree[course]++;
		}
		// Course Ids
		Queue<Integer> qu = new LinkedList<>();
		for(int i=0;i<numCourses;i++) {
			if(indegree[i] == 0){
				qu.offer(i);
			}
		}
		List<Integer> order = new ArrayList<>();
		while(!qu.isEmpty()){
			int size = qu.size();
			while(size-->0){
				int head = qu.poll();
				if(indegree[head]==0){
					//indegree[head]--;
					order.add(head);
				}
				for(Integer children : map.get(head)){
					indegree[children]-- ;
					if(indegree[children] == 0){
						qu.offer(children);
					}
				}
			}
		}
		int i = 0;
		int[] ans = new int[order.size()];
		for(Integer el: order){
			ans[i] = el;
			i++;
		}

		if(order.size() != numCourses){
			// few pending courses and those cant be completed
			return new int[]{};
		}
		return ans;

	}
}