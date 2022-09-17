// Created by LeetCode : shobhitbruh
fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        val one: ListNode = head
        val two: ListNode = head.next
        val three: ListNode? = two.next
        two.next = one
        one.next = swapPairs(three)
        return two
    }