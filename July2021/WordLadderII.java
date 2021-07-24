class Solution {

    private class Node {
        public String value;
        public Node previous;
        Node(String value) { this.value = value; }
        Node(String value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> list = new HashSet<>(wordList);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0)
                Node head = queue.poll();
                for (String neighborStr : neighbors(list, head.value)) {
                    Node neighbor = new Node(neighborStr, head);
                    if (neighbor.value.equals(endWord)) {
                        addNode(res, neighbor);
                        break;
                    }
                    queue.offer(neighbor);
                }
            }
            if (res.size() > 0) break;
        }
        return res;
    }


    private Set<String> neighbors(Set<String> list, String s) {
            list.remove(s);
            Set<String> res = new HashSet<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chars[i] == ch) continue;
                    char tmp = chars[i];
                    chars[i] = ch;
                    String word = new String(chars);
                    if (list.contains(word)) res.add(word);
                    chars[i] = tmp;
                }
            }
            return res;
        }


     private void addNode(List<List<String>> list, Node p) {
        LinkedList<String> ladder = new LinkedList<>();
        while (p != null) {
            ladder.addFirst(p.value);
            p = p.previous;
        }
        list.add(ladder);
    }

}

