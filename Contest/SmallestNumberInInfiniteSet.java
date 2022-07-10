// https://leetcode.com/problems/smallest-number-in-infinite-set/
// @author: anuj0503
class SmallestInfiniteSet {
    int head;
    boolean[] visited;
    SmallestInfiniteSet() {
        visited = new boolean[1001];
        Arrays.fill(visited, true);
        head = 1;
    }
    
    int popSmallest() {
        int ans = head;
        visited[ans] = false;
        for(int i = head + 1; i <= 1000; i++){
            if(visited[i]){
                head = i;
                break;
            }
        }
        return ans;
    }
    
    void addBack(int num) {
        if(visited[num])
            return;
        
        visited[num] = true;
        
        if(num < head){
            head = num;
        }
    }
}


 class SmallestInfiniteSet {
     private PriorityQueue<Integer> pq = null;
     //private Set<Integer> set  = null;
     public SmallestInfiniteSet() {

         pq=new PriorityQueue<>(1000);  //Initializing
         //set=new HashSet<>(1000);  //Initializing
         for(int i=1;i<=1000;i++) {
             pq.add(i);
            // set.add(i);
         }
     }

     public int popSmallest() {
        int x=pq.poll(); //remove from priorityqueue
        // set.remove(x); //Remove from set too
         return x;
     }

     public void addBack(int num) {
         // O(n) -> O(1)
         if(!pq.contains(num)){    //Check if the no. is not present in set that means it is not present in priorityQueue
             pq.add(num);  //add to priorityQueue
          //   set.add(num);   //Add to set
         }
     }
 }

class SmallestInfiniteSet {
    TreeSet<Integer> set;

    // O(1)
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        for(int i=1;i<=1000;i++){
            set.add(i);
        }
    }
    // O(logn)
    public int popSmallest() {
        return set.pollFirst(); // ->
    }

    // O(logn)
    public void addBack(int num) {
        set.add(num);
    }
}