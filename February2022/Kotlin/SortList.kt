//Author : Shobhit Behl(LC : shobhitbruh)
//MergeSort Solution
class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        val p: ListNode = head
        var slow = head
        var fast = head
        while (fast!!.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }
        val r = slow!!.next
        slow.next = null
        val left = sortList(head)
        val right = sortList(r)
        return merge(left, right)
    }

    fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var p: ListNode? = dummy
        var p1 = l1
        var p2 = l2
        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                p!!.next = p1
                p1 = p1.next
                p = p.next
            } else {
                p!!.next = p2
                p2 = p2.next
                p = p.next
            }
        }
        while (p1 != null) {
            p!!.next = p1
            p1 = p1.next
            p = p.next
        }
        while (p2 != null) {
            p!!.next = p2
            p2 = p2.next
            p = p.next
        }
        return dummy.next
    }
}