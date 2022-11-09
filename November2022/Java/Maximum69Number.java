// @saorav1994
class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        char [] arr = str.toCharArray();
        int l = str.length();
        int firstSix = -1;
        int lastNine = l;
        for (int i = 0; i < l; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}
