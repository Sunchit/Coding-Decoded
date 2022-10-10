// https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/
// @author: anuj0503
class Solution {
    class Person {
        int time;
        int id;

        public Person(int a, int b){
            id = a;
            time = b;
        }
    }
    public int hardestWorker(int n, int[][] logs) {
        PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.time == o2.time) return o1.id - o2.id;
                
                return o2.time - o1.time;
            }
        });

        pq.offer(new Person(logs[0][0], logs[0][1]));

        for(int i = 1; i < logs.length; i++){
            pq.offer(new Person(logs[i][0], logs[i][1] - logs[i - 1][1]));
        }
        
        return pq.poll().id;
    }
}
