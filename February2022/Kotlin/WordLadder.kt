// Author : Shobhit Behl(shobhitbruh)
class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        val hm = HashMap<String, MutableList<String>>()
        val visited = HashMap<String, Boolean>()
        var n = false
        for (i in wordList.indices) {
            if (wordList[i] == beginWord) {
                n = true
            }
            hm[wordList[i]] = ArrayList()
            visited[wordList[i]] = false
        }
        if (!n) {
            wordList.add(beginWord)
            hm[beginWord] = ArrayList()
            visited[beginWord] = false
        }
        if (!hm.containsKey(endWord)) {
            return 0
        }
        for (i in wordList.indices) {
            for (j in i + 1 until wordList.size) {
                if (wordList[i].length == wordList[j].length) {
                    var p = 0
                    for (k in 0 until wordList[i].length) {
                        if (wordList[i][k] != wordList[j][k]) {
                            p++
                        }
                    }
                    if (p == 1) {
                        hm[wordList[i]]!!.add(wordList[j])
                        hm[wordList[j]]!!.add(wordList[i])
                    }
                }
            }
        }
        // System.out.println(hm);
        val li = LinkedList<String>()
        li.addLast(beginWord)
        var p = 0
        while (li.size > 0) {
            var size = li.size
            p++
            while (size-- > 0) {
                val rem = li.removeFirst()
                visited[rem] = true
                if (rem == endWord) {
                    return p
                }
                for (i in hm[rem]!!.indices) {
                    if (!visited[hm[rem]!![i]]!!) {
                        li.addLast(hm[rem]!![i])
                    }
                }
            }
        }
        return 0
    }
}
