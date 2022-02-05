// Created by LeetCode : shobhitbruh
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq=PriorityQueue<Int>()
        var result=ListNode(0)
        var resultHead=result
        
        for(list in lists){
            var head=list
            while(head!=null){
                pq.offer(head.`val`)
                head=head.next
                
            }
        }
        
        while(pq.isNotEmpty()){
            result.next=ListNode(pq.poll())
            result=result.next
        }
        
        return resultHead.next
    }
}