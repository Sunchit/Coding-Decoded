//  @saorav21994

class Solution {
    public boolean halvesAreAlike(String s) {

        // A - 65, E - 69, I - 73, O - 79, U - 85
        // a - 97, e - 101, i - 105, o - 111, u - 117
        
        int l = s.length();
        int v = 0;
        
        for (int i = 0; i < l/2; i++) {
            int asc = (int)s.charAt(i);
            switch(asc) {
                case 65:
                case 69:
                case 73:
                case 79:
                case 85:
                case 97:
                case 101:
                case 105:
                case 111:
                case 117:
                    v += 1;       
                break;
            }
        }
        for (int i = l/2; i < l; i++) {
            int asc = (int)s.charAt(i);
            switch(asc) {
                case 65:
                case 69:
                case 73:
                case 79:
                case 85:
                case 97:
                case 101:
                case 105:
                case 111:
                case 117:
                    v -= 1;       
                break;
            }
        }
        return (v==0);
    }

    
}
