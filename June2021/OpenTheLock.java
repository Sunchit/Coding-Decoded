class Solution {

    private  Set<String> visited  = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) return -1;

        for(String deadend : deadends){
            visited.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                String currentLock = queue.poll();
                if (visited.contains(currentLock)) continue;
                if (currentLock.equals(target)) return level;

                for (String nextLock : getNextStates(currentLock)) {
                    if (!visited.contains(nextLock)) queue.offer(nextLock);
                }
                visited.add(currentLock);
            }
            level++;
        }

        return -1;
    }

    private Set<String> getNextStates(String lock) {
        Set<String> newLocks = new HashSet<>();
        char[] lockChar = lock.toCharArray();
        for (int i = 0; i < 4; i++) {

            char c = lockChar[i];
            // moving clockwise
            lockChar[i] = c == '9' ? '0' : (char) (c + 1);
            newLocks.add(new String(lockChar));
            // moving anticlockwise
            lockChar[i] = c == '0' ? '9' : (char) (c -1);
            newLocks.add(new String(lockChar));
            lockChar[i] = c;
        }
        return newLocks;
    }
}