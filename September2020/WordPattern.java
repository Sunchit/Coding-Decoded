// Time complexity => O(n), where n is the length of the pattern
// Space complexity is O(n) where n is the no of words in the map
class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strValues=str.split(" ");
        if(strValues.length !=pattern.length()) {
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            Character key = pattern.charAt(i);
            String strValue = strValues[i];
            if(map.containsKey(key)){
                String existingValue = map.get(key);
                if(!existingValue.equals(strValue)){
                    return false;
                }
            } else {
                if(set.contains(strValue)){
                    return false;
                } else{
                    set.add(strValue);
                    map.put(key, strValue);
                }
            }
        }
        return true;

    }
}
