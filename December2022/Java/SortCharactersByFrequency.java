// @saorav21994

class Solution {
    public String frequencySort(String s) {
        
        int [][] freq = new int[62][2];

        int l = s.length();
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                freq[(int)ch-48][1] += 1;
                freq[(int)ch-48][0] = (int)ch;
            }
            else {
                int c = (int)ch;
                if (c >= 65 && c <= 91) {
                    freq[(int)ch-65+10][1] += 1;
                    freq[(int)ch-65+10][0] = c;
                }
                else {
                    freq[(int)ch-97+36][1] += 1;
                    freq[(int)ch-97+36][0] = c;
                }
            }
        }

        Arrays.sort(freq, (a,b) -> (b[1] - a[1]));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 62; i++) {
            if (freq[i][0] != 0) {
                for (int j = 0; j < freq[i][1]; j++) {
                    sb.append((char)freq[i][0]);
                }
            }
            else
                break;
        }

        return sb.toString();

    }
}
