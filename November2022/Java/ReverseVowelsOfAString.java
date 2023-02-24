// @saorav21994

class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        Set<Character> set = new HashSet<>();
        
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char [] arr = s.toCharArray();

        while (i < j) {
         
            while (i < j) {
                char ch = arr[i];
                if (set.contains(ch))
                    break; 
                i += 1;
            }

            while (j > i) {
                char ch = arr[j];
                if (set.contains(ch))
                    break; 
                j -= 1;
            }

            if (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

            i += 1;
            j -= 1;

        }
        
        return String.valueOf(arr);

    }
}
