class Solution:
    def partitionString(self, s: str) -> int:
        char_set = set()
        count = 1
        for c in s:
            if c in char_set:
                count += 1
                char_set.clear()
            char_set.add(c)
        return count
