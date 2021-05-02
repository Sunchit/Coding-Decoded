class Solution {

    // TC : O(nlogn)
    // SC : O(n)
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> (a[1] - b[1]));

        // Course duration of the selected ones
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ((a,b) -> (b-a));

        int timeElapsed = 0;
        for(int[] course : courses){
            if(timeElapsed + course[0] <= course[1]){
                pq.offer(course[0]);
                timeElapsed += course[0];
            } else if(!pq.isEmpty() && pq.peek() > course[0]){
                timeElapsed = timeElapsed - pq.poll();
                pq.offer(course[0]);
                timeElapsed = timeElapsed + course[0];
            } else {
                // pq.peek() < course[0]
                // reject the current course
            }
        }

        return pq.size(); // 3
    }

    // [100,200],[200,1300],[1000,1250],[2000,3200]]
    //[100, 200]
    //[1000, 1250]
    //[200, 1300]
    //[2000 3200]

    // timeElapsed =  1100 + 200 = 1300

    // pq {100 , 1000, 200}

}