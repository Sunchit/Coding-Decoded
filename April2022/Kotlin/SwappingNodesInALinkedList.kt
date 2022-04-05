// Author: Shobhit Behl (LC: shobhitbruh)
var len = 1
        var j = head
        while (j != null) {
            len++
            j = j.next
        }
        var i = head
        var p = 1
        while (p < k) {
            i = i!!.next
            p++
        }
        p = 1
        var d = head
        while (p < len - k) {
            d = d!!.next
            p++
        }
        val temp = d!!.`val`
        d.`val` = i!!.`val`
        i.`val` = temp
        return head