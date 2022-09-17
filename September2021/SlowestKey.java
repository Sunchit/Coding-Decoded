class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int maxReleaseTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > maxReleaseTime) {
                maxReleaseTime = releaseTimes[i] - releaseTimes[i - 1];
                result = keysPressed.charAt(i);
            } else if (releaseTimes[i] - releaseTimes[i - 1] == maxReleaseTime && keysPressed.charAt(i) > result) {
                result = keysPressed.charAt(i);
            }
        }
        return result;
    }
}