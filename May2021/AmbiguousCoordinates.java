class Solution {

    // TC : O(n3)
    // SC : O(1)
    public List<String> ambiguousCoordinates(String S) {

        S = S.substring(1, S.length() - 1); // 123

        List<String> result = new ArrayList<>();

        for (int i = 1; i < S.length(); i++) {

            String leftSubstring = S.substring(0,i);
            String rightSubstring = S.substring(i, S.length());

            Set<String> leftParts = generateValidRepresentations(leftSubstring);
            Set<String> rightParts = generateValidRepresentations(rightSubstring);

            for (String lp : leftParts) {
                for (String rp : rightParts) {
                    result.add("(" + lp + ", " + rp + ")");
                }
            }
        }
        return result;
    }

    private Set<String> generateValidRepresentations(String s) {
        int l = s.length();
        char[] cs = s.toCharArray();

        Set<String> possibleRepresentationsOfS = new HashSet<>();

        if (cs[0] == '0' && cs[l - 1] == '0') { // "0xxxx0" Invalid unless a single "0"
            if (l == 1) {
                possibleRepresentationsOfS.add("0");
            }
            return possibleRepresentationsOfS;
        }

        if (cs[0] == '0') { // "0xxxxx" The only valid result is "0.xxxxx"
            possibleRepresentationsOfS.add("0." + s.substring(1));
            return possibleRepresentationsOfS;
        }
        if (cs[l - 1] == '0') { // "xxxxx0" The only valid result is itself
            possibleRepresentationsOfS.add(s);
            return possibleRepresentationsOfS;
        }

        // XXXXX
        for (int i = 1; i < l; i++) { // "xxxx" -> "x.xxx", "xx.xx", "xxx.x"
            possibleRepresentationsOfS.add(s.substring(0, i) + '.' + s.substring(i));
        }
        possibleRepresentationsOfS.add(s);
        return possibleRepresentationsOfS;
    }
}