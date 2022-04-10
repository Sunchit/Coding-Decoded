# TC : O(M^2 * N), where M is size of dequeued word & N is size of our word list
# SC : O(M * N) where M is no. of character that we had in our string & N is the size of our wordList.

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(word for word in wordList)
        queue = [beginWord]
        visited = set(beginWord)
        changes = 1
        while queue:
            size = len(queue)
            for ind in range(size):
                word = queue.pop(0)
                if word == endWord:
                    return changes
                for i in range(len(word)):
                    for asc in range(97, 123):
                        newWord = list(word)
                        newWord[i] = chr(asc)
                        newWord = "".join(newWord)
                        if newWord in wordSet and newWord not in visited:
                            visited.add(newWord)
                            queue.append(newWord)
            changes += 1
        return 0
