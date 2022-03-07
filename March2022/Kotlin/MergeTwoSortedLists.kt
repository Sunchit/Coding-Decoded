// Author: Shobhit Behl (LC: shobhitbruh)
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy: ListNode = ListNode(-1)
    var x: ListNode? = dummy
    var p1 = list1
    var p2 = list2
    while (p1 != null && p2 != null) {
        if (p1.`val` < p2.`val`) {
            x!!.next = p1
            p1 = p1.next
        } else {
            x!!.next = p2
            p2 = p2.next
        }
        x = x.next
    }
    while (p1 != null) {
        x!!.next = p1
        p1 = p1.next
        x = x.next
    }
    while (p2 != null) {
        x!!.next = p2
        p2 = p2.next
        x = x.next
    }
    return dummy.next
}