
# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(N)
class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        if n <= 1:
            return 0

        graph = defaultdict(list)
        for i in range(n):
            graph[arr[i]] += [i]

        queue = [0]
        visited = {0}
        step = 0
        while queue:
            nex = []
            for node in queue:
                if node == n-1:
                    return step
                for child in graph[arr[node]]:
                    if child not in visited:
                        visited.add(child)
                        nex.append(child)
                graph[arr[node]].clear()

                for child in [node-1, node+1]:
                    if 0 <= child < len(arr) and child not in visited:
                        visited.add(child)
                        nex.append(child)

            queue = nex
            step += 1

        return -1
