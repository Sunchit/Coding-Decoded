# TC : O(N*logN) , Where N --> n(number of nodes)*k(lenght of lists)

# SC : O(N)

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        valList = []
        for list in lists:
            while list != None:
                valList.append(list.val)
                list = list.next
        valList.sort()
        head = dummy = ListNode(0)
        for nodeVal in valList:
            dummy.next = ListNode(nodeVal)
            dummy = dummy.next
        return head.next
