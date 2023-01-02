// @saorav21994

class Solution {
    public boolean detectCapitalUse(String word) {
        String upCase = word.toUpperCase();
        String downCase = word.toLowerCase();
        char firstChar = word.charAt(0);
        String firstCharCase = String.valueOf(firstChar).toUpperCase() + word.toLowerCase().substring(1, word.length());
        if (word.equals(upCase) || word.equals(downCase) || word.equals(firstCharCase))
            return true;
        return false;
    }
}
